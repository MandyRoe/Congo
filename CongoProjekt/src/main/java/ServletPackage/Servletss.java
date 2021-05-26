package ServletPackage;

import DBConnection.JavaOracleTest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletss
 */
@WebServlet("/Minus") //dasch ist URL
public class Servletss extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws ServletException, IOException {
			int i = Integer.parseInt(req.getParameter("num1"));
			int j = Integer.parseInt(req.getParameter("num2"));
			JavaOracleTest.startDB();
			User retard = Usermanager.getUser(i);
			int k = i + j;
			System.out.println("result is " + k);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
