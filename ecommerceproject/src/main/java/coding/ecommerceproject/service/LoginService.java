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
	public User getUserByEmailAndPassword(String email, String password) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM be4_project.Users where email  =? and password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				 int user_id = rs.getInt("user_id");
				 String username= rs.getString("username");			
				 String first_name= rs.getString("first_name");
				 String last_name= rs.getString("product_id");
				 String address= rs.getString("address");
				 String city= rs.getString("city");
				 String state= rs.getString("state");
				 String postcode= rs.getString("postcode");
				 String phone_number= rs.getString("phone_number");
				 Timestamp created_at= rs.getTimestamp("created_at");
				 Timestamp updated_at= rs.getTimestamp("updated_at");

				user = new User (user_id,username,first_name,last_name,address,password,city,state,postcode,phone_number,email, created_at,updated_at);
				
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
