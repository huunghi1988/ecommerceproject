package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import coding.ecommerceproject.db.util.DBUtil;


public class ScheduledDeleteTask {
	private final static String DELETE_EXPIRED_VERIFICATION_TOKEN = "DELETE FROM `sql6631093`.`verification_token` WHERE email = ?";
	private final static String DELETE_EXPIRED_VERIFICATION_USER = "DELETE FROM `sql6631093`.`user` WHERE is_active = 0 and email = ?";

	public static void ScheduleVerificationRowDeletion(String email) throws SQLException {
		 final int expirationMinute = 1;// set exp 

		TimerTask task = new TimerTask() {
			public void run() {
				Connection conn = null;
				PreparedStatement ps = null;

				try {
					conn = DBUtil.makeConnection();

					ps = conn.prepareStatement(DELETE_EXPIRED_VERIFICATION_TOKEN);

					ps.setString(1, email);

					ps.executeUpdate();
					ps = conn.prepareStatement(DELETE_EXPIRED_VERIFICATION_USER);

					ps.setString(1, email);

					ps.executeUpdate();
					System.out.println("delete " + email);

				} catch (Exception e) {
					e.printStackTrace();

				}
			
			}
		};
		Timer timer = new Timer("Timer");
		long delay = expirationMinute*60000;
		timer.schedule(task, delay);
	}
}
