<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>
<%String username=(String) session.getAttribute("username"); %>
<form action="<%=request.getContextPath() %>/ChangePass" method="POST" role="form">
	
		<div class="form-group">
			<label for="">Tên tài khoản:</label>
			<input type="text" readonly="readonly" class="form-control" name="username" value="<%=username %>" >
			<label for="">Mật khẩu cũ:</label>
			<input type="password" class="form-control" name="oldpassword">
			<label for="">Mật khẩu mới:</label>
			<input type="password" class="form-control" name="newpassword">
		</div>
		<button type="submit" class="btn btn-primary">Xác nhận</button>
	</form>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>