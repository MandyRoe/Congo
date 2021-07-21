package ServletPackage;

import DBConnection.JavaOracleTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Cart")
public class CartServlet extends HttpServlet implements listable {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		String i = req.getParameter("product"); 							// abgefragter textfeld name im html
		if (i != null) {

			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);
			if (product != null) {				
				
				Productmanager.addProductDB(i);


				Productmanager.printCart();
				
			} else {
				System.out.println("Ungültiges Produkt");
			}
			req.setAttribute("Product", product);
			req.getRequestDispatcher("productDetails.jsp").forward(req, res);

		} else {
			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);
			
				Productmanager.deleteProductDB();
				
				Productmanager.printCart();

			req.setAttribute("Product", product);
			req.getRequestDispatcher("productDetails.jsp").forward(req, res);

		}

		System.out.println();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//int i = Integer.parseInt(req.getParameter("num1")); bei int muss geparsed
		// werden

