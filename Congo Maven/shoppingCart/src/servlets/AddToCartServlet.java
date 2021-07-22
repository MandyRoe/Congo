package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {

			ArrayList<Cart> cartList = new ArrayList<>();

			int itemnumber = Integer.parseInt(request.getParameter("id"));
			Cart cart = new Cart();
			cart.setItmnbr(itemnumber);
			cart.setQuantity(1); // Default quantity in cart

			HttpSession session = request.getSession();
			ArrayList<Cart> sessionCart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); // get session
																									// attribute from
																									// cart

			if (sessionCart_list == null) { // if no attribute in cart = cart empty
				cartList.add(cart);
				session.setAttribute("cart-list", cartList); // create cart if empty
				response.sendRedirect("cart.jsp");
				
				
			} else {
				cartList = sessionCart_list;

				boolean exists = false;

				for (Cart c : cartList) {
					if (c.getItmnbr() == itemnumber) {
						exists = true;
						out.println("<h3 style= 'color:crimson; text-align: center'>Item already in Cart<a href='cart.jsp'>Go to Cart</a></h3>");
					}

				}
				if (!exists) {
					cartList.add(cart);
					out.println("added");
					response.sendRedirect("index.jsp");
				}

			}
		}

	}
}