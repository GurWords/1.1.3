<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Service.UsersService" %><%--
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 24.04.2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Добавить пользователя:</h4>
<form action="/addusers" method="post">
    Name:
    <input name="name" type="text">
    Age:
    <input name="age" type="number">
    <input type="submit">
</form>
<h4>Изменить ползователя:</h4>
<c:forEach var="i" items="${UsersService.getInstance().selectAllUsers()}">
    <form name="updateUser" action="/updateusers" method="get">
        Name:
        <input name="name_old" value="${i.getName()}">
        Age:
        <input name="age_old" value="${i.getAge()}">
        <input type="submit" name="updateForm">
    </form>
</c:forEach>
<h4>Удалить пользователя:</h4>
<c:forEach var="i" items="${UsersService.getInstance().selectAllUsers()}">
    <form action="/deleteusers" method="post">
        <input name="nameDelete" value="${i.getName()}">
        <input name="ageDelete" value="${i.getAge()}">
        <button type="submit">Удалить</button>
    </form>
</c:forEach>
</body>
</html>
