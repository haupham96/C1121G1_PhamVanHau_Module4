<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 31/03/2022
  Time: 10:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<form:form method="post" modelAttribute="mailBox">
    <table>
        <tr>
            <th>Language :</th>
            <td><form:select path="languge" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <th>Page Size :</th>
            <td><label>Show </label><form:select path="pageSize" items="${listPageSize}"/><label> emails per
                page</label></td>
        </tr>
        <tr>
            <th>Spam filter :</th>
            <td>
                <form:checkbox path="spamFilter" value="1"/>
            </td>
        </tr>
        <tr>
            <th>Signature :</th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button>Update</button>
                <button><a style="text-decoration: none;color: black" href="/setting">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
