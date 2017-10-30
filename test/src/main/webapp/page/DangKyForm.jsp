<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/dangkypmform">
<table>
<tr>
<td>Mã giảng viên:</td>
<td><input type="text" name="ma_user_haui" value="<%=request.getAttribute("magv") %>"></td>
</tr>
<tr>
<td>Mã phòng:</td>
<td><input type="text" name="maphong" id="maphong"></td>
</tr>
<tr>
<td>Môn học:</td>
<td><input type="text" name="mamon"></td>
</tr>
<tr>
<td>Ca:</td>
<td><input type="text" name="ca" value="<%=request.getAttribute("ca")%>"></td>
</tr>
<tr>
<td>Ngày:</td>
<td><input type="text" name="day" value="<%=request.getAttribute("day")%>"></td>
</tr>
<tr>
<td colspan="2" style="text-align: center;"><input type="submit" value="Gửi"></td>
</tr>
</table>
</form>
</body>
</html>