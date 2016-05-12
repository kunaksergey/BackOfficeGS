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
    <title>Должность</title>
</head>
<body>
<div>
    ID: <c:out value="${post.uid}"/><br/>
    Наименование: <c:out value="${post.name}"/><br/>
</div>
</body>
</html>
