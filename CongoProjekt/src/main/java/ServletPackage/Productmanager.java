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

public class Productmanager implements listable {

	public static Product getProduct(String i) throws IOException { // bei id int

		Connection connection = JavaOracleTest.connection;
		// String sql = "select * from products where ID = " + i.toString(); //nach was
		// wird gesucht
		String sql = "select * from products where NAME = UPPER('" + i + "')";
		try {

			Statement statement = connection.createStatement(); // statement verbindung zur Datenbank
			ResultSet rs = statement.executeQuery(sql); // Ausführung des Strings in Datenbank rsp = result Set Product

			while (rs.next()) {

				Integer itmnbr = rs.getInt("ITEMNUMBER");
				String name = rs.getString("NAME");
				String descr = rs.getString("DESCR");
				float price = rs.getInt("PRICE");
				Blob blob = rs.getBlob("IMG");


				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // bildanzeige
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String img64 = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				System.out.println("Produkt wurde von DB angefragt");
				return new Product(itmnbr, name, img64, descr, price);

			}

		} catch (SQLException e) {
			System.out.println("error with getProduct");
			e.printStackTrace();
		}

		return null;
	}

	public static void addProductDB(String i) throws IOException {

		Connection connection = JavaOracleTest.connection;
		String sql = "select * from products where NAME = UPPER('" + i + "')";
		try {

			Statement statement = connection.createStatement(); 
			ResultSet rs = statement.executeQuery(sql); 

			while (rs.next()) {

				Integer itmnbr = rs.getInt("ITEMNUMBER");
				
				
				Statement statement2 = connection.createStatement();
				statement2.executeUpdate("insert into CART (ITEMID, ITEMNUMBER) values (seq_uid.nextval, " + itmnbr+")");

				System.out.println("Produkt in DB abgelegt");

			}


		} catch (SQLException e) {
			System.out.println("Error with inserting to Database");
			e.printStackTrace();
		}

	}
	
	
	public static void deleteProductDB() throws IOException {
		
		
		Connection connection = JavaOracleTest.connection;
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("delete FROM cart where itemid = (select max(itemid) from cart)");
			
		} catch (SQLException e) {
			System.out.println("Error with deleting from Database");
			e.printStackTrace();
		}
		

		System.out.println("Produkt aus DB gelöscht");

		
		
		
	}
	

}

/*
 * String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " +
 * "VALUES('Tobsi', 'my@company.de')";
 */
//int rows = statement.executeUpdate(sql);