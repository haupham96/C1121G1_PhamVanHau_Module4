<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/03/2022
  Time: 1:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<center>
    <h1>Dictionary</h1>
    <form action="/dictionary" method="post">
        <table>
            <tr>
                <th>Input English :</th>
                <c:if test="${english != null}">
                    <td><input type="text" name="english" value="${english}"></td>
                </c:if>
                <c:if test="${english == null}">
                    <td><input type="text" name="english"></td>
                </c:if>
            </tr>
            <tr>
                <th>Output Vietnamese :</th>
                <c:if test="${vietnameseWorld != null}">
                    <td><input type="text" name="vietnamese" value="${vietnameseWorld}"></td>
                </c:if>
                <c:if test="${vietnameseWorld == null}">
                    <td><input type="text" name="vietnamese"></td>
                </c:if>
            </tr>
            <tr>
                <th>Search :</th>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
