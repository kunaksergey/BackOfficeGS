<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 20.04.16
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
    Login: <input class="mg2" type="text" name="login"> <br/>
    Password: <input class="mg2" type="password" name="password"/>
    <input type="submit" value="enter"/>
    <span class="error">${error}</span>
</form>
</body>
</html>
