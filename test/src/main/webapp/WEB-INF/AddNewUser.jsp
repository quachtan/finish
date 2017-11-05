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
<form action="<%=request.getContextPath() %>/AddNewUser" method="POST" role="form">
	
		<div class="form-group">
			<label for="">Mã tài khoản:</label>
			<input type="text" class="form-control" name="ma_user">
			<label for="">Tên tài khoản:</label>
			<input type="text" class="form-control" name="username">
			<label for="">Mật khẩu:</label>
			<input type="password" class="form-control" name="password">
		</div>
	
		
	
		<button type="submit" class="btn btn-primary">Tạo</button>
	</form>
</body>
</html>