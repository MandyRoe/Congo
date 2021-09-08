<%@page import="dao.*"%>
<%@page import="connection.*"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
User auth = (User) request.getSession().getAttribute("auth"); //auth ist user objekt deswegen müssen wir casten
if (auth != null) {
	request.setAttribute("auth", auth);

}


%>




<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	<div class="container">
	
	
	

<div class="col-md-4 my-4">
		<div class="card w-100" style="width: 18rem;">                                      <!-- größe der angezeigten Produktcards -->
	 	 <img class="card-img-top" src="product_images/${Product.image}" alt="missing image"> 
		  <div class="card-body">
		    <h5 class="card-title"><${Product.name} </h5>
		    <h6 class="price">Price: ${Product.price}</h6>                            <!-- jeweils Anzeige der Werte in Datenbank  -->
		    <h6 class="category">Category: ${Product.category}</h6>
			<h6 class="describtion">Category: ${Product.descr}</h6>
		
		<div class="mt-3 d-flex justify-content-between">
		   <a href="add-to-cart?id=${Product.itmnbr}" class="btn btn-dark">Add to Cart</a>                           <!-- Itemnumber wird aus der URL geholt  Buttons pro Card -->
		 </div>
		   
		  
		  </div>
		</div>
		</div>
	<h1>insert product details here</h1>

</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>