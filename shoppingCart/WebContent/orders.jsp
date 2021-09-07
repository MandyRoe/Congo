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
<%if(sessionCart_list !=null){
	for(Cart c:cartProduct){ %>
		<tr>
		<td><%= c.getName() %></td>
		<td><%= c.getCategory() %></td>
		<td><%= c.getPrice() %></td>                                                                                          <!-- for loop for each added item in cart  -->

		<td>
		<form action="" method="post" class="form-inline">
		<input type="hidden" name="id" value="<%=c.getItmnbr() %>" class="form-input">
		<div class="form-group d-flex justify-content-between"> 


		<input type="text" name="quantity" class="form-control" value="1" readonly>							 <!-- Anzeigefeld Menge -->
	
		</div>

		</form>

		</td>
		
		</tr>
<% 	}
	
} %>


<%@include file="includes/footer.jsp" %>
</body>
</html>