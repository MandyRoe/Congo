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
@WebServlet("/ChangeUserDataPOG")
public class ChangeUserDataPOG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserDataPOG() {
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
			
			String sql = "UPDATE USERS SET NAME = '"+request.getParameter("NAME")+
                    "', EMAIL = '"+request.getParameter("EMAIL")+
                    "', PASSWORD = '"+request.getParameter("PASSWORD")+
                    "', RECHTE = '"+request.getParameter("RECHTE")+
                    "' WHERE ID = '"+request.getParameter("ID")+"'";
            System.out.println(sql);

            try {

               Statement statement = connection.createStatement();                // statement verbindung zur Datenbank
               int rs = statement.executeUpdate(sql)    ;
               response.sendRedirect("ChangeUsers.jsp");
               
	           
	           

				
			
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
		
