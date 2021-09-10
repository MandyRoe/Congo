<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.text.DecimalFormat"%>

<%
DecimalFormat dcf = new DecimalFormat("#.##"); //max 2 nachkommastellen
request.setAttribute("dcf", dcf);

User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten  
if(auth != null){
	 request.setAttribute("auth", auth);}%>

<%  if(auth!= null && auth.getRechte()!=4 && auth.getRechte()!=5 && auth.getRechte()!=6  ){    %>           															<!-- if user not logged in logout & orders visible-->
		<meta http-equiv="refresh" content="0; http://localhost:8080/shoppingCart/accessDenied.jsp" />
		
    <% } 
    
     
    
    
    
    
    
    %>


	


<html>
<head>
<title>Orders</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>


<div class="container">
<h1>Your Order </h1> 
 <br> <br>
	
	
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEMNUMBER</th>
					<th scope="col">NAME</th>
					<th scope="col">DESCRIPTION</th>
					<th scope="col">PRICE</th>
					<th scope="col">CATEGORY</th>
					<th scope="col">QUANTITY</th>
				</tr>
			</thead>
			<tbody>
			<%
			Connection connection = DbCon.getConnection();
			HttpSession sess = request.getSession();
			
			
			String sql = "select PRODUCTID, QUANTITY from ORDERS WHERE ORDERID = "+request.getParameter("ORDERID");
			try {
				
			
				Statement statement = connection.createStatement();				// statement verbindung zur Datenbank
		        ResultSet rs = statement.executeQuery(sql);	
				int quantity=0;
				
				while  (rs.next()) {
					String sql1 = "select * from PRODUCTS WHERE ITEMNUMBER = "+rs.getInt("PRODUCTID");
					quantity =rs.getInt("QUANTITY");
				
	          	  Statement statement1 = connection.createStatement();				// statement verbindung zur Datenbank
	           	  ResultSet rs1 = statement1.executeQuery(sql1);						//Ausführung des Strings in Datenbank
	          
	           
	          	 	while  (rs1.next()) {
	           					
			%>
				
						<tr>
							<td><%=rs1.getInt("ITEMNUMBER")%></td>
							<td><%=rs1.getString("NAME")%></td>
							<td><%=rs1.getString("DESCR")%></td>
							<td><%=dcf.format(rs1.getInt("PRICE"))%></td>
							<td><%=rs1.getString("CATEGORY")%></td>
								
						<% 
					}
	           	  
	           	  %> 
	           	  
	           	  <td><%=rs.getInt("QUANTITY")%></td>
						</tr>
	           	  
	           	  <% 
	           }
				
				
			}	
					catch (SQLException e) {
	           		 System.out.println("ups, error");
	            		e.printStackTrace();}%>
            </tbody>
           
          
            </table>
            <div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="orders.jsp">Back</a>
		</div>
            </div> 
            </body>
            </html>
            