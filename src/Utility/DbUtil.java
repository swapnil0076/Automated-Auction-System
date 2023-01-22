package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil {

//	private static String url;
//	private static  String driverName;
//	private static String username;
//	private static String password;
//	
//	
//	static {
//		
//		ResourceBundle rs = ResourceBundle.getBundle("dbdetails");
//		
//		url = rs.getString(url);
//		driverName = rs.getString(driverName);
//		username = rs.getString(username);
//		password = rs.getString(password);
//		
//	}
	
	
	public static Connection provideConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/constructweek";
		
		try {
			con = DriverManager.getConnection(url,"root","swapnil7Th!s");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
