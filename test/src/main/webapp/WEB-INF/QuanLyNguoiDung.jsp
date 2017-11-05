<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<a href="<%=request.getContextPath() %>/AddNewUser">Add</a>
<body>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Mã tài khoản</th>
			<th>Tên tài khoản</th>
			<th>Họ và tên</th>
			<th>Email</th>
			<th>Số điện thoại</th>
			
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${listUser }" var="l" >
		<tr>
			<td>${l.ma_user }</td>
			<td>${l.userName }</td>
			<td>${l.tengv }</td>
			<td>${l.email }</td>
			<td>${l.sdt }</td>
			<td><a href="<%=request.getContextPath() %>/UpdateUser?mauser=${l.ma_user }">Edit</a></td>
			<td><a href="<%=request.getContextPath() %>/DeleteUser?mauser=${l.ma_user }">Delete</a></td>
			<td><a href="<%=request.getContextPath() %>/ChangePass?mauser=${l.ma_user }">Đổi mật khẩu</a></td>
		</tr>
	</c:forEach>
		
	</tbody>
</table>


<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>