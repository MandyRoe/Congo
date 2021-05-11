package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaOracleTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "fhdw1993";

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("oracle DB connect success");
            
            String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " 
            			+ "VALUES('Tobsi', 'my@company.de')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            
            if (rows > 0) {
            	System.out.println("row has been inserted");
            }
            
            connection.close();
            
        } catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();
        }
    }

}