<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/14/2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div>
    <form action="/current"  method="post">
        <p>USD</p>
        <input type="text" name="USD" placeholder="input USD" value="${usd}">
        <p>VND</p>
        <input type="text" readonly placeholder="0" value="${result}">

        <button type="submit">Current</button>
    </form>
</div>
</body>
</html>
