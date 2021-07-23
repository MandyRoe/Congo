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
List<Cart> cartProduct = null;    
	if(sessionCart_list!=null){
		
		ProductDao pDao = new ProductDao(DbCon.getConnection());
		cartProduct = pDao.getCartProducts(sessionCart_list);                                       //get cart with items
		double total = pDao.getTotalCartPrice(sessionCart_list);
		request.setAttribute("sessionCart_list", sessionCart_list);
		request.setAttribute("total", total);
}
    
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>
<%@include file="includes/head.jsp" %>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre {
box-shadow: none;
font-size : 25px;
}
</style>

</head>
<body>
<%@include file="includes/navbar.jsp" %>




<div class="container">
<div class="d-flex py-3"><h3>Total Price: Euro ${ (total>0)?total:0 }  </h3><a class="mx-3 btn btn-primary" href="#">Check Out</a> </div>    <!--  total price aus cart list aus der session, ansonsten 0 -->

<table class="table table-light"> 
<thead>
<tr>
<th scope="col">Name</th>
<th scope="col">Category</th>
<th scope="col">Price</th>
<th scope="col">Buy Now</th>
<th scope="col">Cancel</th>
</tr>
</thead>
<tbody> 

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

		<a class="btn btn-small btn-incre" href="quantity-inc-dec"><i class="fas fa-plus-square"></i> </a>     	 <!-- plus button -->
		<input type="text" name="quantity" class="form-control" value="1" readonly>							 <!-- Anzeigefeld Menge -->
		<a class="btn btn-small btn-decre" href="quantity-inc-dec"><i class="fas fa-minus-square"></i> </a>       	 <!-- minus button -->
		</div>

		</form>

		</td>
		<td><a class="btn btn sm btn-danger" href="#">remove</a></td>
		</tr>
<% 	}
	
} %>



</tbody>


</table>
</div>



<%@include file="includes/footer.jsp" %>
</body>
</html>