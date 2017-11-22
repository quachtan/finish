<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<% String err="";
if(request.getAttribute("err")!=null){
	err=(String) request.getAttribute("err");
}
%>

		
<div class="container" >
<jsp:include page="Header.jsp" />
		<jsp:include page="menu1.jsp" />
<form action="<%=request.getContextPath()%>/AddNewUser" method="POST" role="form">
<div class="col-md-4 col-md-offset-4 formcontainer" style="height: 430px;">

	<div class="form-group" style="margin-top: 50px;">
			<label for="">Mã tài khoản:</label>
			<input type="text" class="form-control" name="ma_user">
			<label for="">Tên tài khoản:</label>
			<input type="text" class="form-control" name="username">
			<label for="">Mật khẩu:</label>
			<input type="password" class="form-control" name="password">
			<p class='err'><%=err%></p>
			
		</div>
	
		
	
		<button type="submit" class="btn btn-primary">Tạo</button>
		</div>
	</form>
	
	<jsp:include page="footer.jsp" />
	</div>
	
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>