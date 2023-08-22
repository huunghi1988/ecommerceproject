package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Token;
import coding.ecommerceproject.entity.User;

public class UserService {
	public List<User> getAllUsers() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.user ");

			rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");

				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String city = rs.getString("suburb");
				String state = rs.getString("state");
				String postcode = rs.getString("postcode");
				String phoneNumber = rs.getString("phone_number");
				int isActive = rs.getInt("is_active");
				int forgetPassword = rs.getInt("forget_password");

				user = new User(userId, userName, email, password, firstName, lastName, address, city, state, postcode,
						isActive, forgetPassword, phoneNumber);
				list.add(user);
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
		return list;
	}

	public static int checkDuplicateUser(String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int isExisted = 0;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT email FROM sql6631093.user where email  =? ");

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

	public Token getToken(String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Token newtoken = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.verification_token where email  =? ");

			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				String token = rs.getString("token");
				Timestamp expiration = rs.getTimestamp("expiration");
				newtoken= new Token(email,token,expiration);
				
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
		return newtoken;
	}
	
	public static void setUserActive(String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("UPDATE `sql6631093`.`user` SET `is_active` = 1 WHERE (`email` = ?)");

			ps.setString(1, email);
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
	
	public static void setNewPassword(String email,String password) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("UPDATE `sql6631093`.`user` SET `password` = ? WHERE (`email` = ?)");
			ps.setString(1, password);

			ps.setString(2, email);
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
