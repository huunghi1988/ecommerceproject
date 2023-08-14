package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Product;
import coding.ecommerceproject.entity.User;

public class UserService {
	public  List<User> getAllUsers() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.Users ");

			rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("userId");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");

				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String postcode = rs.getString("postcode");
				String phoneNumber = rs.getString("phoneNumber");
				Timestamp createdAt = rs.getTimestamp("createdAt");

				user = new User(userId, userName, email, password, firstName, lastName, address, city, state, postcode,
						phoneNumber, createdAt);
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

			ps = conn.prepareStatement("SELECT email FROM sql6631093.Users where email  =? ");

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
