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
import java.util.List;

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
		
		Integer itmnbr = 0;
		Integer itmnbr2 = 0;
		
		try {

			Statement statement = connection.createStatement(); 
			ResultSet rs = statement.executeQuery("SELECT ITEMNUMBER from PRODUCTS where NAME = UPPER('" + i + "')"); 

			while (rs.next()) {
				itmnbr = rs.getInt("ITEMNUMBER");
				System.out.println("itmnbr" + itmnbr);
			}
			
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("SELECT ITEMNUMBER from CART where ITEMNUMBER ="+itmnbr);
				
				while (rs2.next()) {
				itmnbr2 = rs2.getInt("ITEMNUMBER");
				System.out.println("itmnbr2" + itmnbr2);
				}
				
				
			if (itmnbr2 == 0) {
				Statement statement3 = connection.createStatement();
				statement3.executeUpdate("INSERT INTO CART (ITEMNUMBER) VALUES ( "+ itmnbr+")");
				
			
				Statement statement4 = connection.createStatement();
				ResultSet rs3 = statement4.executeQuery("SELECT * from CART where ITEMNUMBER ="+itmnbr);
			
				while (rs3.next()) {
					Integer amount = rs3.getInt("AMOUNT");
					
					Statement statement5 = connection.createStatement();
					statement5.executeUpdate("UPDATE CART SET AMOUNT = "+ new Integer(amount.intValue() + 1) +" where ITEMNUMBER ="+itmnbr);
				}
				
						
				
				
			}else {
								
			
				Statement statement7 = connection.createStatement();
				ResultSet rs4 = statement7.executeQuery("SELECT * from CART where ITEMNUMBER ="+itmnbr);
			
				while (rs4.next()) {
					Integer amount = rs4.getInt("AMOUNT");
				
				Statement statement4 = connection.createStatement();
				statement4.executeUpdate("UPDATE CART SET AMOUNT = "+ new Integer(amount.intValue() + 1) +" where ITEMNUMBER ="+itmnbr);
			}

				
				System.out.println("Produkt in Warenkorb hinzugefügt");
			}	
				
				

			

		} catch (SQLException e) {
			System.out.println("Error with inserting into Database (Cart)");
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
			System.out.println("Error with deleting from Database (Cart)");
			e.printStackTrace();
		}
		

		System.out.println("Produkt aus DB gelöscht");

		
	}
	
	
	public static List<Product> getCart() throws IOException {
		Connection connection = JavaOracleTest.connection;
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeQuery("Select * "
					+ "from products "
					+ "where Itemnumber in (select Itemnumber from cart) "
					+ "order by products.itemnumber");
		} catch (SQLException e) {
			System.out.println("Error with fetching from Database (Cart)");
			e.printStackTrace();
		}	
		
		return productList;
	}
	
	
	public static void printCart(){
		
	}
	
	

}

/*
 * String sql = "INSERT INTO STUDENTS (NAME, EMAIL) " +
 * "VALUES('Tobsi', 'my@company.de')";
 */
//int rows = statement.executeUpdate(sql);