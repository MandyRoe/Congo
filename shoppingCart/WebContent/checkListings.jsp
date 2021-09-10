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

<%  if(auth!= null && auth.getRechte()> 5){    %>           															<!-- if user not logged in logout & orders visible-->
		<meta http-equiv="refresh" content="0; http://localhost:8080/shoppingCart/accessDenied.jsp" />
	
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

	
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEMNUMBER</th>
					<th scope="col">NAME</th>
					<th scope="col">DESCRIPTION</th>
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
					<td><%=dcf.format(rs.getFloat("PRICE"))%></td>
					<td><%=rs.getString("CATEGORY")%></td>
				</tr>	
				<% }} catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();}%>
            </tbody>
           
          
            </table>
            <div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="Change Listings.jsp">Edit Listings</a>
		</div>
            </div> 
            </body>
            <%@include file="includes/footer.jsp" %>
            </html>
            