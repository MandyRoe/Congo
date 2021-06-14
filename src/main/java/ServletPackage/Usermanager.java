package ServletPackage;

import java.sql.*;
import DBConnection.JavaOracleTest;


public class Usermanager {
	public static User getUser(Integer i) {
		
        Connection connection = JavaOracleTest.connection;
		String sql = "select * from students where ID = " + i.toString();
		
		try {
			
           Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery(sql);
          
           
           while  (rs.next()) {
        	   Integer ID = rs.getInt("ID");
        	   String name = rs.getString("NAME");
        	   String email = rs.getString("EMAIL");
        	   
        	   System.out.println("Printed: " + ID + name + email);
        	   return new User (ID, name, email);
           }
            
			
		
		}
		catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();
        }
			
		return	null;
	}
}


/*   String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " 
   			+ "VALUES('Tobsi', 'my@company.de')";*/
//int rows = statement.executeUpdate(sql);