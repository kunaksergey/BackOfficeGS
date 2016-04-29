<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 18.04.16
  Time: 13:33
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
        <th colspan="3"><a href="/invoice/add">Создать</a></th>
    </tr>
    <tr>
        <td>Номер</td>
        <td>Наша компания</td>
        <td>Клиент</td>
    </tr>
    <c:forEach items="${invoices}" var="invoice" varStatus="status">
        <tr valign="top">
            <td>
                <a href="${pageContext.servletContext.contextPath}/invoice/view?uid=${invoice.uid}">${invoice.number}</a>
            </td>
            <td>${invoice.ourCompany.name} </td>
            <td>${invoice.clientCompany.name} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
