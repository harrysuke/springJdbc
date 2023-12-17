<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
<%@ include file="inc_navbar.jsp"%>
<div class="container">
    <h2>Edit Customer</h2>

    <form action="<%=request.getContextPath()%>/customer/update" method="post">
        <input type="hidden" id="id" name="id" value="${customer.id}" />

        <div class="mb-3">
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" class="form-control" required="true"
                        value="${customer.firstname}" />
        </div>
        <div class="mb-3">
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" class="form-control" required="true"
                        value="${customer.lastname}" />
        </div>
        <div class="mb-3">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="form-control" required="true"
                        value="${customer.email}" />
        </div>
        <div class="mb-3">
            <input type="submit" value="Update Customer" class="btn btn-primary">
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
