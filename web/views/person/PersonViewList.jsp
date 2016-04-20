<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 20.04.16
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>Имя</th>
        <th>Полное имя</th>
        <th>Должность</th>
        <th colspan="2">действие</th>
    </tr>
    <c:forEach items="${persons}" var="person" varStatus="status">
        <tr valign="top">
            <td>${person.uid} </td>
            <td>${person.name} </td>
            <td>${person.fullName} </td>
            <td>${person.post.name} </td>
            <td><a href="">Редактировать</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
