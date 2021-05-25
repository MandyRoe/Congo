<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <%
      String user = request.getParameter("user");
    %>

    <body>
        Hello, <% out.println(user); %>
    </body>
</html>