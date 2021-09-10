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


<div class="container">

<div class="card w-50 mx-auto my-5">
<div class="card-header text-center" style="color:green">Success! <div class="col-my-2">You may now log in</div></div>

<div class="card-body">
<form action="user-login" method="post"> 

<div class="form-group">
<label>Email Address</label>
<input type ="email" class="form-control" name="login-email" placeholder="Enter your Email" required>
</div>

<div class="form-group">
<label>Password</label>
<input type ="password" class="form-control" name="login-password" placeholder="********" required>
</div>


<div class="text-center">
<button type="submit" class="btn btn-primary">Login</button>
</div>


</form> 
</div>
</div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>