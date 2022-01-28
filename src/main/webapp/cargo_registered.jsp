<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/4/2022
  Time: 3:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <h1 class = "form__title">Cargo successfully registered!</h1>
    <p class = "">Thank you for registering your cargo with us</p>

    <div class="form __item">
      <a href ="<%=request.getContextPath()%>/cargo" methods="get"  >Return To Main</a>
    </div>
  </div>
</div>
</body>
</html>
</html>
