<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register Cargo</title>
    <link rel="stylesheet" href="cargo_styles.css" >
</head>
<body>
<div align="center">
    <h1 class = "form__title">Cargo Registration</h1>
    <form class = "form" action="<%= request.getContextPath() %>/newCargo" method="post">
        <table style="with: 80%">
            <tr>
                <td>Cargo Type</td>
                <td><input type="text" class = "form__input" name="cargo_type" /></td>
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
        <input class = "form__btn"  type="submit" value="Submit" />
    </form>
</div>
</body>

</html>

