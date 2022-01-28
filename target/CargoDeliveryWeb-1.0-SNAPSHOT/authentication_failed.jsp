<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/13/2022
  Time: 3:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <meta charset="ISO-8859-1">
    <title >AUTHENTICATION FAILED</title>
</head>
<div class = "container">
    <div class = "card" align = "center">
        <body >
        <h1 class = "form__title" >AUTHENTICATION FAILED</h1>
        <h2 class = "form_paragraph">Invalid email or password</h2>
        <div class="form __item">
            <a  href="<%= request.getContextPath() %>/login"  >Try again</a>

        </div>
        <h3> </h3>

        <div class="form __item">
            <a  href ="<%=request.getContextPath()%>/register" methods="get"  >Register account</a>
        </div>
        </body>
    </div>
</div>

</html>
