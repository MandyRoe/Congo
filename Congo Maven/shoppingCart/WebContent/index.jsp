<%@page import="java.util.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="dao.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 
 User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten
 if(auth != null){
 	 request.setAttribute("auth", auth);
 	
 } 
 
    ProductDao pd = new ProductDao(DbCon.getConnection());
    List<Product> products = pd.getAllProducts();
    
       
    
    ArrayList<Cart> sessionCart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        
    if(sessionCart_list!=null){                                     //get cart with items
    	request.setAttribute("sessionCart_list", sessionCart_list);
    	
    }
        

 %>      
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container"> 
<div class="card-header my-3">All Products</div>
<div class="row">



<% if(!products.isEmpty()){                                                                 // Schleife geht durch alle Produkte und Werte in Datenbank
	for(Product p:products){ %>
		<div class="col-md-4 my-4">
		<div class="card w-100" style="width: 18rem;">                                      <!-- größe der angezeigten Produktcards -->
		 <a href="product-details?id=<%=p.getItmnbr()%>"> <img class="card-img-top" src="product_images/<%= p.getImage()%>"  alt="Error loading Image"> </a>
		  <div class="card-body">
		    <h5 class="card-title"><%=p.getName() %></h5>
		    <h6 class="price">Price: $<%= p.getPrice() %></h6>                            <!-- jeweils Anzeige der Werte in Datenbank  -->
		    <h6 class="category">Category: <%= p.getCategory() %></h6>
		
		
		 <div class="mt-3 d-flex justify-content-between">
		   <a href="add-to-cart?id=<%=p.getItmnbr()%>" class="btn btn-dark">Add to Cart</a>                           <!-- Itemnumber wird aus der URL geholt  Buttons pro Card -->
		     <a href="#" class="btn btn-primary">Buy now</a>
		 </div>
		   
		  
		  </div>
		</div>
		</div>
	
	<% }
	
} 
%>


</div>
</div>



<%@include file="includes/footer.jsp" %>
</body>
</html>