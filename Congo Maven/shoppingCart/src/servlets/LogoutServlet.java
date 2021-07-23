package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter()){
			if(request.getSession().getAttribute("auth") != null) {                    //auth attribute from login servlet -> if exist = logged in session
				request.getSession().removeAttribute("auth");
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
