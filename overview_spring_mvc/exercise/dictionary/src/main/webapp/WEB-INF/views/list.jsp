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
    <form action="/dictionary"  method="post">
        <p>English</p>
        <input type="text" name="word" placeholder="input word" value="${english}">
        <p>Vietnamese</p>
        <input type="text" readonly value="${translate}">

        <button type="submit">Current</button>
    </form>
</div>
</body>
</html>
