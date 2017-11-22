<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>

<body>
 <div class="container" >
<jsp:include page="Header.jsp" />
		<jsp:include page="menu1.jsp" />
<table class="table table-hover" border="1">
	<thead>
			<tr style="background-color: yellow;">
			<th>Mã tài khoản</th>
			<th>Tên tài khoản</th>
			<th>Họ và tên</th>
			<th>Email</th>
			<th>Số điện thoại</th>
			<th>Cập nhật thông tin</th>
			<th>Xoá tài khoản</th>
			
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
			<td><a href="<%=request.getContextPath() %>/UpdateUser?mauser=${l.ma_user }">Cập nhật thông tin</a></td>
			<td><a href="<%=request.getContextPath() %>/DeleteUser?mauser=${l.ma_user }">Xoá tài khoản</a></td>
		</tr>
	</c:forEach>
		
	</tbody>
</table>
<a href="<%=request.getContextPath() %>/AddNewUser">THÊM TÀI KHOẢN</a>

<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>