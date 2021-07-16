<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>



<h3> user information: </h3>
Id: ${Product.ID} <br/> 
Name: ${Product.name} <br/>
Description: ${Product.descr} <br/>
Price: ${Product.price} <br/>
Picture: <br/>
&nbsp; &nbsp; &nbsp; &nbsp;<img src="data:image/jpeg;base64, ${Product.img64}"/>  <br/>
</body>
</html>  