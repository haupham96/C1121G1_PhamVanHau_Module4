<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/03/2022
  Time: 11:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>He lu change Currency</h1>
    <form action="/currency" method="post">
        <table>
            <tr>
                <c:if test="${usd != null}">
                    <td>USD</td>
                    <td><input type="text" name="usd" placeholder="USD" value="${usd}"></td>
                </c:if>
                <c:if test="${usd == null}">
                    <td>USD</td>
                    <td><input type="text" name="usd" placeholder="USD"></td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${vnd != null}">
                    <td>VND </td>
                    <td><input type="text" name="vnd" placeholder="VND" value="${vnd}"></td>
                </c:if>
                <c:if test="${vnd == null}">
                    <td>VND</td>
                    <td><input type="text" name="vnd" placeholder="VND"></td>
                </c:if>
            </tr>
            <tr>
                <td>Convert : </td>
                <td><input type="submit" value="USD to VND"></td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
