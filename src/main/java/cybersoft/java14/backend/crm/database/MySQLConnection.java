package cybersoft.java14.backend.crm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static String url = "jdbc:mysql://localhost:3306/crm-app";
	private static String username = "root";
	private static String password = "1234";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver MySQL Connection J.");
			e.printStackTrace();
		}
		
		return null;
	}
}
