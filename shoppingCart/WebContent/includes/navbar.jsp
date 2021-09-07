<%@page import="model.*" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

<div class="container">
  <a class="navbar-brand" href="index.jsp">Congo</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active"><a class="nav-link" href="index.jsp">Home </a></li>
      <li class="nav-item active"><a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger" px-2>${sessionCart_list.size() }</span></a></li>
     
	<%  if(auth!= null && auth.getRechte()== 4){    %>           															<!-- if user not logged in logout & orders visible-->
    	<li class="nav-item active"><a class="nav-link" href="checkUsers.jsp">CheckUsers</a></li>
    	<li class="nav-item active"><a class="nav-link" href="checkListings.jsp">ManageListings</a></li>      
    
    <% } %>
    
    <%  if(auth!= null && auth.getRechte()== 5){    %>           															<!-- if user not logged in logout & orders visible-->
        <li class="nav-item active"><a class="nav-link" href="checkListings.jsp">ManageListings</a></li>   
    <% } %>
    
    <%  if(auth!= null){    %>           															<!-- if user not logged in logout & orders visible-->
        <li class="nav-item active"><a class="nav-link" href="orders.jsp">Orders</a></li>   
        <li class="nav-item active"><a class="nav-link" href="log-out">Logout</a></li>
    
   <%  }else{ %>
    	<li class="nav-item active"><a class="nav-link" href="login.jsp">Login</a></li>
    <% } %>
    
      
    </ul>

  </div>
  </div>
</nav>