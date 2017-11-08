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
	<%-- <jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script> --%>
</body>
</html>