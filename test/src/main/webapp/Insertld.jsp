<%@page import="fpt.finish.until.MyUtils"%>
<%@page import="java.sql.Connection"%>
<%@page import="fpt.finish.Dao.MonhocDao"%>

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
<form action="<%=request.getContextPath()%>/Addlichday" method="POST" role="form">
<div class="col-md-4 col-md-offset-4 formcontainer">
	<div class="form-group">
		<label for="">Mã giảng viên</label>
		<input type="text"  class="form-control" name="ma_user">
		<label for="">Mã lớp đl</label>
		<input type="text"  class="form-control" name="malopdl">
		<label for="">Mã môn</label>
		<input type="text"  class="form-control" name="mamon">
		<label for="">Lịch dạy</label>
		<input type="text"  class="form-control" name="lichday">
	</div>

	

	<button type="submit" class="btn btn-primary">Xác nhận</button>
	</div>
</form>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>