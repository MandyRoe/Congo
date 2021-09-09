<%@page import="dao.*"%>
<%@page import="connection.*"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
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
	<div class="card-header my-3">Product Details</div>
	
	
<div class="row">
<div class="col-md-4 my-4">
		<div class="card w-100" style="width: 18rem;">                                      <!-- größe der angezeigten Produktcards -->
	 	 <form action = product-details> <img class="card-img-top" src="product_images/${Product.image}"  alt="Error loading Image"> </a></form> 
		  <div class="card-body">
		    <h5 class="card-title"><${Product.name} </h5>
		    <h6 class="price">Price: ${Product.price}$ per piece</h6>                            <!-- jeweils Anzeige der Werte in Datenbank  -->
		    <h6 class="category">Category: ${Product.category}</h6>
		
		
		 <div class="mt-3 d-flex justify-content-between">
		   <a href="add-to-cart?id=${Product.itmnbr}" class="btn btn-dark">Add to Cart</a>                           <!-- Itemnumber wird aus der URL geholt  Buttons pro Card -->
		 </div>
		   
		  
		  </div>
		</div>
		</div>
		<div class="col-md-4 my-4">
		<div class="card w-100" style="width: 18rem;">                                      <!-- größe der angezeigten Produktcards -->
			<h6 class="describtion">${Product.descr}</h6>
  </div>
		  </div>
		  
		  
		</div>
		</div>

</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>