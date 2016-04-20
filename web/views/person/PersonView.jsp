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
    <title>Справочник</title>
</head>
<body>
<div>
    ID: <c:out value="${person.uid}"/><br/>
    Имя: <c:out value="${person.name}"/><br/>
    Полное имя: <c:out value="${person.fullName}"/><br/>
</div>
</body>
</html>
