<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<h1>Đăng ký phòng máy</h1>
<table border="1">
<tr>
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
</table>
</body>
</html>