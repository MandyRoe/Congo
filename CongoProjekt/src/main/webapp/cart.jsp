<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>


Your cart:

<p id=cartList> </p>


<script>
if (${Product.ID} != null){
document.getElementById(itemdescr).innerHTML = ' <h3> Product information: </h3> <br/><br/> Item#: ${Product.ID} <br/> Name: ${Product.name} <br/> Description: ${Product.descr} <br/> Price: ${Product.price} <br/> Picture: <br/> &nbsp; &nbsp; &nbsp; &nbsp;<img src="data:image/jpeg;base64, ${Product.img64}" width="250" height="250"/>  <br/>'
	
} else {
	document.getElementById(itemdescr).innerHTML = "Product not found"
}
</script>









</body>
</html>

