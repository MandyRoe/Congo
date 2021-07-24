package servlets;

import model.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DbCon;
import dao.ProductDao;


@WebServlet("/product-details")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int itemnumber = Integer.parseInt(request.getParameter("id"));
		try {
		
		ProductDao pd = new ProductDao(DbCon.getConnection());
		
		
		request.setAttribute("Product", pd.getSinlgeProduct(itemnumber));
		request.getRequestDispatcher("product.jsp").forward(request, response);
		
		
		
		
		
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		

		
		
		
	}

}
