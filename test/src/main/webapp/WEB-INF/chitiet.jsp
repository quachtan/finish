<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Edit Product</h3>

	<p style="color: red;">${errorString}</p>

	
		<form method="POST"
			action="${pageContext.request.contextPath}/editProduct">

		<table border="1" cellpadding="5" cellspacing="1" >
				<tr>
				<th>ca</th>
					<th>thu2</th>
					<th>thu3</th>
					<th>thu4</th>
					<th>thu5</th>
					<th>thu6</th>
					<th>thu7</th>

					<th>CHI TIET</th>

				</tr>
				
				
				<tr>
				<td>sang</td>
				<td>${thu2sang}</td>
				<td>${thu3sang}</td>
				<td>${thu4sang}</td>
				<td>${thu5sang}</td>
				<td>${thu6sang}</td>
				<td>${thu7sang}</td>
				</tr>
				<tr>
				<td>chieu</td>
				<td>${thu2chieu}</td>
				<td>${thu3chieu}</td>
				<td>${thu4chieu}</td>
				<td>${thu5chieu}</td>
				<td>${thu6chieu}</td>
				<td>${thu7chieu}</td>
				<tr>
				<td>toi</td>
				<td>${thu2toi}</td>
				<td>${thu3toi}</td>
				<td>${thu4toi}</td>
				<td>${thu5toi}</td>
				<td>${thu6toi}</td>
				<td>${thu7toi}</td>
				</tr>
			</table>
		</form>
	

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>