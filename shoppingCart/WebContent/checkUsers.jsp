<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten  
if(auth != null){
	 request.setAttribute("auth", auth);}%>

<%  if(auth!= null && auth.getRechte()== 5){    %>           															<!-- if user not logged in logout & orders visible-->
		<meta h"rttp-equiv=efresh" content="0; url=http://example.com/" />
		<p><a href="http://example.com/">Redirect</a></p> 
    <% } %>


	


<html>
<head>
<title>Orders</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<h1>Rechte </h1> 
 <br> <br>
	<div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="ChangeUsers.jsp">Change Users</a>
		</div>
	

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">EMAIL</th>
					<th scope="col">PASSWORD</th>
					<th scope="col">RECHTE</th>
				</tr>
			</thead>
			<tbody>
			<%
			Connection connection = DbCon.getConnection();
			String sql = "select * from USERS ";
			
			try {
				
	           Statement statement = connection.createStatement();				// statement verbindung zur Datenbank
	           ResultSet rs = statement.executeQuery(sql);						//Ausführung des Strings in Datenbank
	          
	           
	           while  (rs.next()) {

				%>
				
				<tr>
					<td><%=rs.getInt("ID")%></td>
					<td><%=rs.getString("NAME")%></td>
					<td><%=rs.getString("EMAIL")%></td>
					<td><%=rs.getString("PASSWORD")%></td>
					<td><%=rs.getInt("RECHTE")%></td>
				</tr>	
				<% }} catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();}%>
            </tbody>
            
            </table>
            </body>
            </html>