<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/03/2022
  Time: 10:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SandWich</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>SandWich Condiments</h1>
<form action="/sandwich" method="post">
    <div class="form-check form-check-inline">
        <input name="condiment1" class="form-check-input" type="checkbox" value="Lecttuce" id="inlineCheckbox1">
        <label class="form-check-label" for="inlineCheckbox1">
            Lecttuce
        </label>
    </div>
    <div class="form-check form-check-inline">
        <input name="condiment2" class="form-check-input" type="checkbox" value="Tomato" id="inlineCheckbox2" >
        <label class="form-check-label" for="inlineCheckbox2">
            Tomato
        </label>
    </div>
    <div class="form-check form-check-inline">
        <input name="condiment3" class="form-check-input" type="checkbox" value="Mustard" id="inlineCheckbox3">
        <label class="form-check-label" for="inlineCheckbox3">
            Mustard
        </label>
    </div>
    <div class="form-check form-check-inline">
        <input name="condiment4" class="form-check-input" type="checkbox" value="Sprout" id="inlineCheckbox4" >
        <label class="form-check-label" for="inlineCheckbox4">
            Sprout
        </label>
    </div>
    <br>
    <input type="submit" value="Save">
</form>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</html>
