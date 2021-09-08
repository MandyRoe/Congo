package servlets;
import connection.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeUserDataPOG
 */
@WebServlet("/RegisterProduct")
public class RegisterProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
			
			String sql = "select NAME from PRODUCTS";
			
			String sql1 = "INSERT INTO PRODUCTS(NAME, DESCR, PRICE, CATEGORY) VALUES ('"+request.getParameter("NAME")+
                    "', '"+request.getParameter("DESCR")+
                    "', '"+request.getParameter("PRICE")+
                    "', '"+request.getParameter("CATEGORY")+"')";
            System.out.println(sql1);

            try {

            	Integer counter = 0;
            	Statement statement = connection.createStatement();
    			ResultSet rs = statement.executeQuery(sql);
    			 while  (rs.next()) {
    				 String name = rs.getString("NAME");
    				 String testname = request.getParameter("NAME");
    				 System.out.println(name); 
    				 System.out.println(testname); 
    				 if (name.equals(testname)) {
    					 
    					 counter = counter + 1;
    				 }
    			 }
    			 System.out.println(counter);
    		if (counter == 0){
               Statement statement1 = connection.createStatement();                // statement verbindung zur Datenbank
               int rs1 = statement1.executeUpdate(sql1)    ;
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
		
