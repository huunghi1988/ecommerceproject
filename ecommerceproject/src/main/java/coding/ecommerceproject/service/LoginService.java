package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.User;

public class LoginService {
	public static User getUserByEmailAndPassword(String email, String password) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.Users where email  =? and password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				 int userId = rs.getInt("userId");
				 String userName= rs.getString("username");			
				 String firstName= rs.getString("firstName");
				 String lastName= rs.getString("lastName");
				 String address= rs.getString("address");
				 String city= rs.getString("city");
				 String state= rs.getString("state");
				 String postcode= rs.getString("postcode");
				 String phoneNumber= rs.getString("phoneNumber");
				 Timestamp createdAt= rs.getTimestamp("createdAt");
				 Timestamp updatedAt= rs.getTimestamp("updatedAt");

				user = new User (userId,userName,email,password,firstName,lastName,address,city,state,postcode,phoneNumber, createdAt,updatedAt);
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

			ps = conn.prepareStatement("SELECT email FROM be4_project.Users where email  =? ");
			
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				isExisted=1;

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
