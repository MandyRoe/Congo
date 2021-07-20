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

		// int i = Integer.parseInt(req.getParameter("num1")); bei int muss geparsed
		// werden

		String i = req.getParameter("product"); // abgefragter textfeld name im html
		if (i != null) {

			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);
			if (product != null) {
				productList.add(product);
				Productmanager.addProductDB(i);

				System.out.println("Produkt in Warenkorb hinzugefügt");

				System.out.println("Current Cart: ");
				for (int a = 0; a < productList.size(); a++) {
					System.out.print("[" + productList.get(a).getName().toString() + "]");
				}
			} else {
				System.out.println("Ungültiges Produkt");
			}
			req.setAttribute("Product", product);
			req.getRequestDispatcher("productDetails.jsp").forward(req, res);

		} else {
			JavaOracleTest.startDB();
			Product product = Productmanager.getProduct(i);
			if (productList.size() - 1 >= 0) {
				productList.remove(productList.size() - 1);
				Productmanager.deleteProductDB();
			} else {
				System.out.println("Der Warenkorb ist bereits leer");
			}

			System.out.println("Current Cart: ");
			for (int a = 0; a < productList.size(); a++) {
				System.out.print("[" + productList.get(a).getName().toString() + "]");
			}

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
