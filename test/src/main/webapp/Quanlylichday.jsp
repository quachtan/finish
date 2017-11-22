<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>
<html>
<head>
<title>Upload files</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<div class="container" >

<jsp:include page="Header.jsp" />
		<jsp:include page="menu1.jsp" />
		<form method="post"
		action="${pageContext.request.contextPath}/uploadFile"
		enctype="multipart/form-data">

		Select file to upload: <br /> <input type="file" class="form-control" name="anh" /> <br />
		
		<br /> <br /> <button type="submit" class="btn btn-primary">Xác nhận</button>
	</form>
<table class="table table-hover" border="1">

	

	
	
		<thead>
				<tr style="background-color: yellow;">
				<th style="width: 100px; text-align: center;" colspan="1">ID</th>
				<th style="width: 100px; text-align: center;" colspan="1">MÃ GIẢNG VIÊN</th>
				<th style="width: 100px; text-align: center;" colspan="1">MÃ LỚP ĐỘC LẬP</th>
				<th style="width: 100px; text-align: center;" colspan="1">MÃ MÔN</th>
				<th style="width: 100px; text-align: center;" colspan="1">LỊCH DẠY</th>
				<th style="width: 150px;text-align: center;" colspan="1">CẬP NHẬT</th>
				<th style="width: 150px;text-align: center;" colspan="1">XOÁ</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${listThayDoi}" varStatus="statusItem">
				<tr class="odd">
					<td style="text-align: center;">${row.id}</td>
					<td style="text-align: center;">${row.ma_user}</td>
					<td style="text-align: center;">${row.malopdl}</td>
					<td style="text-align: center;">${row.mamon}</td>
					<td style="text-align: center;">${row.lichday}</td>
					<%-- 		<td class="center ">${row.noidung}</td>
 --%>
					<%-- <td class="center"><button class="btnCapnhat btn icon-edit "
								title="luu" iduser="${row.id}">Update</button></td>
						<td class="center"><button name="btnxoa"
								title="xoa" id="${row.id}"  onclick="Redirect();">DELETE</button></td> --%>
					<td style="text-align: center;"><a
						href="Editlichday?id=${row.id}">CẬP NHẬT</a></td>
					<td style="text-align: center;"><a
						href="Deletelichday?id=${row.id}">XOÁ</a></td>
					<%-- <td><a href="${row.id}">delete</a></td>  --%>
				</tr>
			</c:forEach>
		</tbody>

		


	</table>
	
			<a href="/test/Addlichday">THÊM LỊCH DẠY</a>
		
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>