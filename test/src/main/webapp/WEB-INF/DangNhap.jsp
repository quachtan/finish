<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dang Nhap</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body style="background-color: black;">
	<div class="col-md-4 col-md-offset-4 container"
		style="padding-top: 60px; padding-bottom: 150px;">
		<%--   <p style="color: red;">${errorString}</p> --%>

		<c:if test="${errorString != null}">
			<div class="alert alert-danger">
				<p>${errorString}</p>
			</div>
		</c:if>
		<div class="jumbotron" style="background-color: eee;">

			<form class="form-signin" method="POST"
				action="${pageContext.request.contextPath}/login">
				<label for="mauser" class="sr-only">Ma Giao Vien</label> <input
					type="text" name="username" value="${user.userName}"
					class="form-control" placeholder="Ma GV" required autofocus>
				<label for="inputPassword" class="sr-only">Password</label> <input
					type="text" name="password" value="${user.password}"
					class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberMe" value="Y">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
			</form>
		</div>
	</div>
	<!-- /container -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>