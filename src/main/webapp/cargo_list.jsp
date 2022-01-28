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
<style>
    <%@ include file="cargo_styles.css"%>
</style>
<head>
    <title>All upcoming cargos</title>

    <link rel="stylesheet" href="fontawesome-free-5.15.1/css/all.css">

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}cargo_styles.css"/>

</head>
<body>

<header>
    <div class="fixed-header">
        <div class="container">
            <nav>

                <a href="<%=request.getContextPath()%>/cargo" methods="get" class = "nava" >Home</a>
                <a href="<%=request.getContextPath()%>/registerCargo" methods="get" class = "nava" >Register Cargo</a>
                <a href="<%=request.getContextPath()%>/calculateCargo" methods="get" class = "nava" >Calculate Delivery</a>
                <a href="<%=request.getContextPath()%>/logout" methods="post" class = "nava" >Log out</a>


            </nav>

        </div>
    </div>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        </br>
        </br>
        </br>
        <h3 class="h3">List of Cargos</h3>
        </br>
        </br>
        <form  action="<%= request.getContextPath() %>/cargo" method="get">

            <select class= "form__input" name="filter" id="filter">
                <option value="sortByID">Sort By Cargo ID</option>
                <option value="sortByType">Sort By Type</option>
                <option value="sortByCountry">Sort By Country</option>
            </select>

            <input class= "form__input" type="text" placeholder="Search cargo type or id" id="searchCargo" name="searchCargo">

            <input value = "search" type = "submit" class = "square_btn">
        </form>
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
                        <td><a href="<%= request.getContextPath() %>/cargo_delivered?id=<c:out value='${cargo.getCargoId()}' />" methods="get">Confirm delivery</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>

</html>