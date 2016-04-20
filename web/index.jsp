<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 13.04.16
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список компаний</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Логин Email</td>
        <td>Действия2</td>
    </tr>
    <c:forEach items="${companies}" var="company" varStatus="status">
        <tr valign="top">
            <td>${company.name} </td>
            <td>${company.ourCompany} </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
