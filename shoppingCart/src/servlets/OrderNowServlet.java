package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.User;


@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderNowServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){ 
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date = new Date();
			
			
			User auth =  (User)request.getSession().getAttribute("auth");
			if(auth !=null) {
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if (productQuantity <= 0) {							
					productQuantity =1;					//if User has no quantity of that item in cart and wants to buy it sets it to 1
				}
				
				
				Order orderModel = new Order();
				orderModel.setOrderId(Integer.parseInt(productId));
				orderModel.setUid(auth.getId());
				orderModel.setQuantity(productQuantity);
				orderModel.setDate(formatter.format(date));
				
			}else {
				response.sendRedirect("login.jsp");
			}
		}
				
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
	
		doGet(request, response);   //if user calls a doPost method it will redirect to the doGet method.. (cart = doPost, index = doGet)
	}

}
