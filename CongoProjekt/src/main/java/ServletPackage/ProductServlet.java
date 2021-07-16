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



@WebServlet("/Products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws ServletException, IOException {
		//	int i = Integer.parseInt(req.getParameter("num1"));                  //bei int muss geparsed werden
			String i = req.getParameter("name");                                 //abgefragter Datentyp
			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);                     //im Productmanager int oder String
			req.setAttribute("Product", product);                               
			req.getRequestDispatcher("NewProduct.jsp").forward(req, res);       //benutzte jsp Datei
			System.out.println("Produktaufruf erfolgreich");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


