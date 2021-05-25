package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaOracleTest {

		public static Connection connection;
      
        /*String dbURL = "jdbc:oracle:thin:@localhost:1521:XE"; //Portzahl jeweils anpassen!!!!
        String username = "system";
        String password = "fhdw1994";*/
  
        public static void startDB() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "fhdw1994");
            System.out.println("oracle DB connect success");
            
         /*   String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " 
            			+ "VALUES('Tobsi', 'my@company.de')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            
            if (rows > 0) {
            	System.out.println("row has been inserted");
            }
            */
            //connection.close();
            
        } catch (Exception e) {
            System.out.println("ups, error");
            e.printStackTrace();
        }
    }
    
}