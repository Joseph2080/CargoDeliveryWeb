<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/28/2022
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <meta charset="ISO-8859-1">
    <title >Estimated Cost Of Delivery</title>
</head>
<div class = "container">
    <div class = "card" align = "center">
        <body >
        <h1 class = "form__title" >Estimated Cost Of Delivery</h1>
        <h3 class = "form_paragraph" >The estimated expense to move your cargo is valued at</h3>
        <br>
        <input name = "invoice" id = "invoice"  value="3500" class = "form__title"></input>
        <div class="form __item">
            <a  href ="<%=request.getContextPath()%>/cargo" methods="get"  >Back</a>
        </div>
        </body>
    </div>
</div>
</html>
