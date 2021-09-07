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
<h1>Rechte </h1> 
 <br> <br>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">EMAIL</th>
					<th scope="col">PASSWORD</th>
					<th scope="col">RECHTE</th>
					<th scope="col">CONFIRM</th>
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
				
			<form 	action="ChangeUserDataPOG" method="post">
					<td><input type="hidden" name="ID" value="<%=rs.getInt("ID")%>" /> <%=rs.getInt("ID")%> </td>
					<td> <input type="text" id="NAME" name="NAME" value=<%=rs.getString("NAME")%>></td>
					<td> <input type="text" id="EMAIL" name="EMAIL" value=<%=rs.getString("EMAIL")%>></td>
					<td> <input type="text" id="PASSWORD" name="PASSWORD" value=<%=rs.getString("PASSWORD")%>></td>
					<td> <input type="text" id="RECHTE" name="RECHTE" value=<%=rs.getInt("RECHTE")%>></td>
					<td> <input type="submit" class="btn btn-primary" value="commit"></td>  
					
			</form>
					
			</tr>	
				<% }} catch (SQLException e) {
            System.out.println("ups, error");
            e.printStackTrace();}%>
            </tbody>
            
            </table>
            </div>
            <%@include file="includes/footer.jsp" %>
            </body>
            </html>