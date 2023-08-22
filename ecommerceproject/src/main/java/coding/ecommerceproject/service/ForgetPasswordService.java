package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import coding.ecommerceproject.db.util.DBUtil;

public class ForgetPasswordService {

	public static void setForgetPasswordToken(String email) throws SQLException {
		VerificationToken token = new VerificationToken();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"INSERT INTO `sql6631093`.`forgetpassword_token` (`email`, `token`,`expiration`) VALUES (?, ?,?) ON DUPLICATE KEY UPDATE `token` = ? , `expiration`=?  ",
					java.sql.Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, email);
			ps.setString(2, token.getToken());
			ps.setTimestamp(3, token.getExpirationDateTime());
			ps.setString(4, token.getToken());
			ps.setTimestamp(5, token.getExpirationDateTime());


			ps.executeUpdate();
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
	}
}
