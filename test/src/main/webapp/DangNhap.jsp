<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
				<label >Mã Giáo Viên</label> <input
					type="text" name="username" value="${user.userName}"
					class="form-control" placeholder="Ma GV" required autofocus>
				<label >Mật Khẩu</label> <input
					type="password" name="password" value="${user.password}"
					class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberMe" value="Y">
						Remember me
					</label>
					<a href="<%=request.getContextPath() %>/ChangePass">Đổi mật khẩu</a>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng Nhập</button>
			</form>
		</div>
	</div>
	<!-- /container -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>