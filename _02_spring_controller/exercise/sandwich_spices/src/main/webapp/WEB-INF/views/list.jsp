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
    <form action="/save"  method="post">
        <div style="display: flex">
        <input type="checkbox" name="spices" value="Lettuce">Lettuce
        <input type="checkbox" name="spices" value="Tomato" >Tomato
        <input type="checkbox" name="spices" value="Mustard">Mustard
        <input type="checkbox" name="spices" value="Sprouts">Sprouts
        </div>
        <hr>
        <button type="submit">save</button>
    </form>
    <p>spices: ${result}</p>

</div>
</body>
</html>
