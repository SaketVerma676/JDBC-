import java.sql.DriverManager;

import java.sql.Connection; 

public class ConnectionProvider {
	static Connection con;
	
	public static Connection createC() {
		
		
		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// create connection
			String user ="root";
			String password="password";
			String url="jdbc:mysql://localhost:3306/student_advancejdbc";
			
			con=DriverManager.getConnection(url,user,password);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
