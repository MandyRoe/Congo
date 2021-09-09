<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
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
        
    if(sessionCart_list!=null){                                     //get cart with items
    	request.setAttribute("sessionCart_list", sessionCart_list);
    	
    }
    
    int maxOrderID = 0;
    Connection connection;
    connection = DbCon.getConnection();
    String sql = "select max(orderid) from ORDERS";
    Statement statement = connection.createStatement();                // statement verbindung zur Datenbank
    ResultSet rs = statement.executeQuery(sql)    ;
    while (rs.next()) {
	maxOrderID = ((Number) rs.getObject(1)).intValue();
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

            	
 <div class="card-header my-3">Order Confirmation</div>     
<div>Your Order Number:</div>
<br>
<input type ="text" class="form-control" name="order-number" value="<%=maxOrderID %>" readonly>
<br>
<div>If you are logged in, you can always check your order again under the Orders tab</div>
</div>

</body>
<%@include file="includes/footer.jsp" %>
</html>