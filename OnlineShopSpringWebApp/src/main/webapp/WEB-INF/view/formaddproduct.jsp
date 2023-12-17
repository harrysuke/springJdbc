<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
	<%@ include file="inc_navbar.jsp"%>
	<!-- 
Group members:
Khairi
Hakim
Aiman
Hamizah
 -->

	<div class="container">

		<h2>Add Product</h2>
		<form action="<%=request.getContextPath()%>/product/add"
			method="post">
			<div class="mb-3">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="price">Price:</label> <input type="number" step="0.01"
					id="price" name="price" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="quantity">Quantity:</label> <input type="number"
					id="quantity" name="quantity" class="form-control" required>
			</div>
			<div class="mb-3">
				<input type="submit" value="Add Product" class="btn btn-primary">
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
