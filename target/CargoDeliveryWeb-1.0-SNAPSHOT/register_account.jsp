<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/11/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link rel="stylesheet" href="cargo_styles.css" >
</head>
<body>
<div align="center">
    <form  class = "form" action="<%= request.getContextPath() %>/register" method="post">
        <table>
            <tr><td>Email: </td><td><input class= "form__input" type="text" name="email"></td></tr>
            <tr><td>Role: </td><td><label for="roles"></label>
                <select class= "form__input" name="roles" id="roles">
                    <option value="authorised_user">Authorised User</option>
                    <option value="user">User</option>
                    <option value="manager">Manager</option>
                </select></td></tr>
            <tr><td>Password: </td><td><input class = "form__input" type="password" name="password"></td></tr>
            <tr><td>Verify Password: </td><td><input type="password" name="verify_password" class = "form__input"></td></tr>
        </table>
        <input class = "form__btn" type="submit" value="Register">
    </form>
</div>
</body>
</html>