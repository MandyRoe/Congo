package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	

	
	
	public static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "fhdw1993");
			
      
		}
		
		return connection;
	}
    


}
