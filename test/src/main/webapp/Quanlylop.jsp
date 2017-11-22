<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Mã Yên Quán-Khu ẩm thực núi rừng</title>


<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<div class="container" >

<jsp:include page="Header.jsp" />
		<jsp:include page="menu1.jsp" />
		<form method="post"
		action="${pageContext.request.contextPath}/Uploadlop"
		enctype="multipart/form-data">

		Select file to upload: <br /> <input type="file" class="form-control" name="anh" /> <br />
		
		<br /> <br /> <input type="submit" class="btn btn-primary" value="Upload" />
	</form>
<table class="table table-hover" border="1">

					<thead>
					<tr style="background-color: yellow;">
							<th style="width: 100px; text-align: center;" colspan="1">MÃ LỚP ĐỘC LẬP</th>
							<th style="width: 100px; text-align: center;" colspan="1">TÊN LỚP</th>
							<th style="width: 100px; text-align: center;" colspan="1">CẬP NHẬT</th>
							<th style="width: 100px; text-align: center;" colspan="1">XOÁ</th>
							<!-- <th style="width: 150px;text-align: center;" colspan="1">THU 6</th>
					<th style="width: 150px;text-align: center;" colspan="1">THU 7</th> -->
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${listThayDoi}" varStatus="statusItem">
							<tr class="odd">
								<td style="text-align: center;">${row.malopdl}</td>
								<td style="text-align: center;">${row.tenlopondinh}</td>

								
						<%-- 		<td class="center ">${row.noidung}</td>
 --%>								<%-- <td class="center"><button class="btnCapnhat btn icon-edit "
								title="luu" iduser="${row.id}">Update</button></td>
						<td class="center"><button name="btnxoa"
								title="xoa" id="${row.id}"  onclick="Redirect();">DELETE</button></td> --%>
								 <td style="text-align: center;"><a href="Sualop?malopdl=${row.malopdl}">CẬP NHẬT</a></td>
								 <td style="text-align: center;"><a href="Xoalop?malopdl=${row.malopdl}">XOÁ</a></td>
								<%-- <td><a href="${row.id}">delete</a></td>  --%>
							</tr>
						</c:forEach>
					</tbody>

		


	</table>
	
			<a href="/test/Themlop">THÊM LỚP DẠY</a>
		
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
 
</html>

