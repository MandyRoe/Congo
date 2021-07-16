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


public class Productmanager {
	
	
    public static Product getProduct(String i) throws IOException {                //bei id int
        
         
        Connection connection = JavaOracleTest.connection;
       // String sql = "select * from products where ID = " + i.toString();         //nach was wird gesucht
         String sql = "select * from products where NAME = UPPER('" + i +"')";
        try {
            
           Statement statement = connection.createStatement();                // statement verbindung zur Datenbank
           ResultSet rsp = statement.executeQuery(sql);                        //Ausführung des Strings in Datenbank  rsp = result Set Product
          
           
           while  (rsp.next()) {
               
               Integer ID = rsp.getInt("ID");
               String name = rsp.getString("NAME");
               String descr = rsp.getString("DESCR");
               Integer price = rsp.getInt("PRICE");  
               Blob blob = rsp.getBlob("IMG");
               
               InputStream inputStream = blob.getBinaryStream();
               ByteArrayOutputStream outputStream = new ByteArrayOutputStream();         //bildanzeige
               byte[] buffer = new byte[4096];
               int bytesRead = -1;
                
               while ((bytesRead = inputStream.read(buffer)) != -1) {
                   outputStream.write(buffer, 0, bytesRead);                  
               }
                
               byte[] imageBytes = outputStream.toByteArray();
               String img64 = Base64.getEncoder().encodeToString(imageBytes);
                
                
               inputStream.close();
               outputStream.close();
               
               return new Product (ID, name, img64, descr, price);
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