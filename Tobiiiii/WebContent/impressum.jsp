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
<div class="container">
<h3>Congo AG  <br>
Congostraße 69  <br>
50000 Köln <br>
Email: info@congo.de <br>
Tel: 0228/112358<br>
Registergericht: Amtsgericht Bonn<br>
Registernummer: HRA 12345<br>
UstID: DE123456789<br>
Steuernummer: 11/222/33333<br>

</h3>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>