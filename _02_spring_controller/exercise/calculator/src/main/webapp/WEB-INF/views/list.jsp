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
<h2>Calculator</h2>
<div>
    <form action="/calculator"  method="post">
        <div style="display: flex">
        <input type="text" name="firstNumber" value="${firstNumber}">
        <input type="text" name="secondNumber" value="${secondNumber}">
        </div>

        <hr>

        <div style="display: flex">
        <button type="submit" name="check" value="+">Addition(+)</button>
        <button type="submit" name="check" value="-"> Subtraction(-)</button>
        <button type="submit" name="check" value="*">Multiplication(X)</button>
        <button type="submit" name="check" value="/">Division(/)</button>
        </div>
    </form>
    <p>Result Division: ${result}</p>
</div>
</body>
</html>
