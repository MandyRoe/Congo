<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten  
if(auth != null){
	 request.setAttribute("auth", auth);}%>

<%  if(auth!= null && auth.getRechte()== 5){    %>           															<!-- if user not logged in logout & orders visible-->
		<meta http-equiv="refresh" content="0; url=http://example.com/" />
		<p><a href="http://example.com/">Redirect</a></p> 
    <% } %>


	


<html>
<head>
<title>Orders</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>


<div class="container">
<h1>LISTINGS </h1> 
 <br> <br>
	<div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="ChangeUsers.jsp">Change Listings</a>
		</div>
	
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEMNUMBER</th>
					<th scope="col">NAME</th>
					<th scope="col">DESCR</th>
					<th scope="col">PRICE</th>
					<th scope="col">CATEGORY</th>
					<th scope="col">QUANTITY</th>
				</tr>
			</thead>
			<tbody>
			<%
			Connection connection = DbCon.getConnection();
			HttpSession sess = request.getSession();
			
			
			String sql = "select PRODUCTID from ORDERS WHERE ORDERID = "+request.getParameter("ORDERID");
			try {
				
			
				Statement statement = connection.createStatement();				// statement verbindung zur Datenbank
		        ResultSet rs = statement.executeQuery(sql);	
				while  (rs.next()) {
					String sql1 = "select * from PRODUCTS WHERE ITEMNUMBER = "+rs.getInt("PRODUCTID");
				
				
	          	  Statement statement1 = connection.createStatement();				// statement verbindung zur Datenbank
	           	  ResultSet rs1 = statement1.executeQuery(sql1);						//Ausführung des Strings in Datenbank
	          
	           
	          	 	while  (rs1.next()) {
	           					
			%>
				
						<tr>
							<td><%=rs1.getInt("ITEMNUMBER")%></td>
							<td><%=rs1.getString("NAME")%></td>
							<td><%=rs1.getString("DESCR")%></td>
							<td><%=rs1.getInt("PRICE")%></td>
							<td><%=rs1.getString("CATEGORY")%></td>
							<td>@AlexQuantityAlsogetInt</td>
						</tr>	
						<% 
					}
	           }
			}	
					catch (SQLException e) {
	           		 System.out.println("ups, error");
	            		e.printStackTrace();}%>
            </tbody>
           
          
            </table>
            </div> 
            </body>
            </html>
            