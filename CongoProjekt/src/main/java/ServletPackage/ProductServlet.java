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
public class ProductServlet extends HttpServlet implements listable {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//	int i = Integer.parseInt(req.getParameter("num1"));                  //bei int muss geparsed werden
			
		
			String i = req.getParameter("product");                                 //abgefragter Datentyp          parameter linked to htmlfile
			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);                     //im Productmanager int oder String
			req.setAttribute("Product", product);                               
			req.getRequestDispatcher("productDetails.jsp").forward(req, res);       //benutzte jsp Datei
			System.out.println("Produkt wurde an jsp gesendet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


