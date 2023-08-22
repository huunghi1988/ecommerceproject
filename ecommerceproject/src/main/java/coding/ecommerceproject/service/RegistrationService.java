package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.User;

public class RegistrationService {

	@SuppressWarnings("resource")
	public static User registerNewUser(String email, String password, String username, String firstName,
		String lastName) throws SQLException {
		VerificationToken token = new VerificationToken();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"INSERT INTO `sql6631093`.`user` (`username`, `email`, `password`, `first_name`,`last_name`) VALUES (?, ?, ?, ?,?) ",
					java.sql.Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, firstName);
			ps.setString(5, lastName);

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				ps = conn.prepareStatement(
						"INSERT INTO `sql6631093`.`verification_token` (`email`, `token`,`expiration`) VALUES (?, ?,?) ",
						java.sql.Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, email);
				ps.setString(2, token.getToken());
				ps.setTimestamp(3, token.getExpirationDateTime());

				ps.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return user;
	}
	

}
