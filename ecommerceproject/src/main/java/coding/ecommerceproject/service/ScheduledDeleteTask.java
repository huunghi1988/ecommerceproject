package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.User;

public class ScheduledDeleteTask extends TimerTask {

	private final String email;

	public ScheduledDeleteTask(String email) {
		this.email = email;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("DELETE FROM `sql6631093`.`verification_token` WHERE email = ?",
					java.sql.Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, email);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
