package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.User;

public class LoginService {
	private final static String GET_USER_BY_EMAIL_PASSWORD = "SELECT * FROM sql6631093.user where email  =? and password = ?";
	private final static String CHECK_DUPLICATE_EMAIL = "SELECT email FROM sql6631093.user where email  =?";

	
	public  User getUserByEmailAndPassword(String email, String password) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_USER_BY_EMAIL_PASSWORD);

			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			System.out.println(ps);
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("username");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String city = rs.getString("suburb");
				String state = rs.getString("state");
				String postcode = rs.getString("postcode");
				String phoneNumber = rs.getString("phone_number");
				int isActive = rs.getInt("is_active");
				int forgetPassword = rs.getInt("forget_password");

				user = new User(userId, userName, email, password, firstName, lastName, address, city, state, postcode,isActive,forgetPassword,
						phoneNumber);
				System.out.println(user.toString());
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

	public static int checkDuplicateUser(String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int isExisted = 0;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(CHECK_DUPLICATE_EMAIL);

			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				isExisted = 1;

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
		return isExisted;
	}

}
