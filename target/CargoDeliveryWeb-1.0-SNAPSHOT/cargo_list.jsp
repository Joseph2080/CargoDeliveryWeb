<%--
  Created by IntelliJ IDEA.
  User: lilmo
  Date: 1/6/2022
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>All upcoming cargos</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand"> List of upcoming Cargos </a>
        </div>

        <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/cargo" methods="get"
                   class="nav-link">Cargo</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Cargo</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/" methods="get" class="btn btn-success">Register Cargo</a>
        </div>
        <br>
        <form action="<%= request.getContextPath() %>/cargo" method="get">
        <table class="table table-bordered" >
            <thead>
            <tr>
                <th>ID</th>
                <th>Cargo Type</th>
                <th>Weight</th>
                <th>Volume</th>
                <th>Delivery date</th>
                <th>Street</th>
                <th>Town</th>
                <th>Country</th>
                <th>Postal Code</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="cargo" items="${listCargo}">
                <tr>
                    <td><c:out value="${cargo.getCargoId()}" /></td>
                    <td><c:out value="${cargo.getCargoType()}" /></td>
                    <td><c:out value="${cargo.getWeight()}" /></td>
                    <td><c:out value="${cargo.getVolume()}" /></td>
                    <td><c:out value="${cargo.getDeliveryDate()}" /></td>
                    <td><c:out value="${cargo.getStreet()}" /></td>
                    <td><c:out value="${cargo.getTown()}" /></td>
                    <td><c:out value="${cargo.getCountry()}" /></td>
                    <td><c:out value="${cargo.getPostalCode()}" /></td>
                    <%--<td><a href="edit?id=<c:out value='${cargo.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${cargo.getId()}' />">Delete</a></td>--%>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        </form>
    </div>
</div>
</body>
</html>
