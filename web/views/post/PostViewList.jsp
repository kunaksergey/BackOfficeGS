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
        <th>id</th>
        <th>Должности</th>
    </tr>
    <c:forEach items="${posts}" var="post" varStatus="status">
        <tr valign="top">
            <td>${post.uid} </td>
            <td>${post.name} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
