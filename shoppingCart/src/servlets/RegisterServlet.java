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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
			
			
			String sql = "select EMAIL from USERS";
			
			String sql1 = "INSERT INTO USERS(NAME, EMAIL, PASSWORD) VALUES ('"+request.getParameter("register-name")+
                    "', '"+request.getParameter("register-email")+
                    "', '"+request.getParameter("register-password")+"')";
            System.out.println(sql1);

            try {

            	Integer counter = 0;
            	Statement statement = connection.createStatement();
    			ResultSet rs = statement.executeQuery(sql);
    			 while  (rs.next()) {
    				 String email = rs.getString("EMAIL");
    				 String testemail = request.getParameter("register-email");
    				 System.out.println(email); 
    				 System.out.println(testemail); 
    				 if (email.equals(testemail)) {
    					 
    					 counter = counter + 1;
    				 }
    			 }
    			 System.out.println(counter);
    		if (counter == 0){
               Statement statement1 = connection.createStatement();                // statement verbindung zur Datenbank
               int rs1 = statement1.executeUpdate(sql1)    ;
               response.sendRedirect("loginSuccess.jsp");
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
		
