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
<title>Change Listings</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<h1>Rechte </h1> 
 <br> <br>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ITEMNUMBER</th>
					<th scope="col">NAME</th>
					<th scope="col">DESCR</th>
					<th scope="col">PRICE</th>
					<th scope="col">CATEGORY</th>
					<th scope="col">CONFIRM</th>
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
				
			<form 	action="ChangeListingPOG" method="post">
					<td><input type="hidden" name="ITEMNUMBER" value="<%=rs.getInt("ITEMNUMBER")%>" /> <%=rs.getInt("ITEMNUMBER")%> </td>
					<td> <input type="text" id="NAME" name="NAME" value=<%=rs.getString("NAME")%>></td>
					<td> <input type="text" id="DESCR" name="DESCR" value=<%=rs.getString("DESCR")%>></td>
					<td> <input type="text" id="PRICE" name="PRICE" value=<%=rs.getInt("PRICE")%>></td>
					<td> <input type="text" id="CATEGORY" name="CATEGORY" value=<%=rs.getString("CATEGORY")%>></td>
					<td> <input type="submit"></td>  
					
			</form>
					
			</tr>	
				<% }} catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();}%>
            </tbody>
            
            </table>
            </body>
            </html>