<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%@page import="java.sql.*"%>
<%@page import="java.io.*" %>
<%
Class.forName("oracle.jdbc.OracleDriver");
Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "fhdw1993");
Statement statement =connection.createStatement();
String sql="Select * from cart where name = 'STONE'";
ResultSet rs = statement.executeQuery(sql);



 %>


</body>
</html>