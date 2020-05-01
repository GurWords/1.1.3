<%--
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 01.05.2020
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateusers" method="post">
    <input name="name_new" value="<%out.print(request.getParameter("name_old"));%>" >
    <input name="age_new" value="<% out.print(request.getParameter("age_old"));%>">
    <input type="submit">
</form>
</body>
</html>
