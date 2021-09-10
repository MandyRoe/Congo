<%@page import="dao.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten  
if(auth != null){
	 request.setAttribute("auth", auth);}%>

<%  if(auth!= null && auth.getRechte()> 4){    %>           															<!-- if user not logged in logout & orders visible-->
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
<div class="card-header my-3">Users</div>


  <div class="row">
    <div class="col">History:</div>
    <div class="col"> </div>
    <div class="col"> 4= admin, 5= seller, 6 = user </div>
  </div>

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">EMAIL</th>
					<th scope="col">PASSWORD</th>
					<th scope="col">RIGHTS</th>
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
            
	<div class="d-flex py-3">
			<a class="mx-3 btn btn-primary" href="ChangeUsers.jsp">Edit Users</a>
		</div>
              
            
            </div>
            </body>
            <%@include file="includes/footer.jsp" %>
            </html>