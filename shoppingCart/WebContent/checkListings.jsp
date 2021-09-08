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
<div class="card-header my-3">Products</div>
 <br> <br>
	<div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="Change Listings.jsp">Change Listings</a>
		</div>
	
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEMNUMBER</th>
					<th scope="col">NAME</th>
					<th scope="col">DESCR</th>
					<th scope="col">PRICE</th>
					<th scope="col">CATEGORY</th>
				</tr>
			</thead>
			<tbody>
			<%
			Connection connection = DbCon.getConnection();
			String sql = "select ITEMNUMBER, NAME, DESCR, PRICE, CATEGORY from PRODUCTS";
			
			try {
				
	           Statement statement = connection.createStatement();				// statement verbindung zur Datenbank
	           ResultSet rs = statement.executeQuery(sql);						//Ausführung des Strings in Datenbank
	          
	           
	           while  (rs.next()) {

				%>
				
				<tr>
					<td><%=rs.getInt("ITEMNUMBER")%></td>
					<td><%=rs.getString("NAME")%></td>
					<td><%=rs.getString("DESCR")%></td>
					<td><%=rs.getInt("PRICE")%></td>
					<td><%=rs.getString("CATEGORY")%></td>
				</tr>	
				<% }} catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();}%>
            </tbody>
           
          
            </table>
            </div> 
            </body>
            <%@include file="includes/footer.jsp" %>
            </html>
            