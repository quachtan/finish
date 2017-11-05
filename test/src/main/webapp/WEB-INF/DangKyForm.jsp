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
	<link rel="stylesheet" href="css/dangkyform.css">
</head>
<body>
<form action="<%=request.getContextPath()%>/dangkypmform" method="POST" role="form">
<div class="col-md-4 col-md-offset-4 formcontainer">
	<legend>Xác nhận đăng ký</legend>

	<div class="form-group">
		<label for="">Mã giảng viên:</label>
		<input type="text" readonly="readonly" class="form-control" name="ma_user_haui" value="<%=request.getAttribute("magv") %>">
		<label for="">Mã phòng:</label>
		<input type="text" readonly="readonly" class="form-control" name="maphong" value="<%=request.getAttribute("maphong")%>">
		<label for="">Lớp độc lập:</label>
		<select name="malopdl" id="input" class="form-control" required="required">
			<%
int m=Integer.parseInt(String.valueOf(request.getAttribute("solopdl")));
for(int i=0;i<m;i++){
	out.print("<option value='"+request.getAttribute(String.valueOf(i))+"'>"+request.getAttribute(String.valueOf(i))+"</option>");
} 
%>
		</select>
		<label for="">Môn học:</label>
		<select name="mamon" id="input" class="form-control" required="required">
			<%
MonhocDao monhocDao=new MonhocDao();
		Connection conn=MyUtils.getStoredConnection(request);
int n=Integer.parseInt(String.valueOf(request.getAttribute("somon")));
for(int j=m+1;j<n;j++){
	out.print("<option value='"+monhocDao.check_mamon(String.valueOf(request.getAttribute(String.valueOf(j))),conn)+"'>"+request.getAttribute(String.valueOf(j))+"</option>");
} 
%>
		</select>
		<label for="">Ca:</label>
		<input type="text" readonly="readonly" class="form-control" name="ca" value="<%=request.getAttribute("ca") %>">
		<label for="">Ngày đăng ký:</label>
		<input type="text" readonly="readonly" class="form-control" name="day" value="<%=request.getAttribute("day") %>">
	</div>

	

	<button type="submit" class="btn btn-primary">Xác nhận</button>
	</div>
</form>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>