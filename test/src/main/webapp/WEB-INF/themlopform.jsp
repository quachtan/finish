<%@page import="fpt.finish.until.MyUtils"%>
<%@page import="java.sql.Connection"%>
<%@page import="fpt.finish.Dao.MonhocDao"%>

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

		
<div class="container" >
<jsp:include page="Header.jsp" />
		<jsp:include page="menu1.jsp" />
<form action="<%=request.getContextPath()%>/Themlop" method="POST" role="form">
<div class="col-md-4 col-md-offset-4 formcontainer" style="height: 430px;">

	<div class="form-group" style="margin-top: 20px;">
		<label for="">Mã lớp độc lập</label>
		<input type="text"  class="form-control" name="malopdl">
		<label for="">Tên lớp ổn định</label>
		<input type="text"  class="form-control" name="tenlopondinh">
	</div>

	

	<button type="submit" class="btn btn-primary">Xác nhận</button>
	</div>
	</form>
	
	<jsp:include page="footer.jsp" />
	</div>
	
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>