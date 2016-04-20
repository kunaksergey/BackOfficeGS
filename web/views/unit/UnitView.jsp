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
    <title>Единица измерения</title>
</head>
<body>
<div>
    ID: <c:out value="${unit.uid}"/><br/>
    Наименование: <c:out value="${unit.name}"/><br/>
    Полное Наименование: <c:out value="${unit.fullName}"/><br/>
</div>
</body>
</html>
