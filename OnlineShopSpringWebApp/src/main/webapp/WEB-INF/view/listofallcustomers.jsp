<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>List of All Customers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
<%@ include file="inc_navbar.jsp" %>
<div class="container">
<h2>List of All Customers</h2>

<c:if test="${not empty customerList}">
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstname}</td>
                    <td>${customer.lastname}</td>
                    <td>${customer.email}</td>
                    <td width="10%">
                        <a href="<c:url value='/customer/edit/${customer.id}'/>">Edit</a>
                        <a href="<c:url value='/customer/delete/${customer.id}'/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
