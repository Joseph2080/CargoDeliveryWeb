<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/28/2022
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <meta charset="ISO-8859-1">
    <title >Registration Failed</title>
</head>
<div class = "container">
    <div class = "card" align = "center">
        <body >
        <h1 class = "form__title" >Registration Failed</h1>
        <h2 class = "form_paragraph">Please ensure that a valid email and password is being used to create an account</h2>
        <div class="form __item">
            <a  href ="<%=request.getContextPath()%>/register" methods="get"  >Try again</a>
        </div>
        </body>
    </div>
</div>
</html>
