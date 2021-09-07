<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<% 
User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten
if(auth != null){
	 request.setAttribute("auth", auth);
	
} 


        ArrayList<Cart> sessionCart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        
    if(sessionCart_list!=null){                                     //get cart with items
    	request.setAttribute("sessionCart_list", sessionCart_list);
    	
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
<h1>THANK YOU FOR YOUR ORDER</h1>

<br> Your order number: 
<td>
		<form action="" method="post" class="form-inline">
		<input type="hidden" name="id" value="" class="form-input">
		<div class="form-group d-flex justify-content-between"> 
<input type="text" name="quantity" class="form-control" value="xyz" width="1" readonly>
</div></form></td>


<%@include file="includes/footer.jsp" %>
</body>
</html>