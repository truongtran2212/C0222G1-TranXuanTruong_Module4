<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/16/2022
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="email" action="/show-email" method="post">

    <label>Languages</label>
    <form:select path="language">
        <form:options items="${language}"></form:options>
    </form:select>
    <br>
    <label>Page Size:</label>
    <form:select path="pageSize">
        <form:options items="${size}"></form:options>
    </form:select>
    <br>
    <label>Spam filter</label>
    <form:checkbox path="spamsFilter"></form:checkbox>
    <br>
    <label>Signature</label>
    <form:textarea path="signature"></form:textarea>
    <br>
    <button type="submit">update</button>
    <button><a href="email">Cancel</a></button>
</form:form>
</body>
</html>
