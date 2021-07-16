package ServletPackage;

 

import java.io.FileReader;
import java.sql.*;
import DBConnection.JavaOracleTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

 

public class Usermanager {
    public static User getUser(Integer i) throws IOException {
        
         
        Connection connection = JavaOracleTest.connection;
        String sql = "select * from students where ID = " + i.toString();
        
        try {
            
           Statement statement = connection.createStatement();                // statement verbindung zur Datenbank
           ResultSet rs = statement.executeQuery(sql);                        //Ausführung des Strings in Datenbank
          
           
           while  (rs.next()) {
               
               Integer ID = rs.getInt("ID");
               String name = rs.getString("NAME");
               String email = rs.getString("EMAIL");  
               Blob blob = rs.getBlob("DOC");
               
               InputStream inputStream = blob.getBinaryStream();
               ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
               byte[] buffer = new byte[4096];
               int bytesRead = -1;
                
               while ((bytesRead = inputStream.read(buffer)) != -1) {
                   outputStream.write(buffer, 0, bytesRead);                  
               }
                
               byte[] imageBytes = outputStream.toByteArray();
               String img64 = Base64.getEncoder().encodeToString(imageBytes);
                
                
               inputStream.close();
               outputStream.close();
               
               //System.out.println("Printed: " + ID + name + email);
               return new User (ID, name, email, img64);
           }
            
            
        
        }
        catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();
        }
            
        return    null;
    }
}

 


/*   String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " 
               + "VALUES('Tobsi', 'my@company.de')";*/
//int rows = statement.executeUpdate(sql);