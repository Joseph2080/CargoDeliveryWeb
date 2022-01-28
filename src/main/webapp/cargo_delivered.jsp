<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/26/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <meta charset="ISO-8859-1">
    <title>Cargo Registered successfully</title>
</head>
<body>
<div class = "container">
    <div class = "card" align = "center">
        <h1 class = "form__title">Cargo Delivered successfully!</h1>
        <p class = "">Thank you for working with Cargo Delivery System </p>

        <div class="form __item">
            <a href ="<%=request.getContextPath()%>/cargo" methods="get"  >Return To Main</a>
        </div>
    </div>
</div>
</body>
</html>
</html>
