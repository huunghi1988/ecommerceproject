package coding.ecommerceproject.db.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static  Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			  Connection conn = DriverManager.getConnection(
//			  "jdbc:mysql://34.173.52.85/be4_project?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
//			  "huunghi_be4", "P@ssword123");
			 
			Connection conn = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6631093?useLegacyDatetimeCode=false&serverTimezone=UTC", "sql6631093",
				"58t8l8AiM5");
//			
			System.out.println(conn);
return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
