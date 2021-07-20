package ServletPackage;

import DBConnection.JavaOracleTest;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletss
 */
@WebServlet("/User") //das ist die URL
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws ServletException, IOException {
			int i = Integer.parseInt(req.getParameter("id"));       
			JavaOracleTest.startDB();
			User retard = Usermanager.getUser(i);

			req.setAttribute("retard", retard); //string what u call in jsp file
			req.getRequestDispatcher("user.jsp").forward(req, res);
			
			System.out.println("User details sent");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


