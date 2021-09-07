package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDao {
	
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public UserDao(Connection connection) {
		this.connection = connection;

	}
	
	
	
	public User userLogin(String email, String password) {
		User user = null;
		
		
		
		try {
			query = "SELECT * from USERS where EMAIL =? and PASSWORD =?";               //ausdrucksweise gleich wie mit where email =" +email+" ... etc, 
			pst = this.connection.prepareStatement(query);                              //prevents sql injection 
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
		
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setRechte(rs.getInt("RECHTE"));
				
			}
			
		}	catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return user;
		
	}
	
	
	
	
	

}
