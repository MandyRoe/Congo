<%@page import="java.util.*" %>
<%@page import="connection.*" %>
<%@page import="model.*" %>
<%@page import="dao.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<% 


User auth = (User) request.getSession().getAttribute("auth");                     //auth ist user objekt deswegen müssen wir casten
if(auth != null){
	 request.setAttribute("auth", auth);
	response.sendRedirect("index.jsp");
}    
%>
 
<!DOCTYPE html>
<html>
<head>
<title>Registry</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>



<div class="container">

<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">User Registry</div>
<div class="card-body">
<form action="RegisterServlet" method="post"> 

<div class="form-group">
<label>EMAILNAME</label>
<input type ="email" class="form-control" name="register-email" placeholder="Enter your Email" required>
  <input type="checkbox" id="rechte" name="rechte"> <label for="rechte">Sind Sie Verkäufer?</label>
</div>
<div class="form-group">


<label>NAME</label>
<input name="register-name" placeholder="Enter your NAME" required>
</div>

<div class="form-group">
<label>Enter your PASSWORD</label>
<input type ="password" class="form-control" name="register-password" placeholder="********" required>
</div>


<div class="text-center">
<button type="submit" class="btn btn-primary">Register</button>
</div>

</form> 
</div>
</div>
</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>