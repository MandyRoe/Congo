<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product detail</title>
</head>
<body>

			<form > 
			Enter product name : <input type="text" name="product" id = product><br><br>         <!-- die textfeldernamen werden gecalled! -->
			
			<input type="submit" value="Produktdetails" formaction="Products" > 	
			<br> 
			<input type='submit' name=addProduct value='Add to cart' formaction="Cart" />
					
			</form>
		
			<form action = "Cart">
			<input type='submit' name=remove value='remove from cart'/>
			</form>
	
	


<br> <br> <br> <br>
					<A HREF="http://localhost:8080/CongoProjekt/index.html"> Home</A>
<br> <br>
					<A HREF="http://localhost:8080/CongoProjekt/cart.jsp"> Go to Cart</A>

	


<p id="itemdescr" ></p>



<script>
if (${Product.itmnbr} != null){
document.getElementById("itemdescr").innerHTML = ' <h3> Product information: </h3> <br/><br/> Item#: ${Product.itmnbr} <br/> Name: ${Product.name} <br/> Description: ${Product.descr} <br/> Price: ${Product.price} <br/> Picture: <br/> &nbsp; &nbsp; &nbsp; &nbsp;<img src="data:image/jpeg;base64, ${Product.img64}" width="250" height="250"/>  <br/>'
	
} else {
	document.getElementById("itemdescr").innerHTML = "<h3> Product not found </h3>"
}
</script>

</body>
</html>  

