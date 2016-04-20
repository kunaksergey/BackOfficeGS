<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 13.04.16
  Time: 15:25
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
        <td><a href="${pageContext.servletContext.contextPath}/company/add">Создать</a></td>
    </tr>
    <tr>
        <td>Наименование</td>
        <td>Полное название</td>
        <td></td>
    </tr>
    <c:forEach items="${companies}" var="company" varStatus="status">
        <tr valign="top">
            <td>${company.name} </td>
            <td>${company.fullName} </td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/company/edit?uid=${company.uid}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/company/delete?uid=${company.uid}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
