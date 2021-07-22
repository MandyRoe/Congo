package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import model.Cart;
import model.Product;


public class ProductDao {
	
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductDao(Connection connection) {
	this.connection = connection;
	}
	
	public List<Product> getAllProducts(){
		
		List<Product> products = new ArrayList<Product>();
		
		try {
			query= "select * from products";
			pst =this.connection.prepareStatement(query);
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Product row = new Product();
				row.setItmnbr((rs.getInt("ITEMNUMBER")));
				row.setName(rs.getString("NAME"));
				row.setDescr(rs.getString("DESCR"));
				row.setPrice((rs.getInt("PRICE")));
				row.setImage(rs.getString("IMG"));
				row.setCategory(rs.getString("CATEGORY"));
				
				products.add(row);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products = new ArrayList<Cart>();
		
		
		try {
			if(cartList.size()>0){
				for(Cart item:cartList) {
					query = "select * from PRODUCTS where ITEMNUMBER=?";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getItmnbr());
					rs=pst.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setItmnbr(rs.getInt("ITEMNUMBER"));
						row.setName(rs.getString("NAME"));
						row.setCategory(rs.getString("CATEGORY"));
						row.setPrice(rs.getFloat("PRICE")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						products.add(row);	
					}
				}
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return products;
		
	}
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		
		double sum = 0;
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "SELECT price from PRODUCTS where ITEMNUMBER =?";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getItmnbr());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						sum = sum + rs.getFloat("PRICE")*item.getQuantity();
					}
				}
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	
	
}
