<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng ký phòng máy</title>
 <link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<%-- <div class="container" >
<jsp:include page="Header.jsp" />
		<jsp:include page="menu.jsp" /> --%>
		 <form action="thongke" method="post">
<table class="table table-hover" border="1">
		<thead>
			<tr style="background-color: yellow;">
				<th>Phòng</th>
				<th>Ca</th>
				<th>CN</th>
				<th>T2</th>
				<th>T3</th>
				<th>T4</th>
				<th>T5</th>
				<th>T6</th>
				<th>T7</th>
			</tr>
		</thead>
		<tbody>
			<% String sophong=String.valueOf(request.getAttribute("sophong"));
try {
	int m=Integer.parseInt(sophong);
	for(int i=1;i<=m;i++){
		out.print(request.getAttribute(String.valueOf(i).concat("s")));
		out.print(request.getAttribute(String.valueOf(i).concat("c")));
		out.print(request.getAttribute(String.valueOf(i).concat("t")));
	}
}catch (NumberFormatException e){
   out.print("Không có phòng máy nào!");
}
%>
		</tbody>
	</table>
	 <input type="submit" value="Export To Excel"/>
			</form>
<p>Số phòng đã được đăng ký trong tuần: <%=request.getAttribute("soP1tuan") %></p>
<p>Số giảng viên đã đăng ký trong tuần: <%=request.getAttribute("soGV1tuan") %></p>
<p>Số lượt đăng ký trong tuần: <%=request.getAttribute("soL1tuan") %></p>
<a href="Nexttrangthongke?ngay=${ngay}" style="float: right;">Tiến 1 tuần</a>
		<!--  <input type="submit" value="Export To Excel"/>  -->
		<a href="Luitrangthongke?ngay=${ngay}" style="float: left: ;">Lùi 1 tuần</a>
</body>
</html>