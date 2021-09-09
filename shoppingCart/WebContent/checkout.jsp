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
<title>Orders</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
<div class="card-header my-3">Your Order</div>
 <br> <br>


<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEM</th>
					<th scope="col">PRICE</th>
					<th scope="col">QUANTITY</th>
				</tr>
			</thead>

<%if(sessionCart_list !=null){
	for(Cart c:cartProduct){ %>

			<tbody>
	
		<tr>
		<td><%= c.getName() %></td>	
		<td><%= dcf.format(c.getPrice()) %></td>                                                                                         <!-- for loop for each added item in cart  -->
		<td><%=c.getQuantity()%></td>

		
		
		
		
<% 	}
	
} %>

</tr>
		</tbody>
		</table>

<%ArrayList<Cart> BuyCart = sessionCart_list;%>



<br> 
<form action="BuyOrderServlet" method="post"> 
<td><button type="submit" class="btn btn sm btn-primary" href="orderConfirmation.jsp">Buy</button></td>
</form>


<div class="ui form">
  <div class="grouped fields">
    <label>Payment method</label>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="payment" checked="checked">
        <label>PayPal</label>
      </div>
    </div>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="payment">
        <label>Überweisung</label>
      </div>
    </div>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="payment">
        <label>Rechnung</label>
      </div>
    </div>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="payment">
        <label>Kreditkarte</label>
      </div>
    </div>
  </div>
</div>


<div class="ui form">
  <div class="grouped fields">
    <label>Delivery Method</label>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="delivery" checked="checked">
        <label>Standard</label>
      </div>
    </div>
    <div class="field">
      <div class="ui radio checkbox">
        <input type="radio" name="delivery">
        <label>Premium</label>
      </div>
    </div>
      </div>
    </div>






</div>
</body>
<%@include file="includes/footer.jsp" %>
</html>