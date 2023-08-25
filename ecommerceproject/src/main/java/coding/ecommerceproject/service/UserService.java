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
	private final static String GET_ALL_USERS = "SELECT * FROM sql6631093.user";
	private final static String GET_USER_DETAIL = "SELECT * FROM sql6631093.user where user_id = ?";
	private final static String CHECK_DUPLICATE_USER = "SELECT email FROM sql6631093.user where email  =? ";
	private final static String GET_TOKEN = "SELECT * FROM sql6631093.verification_token where email  =? ";
	private final static String SET_USER_ACTIVE = "UPDATE `sql6631093`.`user` SET `is_active` = 1 WHERE (`email` = ?)";
	private final static String SET_NEW_PASSWORD = "UPDATE `sql6631093`.`user` SET `password` = ? WHERE (`email` = ?)";


	public List<User> getAllUsers() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_ALL_USERS);

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

	
	public User getUserDetail(int userId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_USER_DETAIL);
			ps.setInt(1, userId);

			rs = ps.executeQuery();
			while (rs.next()) {
				
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

				user = new User(userId, userName,password, email, firstName, lastName, address, city, state, postcode,
						isActive, forgetPassword, phoneNumber);
				
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

			ps = conn.prepareStatement(CHECK_DUPLICATE_USER);

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

			ps = conn.prepareStatement(GET_TOKEN);

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
	
	public void setUserActive(String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(SET_USER_ACTIVE);

			ps.setString(1, email);
			ps.executeUpdate();
			System.out.println(ps);

		
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
	
	public void updateUserDetail(int userId,String firstName,String lastName,String address,String suburb,String state,String postcode,String phone,String email) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("UPDATE `sql6631093`.`user` SET  `email` = ?,  `first_name` = ?, `last_name` = ?, `address` = ?, `suburb` = ?, `state` = ?, `postcode` = ? ,`phone_number`= ? WHERE (`user_id` = ?)");
			ps.setString(1, email);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, address);
			ps.setString(5, suburb);
			ps.setString(6, state);
			ps.setString(7, postcode);
			ps.setString(8, phone);
			ps.setInt(9, userId);

			ps.executeUpdate();
			System.out.println(ps);

		
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

			ps = conn.prepareStatement(SET_NEW_PASSWORD);
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
