<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%
DecimalFormat dcf = new DecimalFormat("#.##"); //max 2 nachkommastellen
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth"); //auth ist user objekt deswegen müssen wir casten
if (auth != null) {
	request.setAttribute("auth", auth);

}

ArrayList<Cart> sessionCart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (sessionCart_list != null) {

	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct = pDao.getCartProducts(sessionCart_list); //get cart with items
	double total = pDao.getTotalCartPrice(sessionCart_list);
	request.setAttribute("sessionCart_list", sessionCart_list);
	request.setAttribute("total", total);
}
%> 
    
    
    
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>


<h1>Rechte </h1> 
 <br> <br>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ORDERID</th>

				</tr>
			</thead>
			<tbody>

				
			<tr>
				
			<form 	action="OrderCheck.jsp" method="post">
					<td> <input type="text" id="ORDERID" name="ORDERID" value=""></td>
					<td> <input type="submit"></td>  
					
			</form>
				<% String orderid = request.getParameter("ORDERID");
				   HttpSession sess = request.getSession(); 
				   sess.setAttribute("ORDERID", orderid);
						%>

			</tr>	
				
            </tbody>
            
            </table>
            </body>
            </html>