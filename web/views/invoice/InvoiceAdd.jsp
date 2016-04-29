<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 18.04.16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <label>Рахунок №<input type="text" name="number"></label><br/>
    <label>від <c:out value="${invoice.getDateLongString()}"/></label><br/>
    <label>постачальник <c:out value="${invoice.ourCompany.fullName}"/></label><br/>
    <label>р/р <c:out value="${invoice.ourCompany.getMainAccount().number}"/></label><br/>
    <label>в <c:out value="${invoice.ourCompany.getMainAccount().nameBank}"/></label><br/>
    <label> ЕДРПОУ <c:out value="${invoice.ourCompany.edrpou}"/></label><br/>
    <label><a href="#">платник:</a> <input type="text" name="clientCompanyfullName"/> </label><br/>
    <label>ПРИЗНАЧЕННЯ ПЛАТЕЖУ <input type="text" name="description"></label>
</form>

<table border="1">
    <tr>
        <th>№пп</th>
        <th>Наименування товару</th>
        <th>Од.виміру</th>
        <th>Кількість</th>
        <th>Ціна</th>
        <th>Сумма</th>

    </tr>
    <c:forEach items="${invoice.invoiceDtList}" var="dt" varStatus="status">
        <tr valign="top">
            <td></td>
            <td>${dt.decription}</td>
            <td>${dt.unit.name}</td>
            <td>${dt.amount}</td>
            <td><fmt:formatNumber value="${dt.price}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${dt.sum}" pattern="###.00"/></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">Разом без ПДВ</td>
        <td><fmt:formatNumber value="${invoice.getSumNoNds()}" pattern="###.00"/></td>
    </tr>
    <tr>
        <td colspan="5">ПДВ</td>
        <td>${invoice.nds}</td>
    </tr>
    <tr>
        <td colspan="5">Всього з ПДВ</td>
        <td><fmt:formatNumber value="${invoice.getSumNds()}" pattern="###.00"/></td>
    </tr>
</table>
</div>
</body>
</html>


