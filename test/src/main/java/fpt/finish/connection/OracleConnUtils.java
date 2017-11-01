package fpt.finish.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class OracleConnUtils {
  
	public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/huongdichvu?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception er) {
			er.printStackTrace();
		}
		return con;
	 }
}
