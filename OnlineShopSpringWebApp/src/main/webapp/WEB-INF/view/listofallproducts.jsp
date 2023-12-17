<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>List of All Products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
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
 <div class="container">
 
	<h2>List of All Products</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th width="10%">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td><c:out value="${product.id}" /></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.price}" /></td>
					<td><c:out value="${product.quantity}" /></td>
					<td>
						<a href="<c:url value='/product/edit/${product.id}' />">Edit</a>
						<a href="<c:url value='/product/delete/${product.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>