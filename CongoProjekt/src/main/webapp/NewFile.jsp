<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
</head>
<body>



<h3> user information: </h3>
Id: ${retard.ID} <br/> 
Name: ${retard.name} <br/>
Age: ${retard.email} <br/>
Picture: <br/> 
<img src="data:image/jpeg;base64, ${retard.img64}"/>  <br/>
</body>
</html>  