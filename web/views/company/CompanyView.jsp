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
<div>
    Наименование: <c:out value="${company.name}"/><br/>
    Полное Наименование: <c:out value="${company.fullName}"/><br/>
    ЕДРПОУ: <c:out value="${company.edrpou}"/><br/>
    ИНН: <c:out value="${company.inn}"/><br/>
    Адресс: <c:out value="${company.address}"/><br/>
</div>
<div>
    <table>
        <tr>
            <th>Номер счет</th>
            <th>МФО</th>
            <th>Банк</th>
            <th>Адресс банка</th>
        </tr>
        <c:forEach items="${company.accountList}" var="account" varStatus="status">
            <tr valign="top">
                <td>${account.number} </td>
                <td>${account.mfo} </td>
                <td>${account.nameBank} </td>
                <td>${account.address} </td>
                <td><a href="">Редактировать</a></td>
                <td><a href="">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
