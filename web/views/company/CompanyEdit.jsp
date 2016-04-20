<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 13.04.16
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="POST">
    <input type="hidden" name="id" value="${company.uid}">
    <label>Наименование <input type="text" name="name" value="${company.name}"/></label><br/>
    <label>Полное наименование <input type="text" name="fullName" value="${company.fullName}"/></label><br/>
    <label>ЕДРПОУ <input type="text" name="edrpou" value="${company.edrpou}"/></label><br/>
    <label>ИНН <input type="text" name="inn" value="${company.inn}"/></label><br/>
    <label>Адресс <input type="text" name="inn" value="${company.address}"/></label><br/>
    <input type="submit" value="Сохранить"/>
</form>
</body>
</html>
