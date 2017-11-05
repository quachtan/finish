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
	<form method="POST" action="${pageContext.request.contextPath}/Insertpm" >
		<table>
			<tr>

				<td>Mã phòng</td>
				<td><input type="text" name="maphong" /></td>
			</tr>
			<tr>
				<td>Tên phòng</td>
				<td><input type="text" name="tenphong" />
			</tr>
			<tr>
				<td>Số máy</td>
				<td><input type="text" name="somay" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>


</body>
</html>