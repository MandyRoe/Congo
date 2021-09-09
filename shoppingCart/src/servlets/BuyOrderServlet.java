package servlets;
import connection.*;
import dao.*;
import model.Cart;
import model.User;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/BuyOrderServlet")
public class BuyOrderServlet extends HttpServlet {
	
	
	
	
	private static final long serialVersionUID = 1L;
  
	
	
    public BuyOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		Connection connection;
		try {
			connection = DbCon.getConnection();
			
			User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten
			if(auth != null){
				 request.setAttribute("auth", auth);
				
			} 


			ArrayList<Cart> sessionCart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");       
			List<Cart> cartProduct = null;    
				if(sessionCart_list!=null){
					
					ProductDao pDao = new ProductDao(DbCon.getConnection());
					cartProduct = pDao.getCartProducts(sessionCart_list);                                       //get cart with items
					double total = pDao.getTotalCartPrice(sessionCart_list);
					request.setAttribute("sessionCart_list", sessionCart_list);
					request.setAttribute("total", total);
				}
            try {
            	
            	
            	
            	String sql = "select max(orderid) from ORDERS";
                System.out.println(sql);
                Statement statement = connection.createStatement();                // statement verbindung zur Datenbank
                ResultSet rs = statement.executeQuery(sql)    ;
                while (rs.next()) {
            	int maxOrderID = ((Number) rs.getObject(1)).intValue();
            	int maxorderID = maxOrderID ++;
            	
            	
            	
            	for (Cart c:cartProduct) {
                    
        			String sql1 = "INSERT INTO ORDERS (ORDERID, PRODUCTID, QUANTITY) VALUES ('"+maxOrderID+"', '"+c.getItmnbr()+
                            "', '"+c.getQuantity()+"')";
        			
                    System.out.println(sql1);
                    Statement statement1 = connection.createStatement();                // statement verbindung zur Datenbank
                    int rs1 = statement1.executeUpdate(sql1)    ;
                    
            		}
            	response.sendRedirect("orderConfirmation.jsp");
                }
               
            		

         
	           

				
			
			} catch (SQLException e) {
	               System.out.println("ups, error");
	               e.printStackTrace();}

		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		}
		
