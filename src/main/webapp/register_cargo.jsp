
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <h1 class = "form__title">Cargo Registration Form</h1>
        <form class = "form" action="<%= request.getContextPath() %>/registerCargo" method="post">
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
                    <td>Delivery date</td>
                    <td><input type="date" class = "form__input"  name="delivery_date" /></td>
                </tr>
                <tr>
                    <td>Street</td>
                    <td><input type="text" class = "form__input"  name="street" /></td>
                </tr>
                <tr>
                    <td>Town</td>
                    <td><input type="text" class = "form__input"  name="town" /></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><input type="text" class = "form__input"  name="country" /></td>
                </tr>
                <tr>
                    <td>Postal code</td>
                    <td><input type="text" class = "form__input"  name="postal_code" /></td>
                </tr>
            </table>
            <br>
            <input align = "center" class = "form__btn"  type="submit" value="Submit" />
        </form>
        <br>
        <p class="form_paragraph" >
            *Fill in the form to request a cargo load</p>
    </div>
</div>
</body>

</html>
</html>

