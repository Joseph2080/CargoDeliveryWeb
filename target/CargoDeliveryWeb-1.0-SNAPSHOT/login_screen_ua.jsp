<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/28/2022
  Time: 4:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <div class="form__title">Доставка вантажів</div>
                <p class="form_paragraph">
                    Увійдіть, щоб отримати доступ до системи керування доставкою вантажів
                </p>
                <table>
                    <div class="form__item" >
                        <tr><td>Електронна пошта: </td><td><input class = "form__input" type="text" name="email"></td></tr>
                    </div>
                    <div class="form__item">
                        <tr><td>Пароль: </td><td><input class = "form__input" type="password" name="password"></td></tr>
                    </div>

                </table>
                <br>

                <div  align = "center">
                    <input class = "form__btn" type="submit" value="Увійти">
                </div>
            </form>
            <br>
            <br>
            <table>
                <tr>
                    <td>
                        <div class="form __item">
                            <a href ="<%=request.getContextPath()%>/register" methods="get"  >Зареєструвати обліковий запис</a>
                        </div>
                    <td>

                    <td>
                        <div class="form __item">

                            <a href ="<%=request.getContextPath()%>/calculateCargo" methods="get"  >Розрахувати вантаж</a>
                        </div>
                    <td>
                </tr>
            </table>
        </div>
        </body>
    </div>
</div>
</html>
