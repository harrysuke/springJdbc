<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product Detail Information</title>
</head>
<body>
<%@ include file="inc_navbar.jsp" %>
<!-- 
Group members:
Khairi
Hakim
Aiman
Hamizah
 -->
<h2>Product Detail Information</h2>

<c:if test="${product ne null}">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
        </tr>
    </table>
</c:if>

</body>
</html>
