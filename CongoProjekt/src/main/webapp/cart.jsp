<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>


<input type = text id=product >
<input type = button id=cart value="Show Cart">

<p id="test"> </p>


<script> 
fetch('C:\Users\Alex\Desktop\test')
.then(response => response.jpg())
.then(data => console.log(data));



</script>




<script>var list = document.getElementById(cart);
var lastid = 0;

function addProduct() {
    var firstproduct = document.getElementById(product).value;
    
    
    var entry = document.createElement('p');
    const newContent = document.createTextNode("${Product.name}")
    entry.setAttribute('id','item'+lastid);
    entry.setAttribute('data-name',newContent);                           //added a data-name attribute for easier access to name

    var removeButton = document.createElement('button');
    removeButton.appendChild(document.createTextNode("remove"));
    removeButton.setAttribute('onClick','removeProduct("'+'item'+lastid+'")');
    entry.appendChild(removeButton);
    lastid+=1;
    list.appendChild(entry);
}


function removeProduct(itemid){
    var item = document.getElementById(itemid);
    list.removeChild(item);
}
</script>






<script>
if (${Product.ID} != null){
document.getElementById(cartList).innerHTML = ' <h3> Product information: </h3> <br/><br/> Item#: ${Product.ID} <br/> Name: ${Product.name} <br/> Description: ${Product.descr} <br/> Price: ${Product.price} <br/> Picture: <br/> &nbsp; &nbsp; &nbsp; &nbsp;<img src="data:image/jpeg;base64, ${Product.img64}" width="250" height="250"/>  <br/>'
	
} else {
	document.getElementById(cartList).innerHTML = "Product not found"
}
</script>









</body>
</html>

