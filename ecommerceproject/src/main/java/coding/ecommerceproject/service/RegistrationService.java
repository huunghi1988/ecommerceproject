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

public class RegistrationService {
	public static User registerNewUser(String email, String password, String username, String first_name, String last_name) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("INSERT INTO `be4_project`.`Users` (`username`, `email`, `password`, `first_name`,`last_name`) VALUES (?, ?, ?, ?,?)");
			
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, username);
			ps.setString(4, first_name);
			ps.setString(5, last_name);

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
		return user;
}}
