<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/11/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log In</title>
</head>
<div class = "container">
    <div class = "card" align = "center">
        <body>

        <div align="center" >
            <form action="<%= request.getContextPath() %>/login" method="post" class = "form">
                <div class="form__title">Cargo Delivery</div>
                <p class="form_paragraph">
                    Sign in to access the cargo delivery management system
                </p>
                <table>
                    <div class="form__item" >
                        <tr><td>Email: </td><td><input class = "form__input" type="text" name="email"></td></tr>
                    </div>
                    <div class="form__item">
                        <tr><td>Password: </td><td><input class = "form__input" type="password" name="password"></td></tr>
                    </div>

                </table>
                <br>

                <div  align = "center">
                    <input class = "form__btn" type="submit" value="Sign in">
                </div>
            </form>
            <br>
            <br>
            <table>
                <tr>
                    <td>
                        <div class="form __item">
                            <a href ="<%=request.getContextPath()%>/register" methods="get"  >Register account</a>
                        </div>
                    <td>

                    <td>
                        <div class="form __item">

                            <a href ="<%=request.getContextPath()%>/calculateCargo" methods="get"  >Calculate Cargo</a>
                        </div>
                    <td>
                </tr>
            </table>
        </div>
    </body>
    </div>
</div>
</html>