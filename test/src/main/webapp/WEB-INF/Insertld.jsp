<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/Addlichday" >
		<table>
			<tr>

				<td>Mã user</td>
				<td><input type="text" name="ma_user" /></td>
			</tr>
			<tr>
				<td>Mã lớp ĐL</td>
				<td><input type="text" name="malopdl" />
			</tr>
			<tr>
				<td>Mã môn</td>
				<td><input type="text" name="mamon" /></td>
			</tr>
			<tr>
				<td>Lịch dạy</td>
				<td><input type="text" name="lichday" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>


</body>
</html>