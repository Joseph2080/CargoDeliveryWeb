<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/25/2022
  Time: 4:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <meta charset="ISO-8859-1">
    <title>Register Cargo</title>
</head>
<body>
<div class = "container" align = "center">
    <div class = "card">
        <h1 class = "form__title">Calculate Delivery</h1>
        <form class = "form" action="<%= request.getContextPath() %>/calculateCargo" method="post">
            <table style="with: 80%">
                <tr>
                    <td>Cargo Type</td>
                    <td><label for="types"></label>
                        <select class= "form__input" name="types" id="types">
                            <option value="container">Container</option>
                            <option value="dry-bulk">dry-bulk</option>
                            <option value="liquid-bulk">liquid-bulk</option>
                        </select></td></td>
                </tr>
                <tr>
                    <td>Weight</td>
                    <td><input type="number" class = "form__input"  name="weight" /></td>
                </tr>
                <tr>
                    <td>Volume</td>
                    <td><input type="number" class = "form__input"  name="volume" /></td>
                </tr>

                <tr>
                    <td>Country</td>
                    <td><input type="text" class = "form__input"  name="country" /></td>
                </tr>
            </table>
            <br>
            <input align = "center" class = "form__btn"  type="submit" value="Calculate" />
        </form>
        <br>
        <p class="form_paragraph" >
            *Calculate estimate delivery fare</p>

    </div>
</div>
</body>

</html>
