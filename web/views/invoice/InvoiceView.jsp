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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/invoice.js"></script>
    <script>
        $(document).ready(function () {


            $("#linkClient").on("click", function (event) {
                event.preventDefault();
                $("#dictionary").show();
                $.getJSON("/company/view/json", function (data) {
                    var items = [];
                    $.each(data, function (key, obj) {
                        items.push("<a href=\"\" class=\"companiesList\" uid=" + obj.uid + ">" + obj.fullName + "</a></br>");

                    });
                    $("#dictionaryBody").html(items);


                    $("#dictionaryBody > a").on("click", function (event) {
                        event.preventDefault();
                        $("#clientCompany").text($(this).text());


                    });
                });
            });

            $(".closeDiv a").on("click", function (event) {
                event.preventDefault();
                $("#dictionary").hide();
            });

        });
    </script>


    <title>Title</title>
</head>
<body>
Рахунок №<c:out value="${invoice.number}"/> <br/>
від <c:out value="${invoice.getDateLongString()}"/> <br/>
постачальник <c:out value="${invoice.ourCompany.fullName}"/><br/>
р/р <c:out value="${invoice.ourCompany.mainAccount.number}"/>
в <c:out value="${invoice.ourCompany.mainAccount.nameBank}"/>
<br/>
МФО: <c:out value="${invoice.ourCompany.mainAccount.mfo}"/>
ЕДРПОУ: <c:out value="${invoice.ourCompany.edrpou}"/><br/>
<a href="" id="linkClient">платник:</a>
<lable id="clientCompany"><c:out value="${invoice.clientCompany.fullName}"/></lable>
<label> <br/>
ПРИЗНАЧЕННЯ ПЛАТЕЖУ <c:out value="${invoice.description}"/><br/>
</div>
<div>

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
    <div>
        <a href="/FileDownloadServlet">Download</a>
    </div>
    <div id="dictionary">
        <div id="dictionaryTitle">
            <div class="closeDiv"><a href="">x</a></div>
        </div>
        <div id="dictionaryBody">
        </div>
</div>
</body>
</html>

