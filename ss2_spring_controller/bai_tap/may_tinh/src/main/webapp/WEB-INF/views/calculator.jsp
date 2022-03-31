<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/03/2022
  Time: 11:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <br>
    <button type="submit" name="cal" value="sub">SUB(-)</button>
    <button type="submit" name="cal" value="sum">SUM(+)</button>
    <button type="submit" name="cal" value="div">DIV(:)</button>
    <button type="submit" name="cal" value="mul">MUL(X)</button>
</form>
<p>Result : ${total}</p>
<p style="color: red">${errors}</p>
</body>
</html>
