<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Mã Yên Quán-Khu ẩm thực núi rừng</title>


<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
	<div class="container">
		
		<div class="section">
			<div class="form-group">
			<div style="padding: 5px; color: red; font-style: italic;">
		${errorMessage}</div>

	<h2>Upload Files</h2>

	<form method="post"
		action="${pageContext.request.contextPath}/Uploadmon"
		enctype="multipart/form-data">

		Select file to upload: <br /> <input type="file" name="anh" /> <br />
		Description: <br /> <input type="text" name="description" size="100" />
		<br /> <br /> <input type="submit" value="Upload" />
	</form>
				<table id="" class="table">
					<thead>
						<tr>
							<th style="width: 100px; text-align: center;" colspan="1">MAMON</th>
							<th style="width: 100px; text-align: center;" colspan="1">TENMON</th>
							<th style="width: 100px; text-align: center;" colspan="1">UPDATE</th>
							<th style="width: 100px; text-align: center;" colspan="1">DELETE</th>
							<!-- <th style="width: 150px;text-align: center;" colspan="1">THU 6</th>
					<th style="width: 150px;text-align: center;" colspan="1">THU 7</th> -->
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${listThayDoi}" varStatus="statusItem">
							<tr class="odd">
								<td style="text-align: center;">${row.mamon}</td>
								<td style="text-align: center;">${row.tenmon}</td>

								
						<%-- 		<td class="center ">${row.noidung}</td>
 --%>								<%-- <td class="center"><button class="btnCapnhat btn icon-edit "
								title="luu" iduser="${row.id}">Update</button></td>
						<td class="center"><button name="btnxoa"
								title="xoa" id="${row.id}"  onclick="Redirect();">DELETE</button></td> --%>
								 <td style="text-align: center;"><a href="Suamon?mamon=${row.mamon}">UPDATE</a></td>
								 <td style="text-align: center;"><a href="Xoamon?mamon=${row.mamon}">XOA</a></td>
								<%-- <td><a href="${row.id}">delete</a></td>  --%>
							</tr>
						</c:forEach>
					</tbody>

					<tr style="width: 40%">
						<td><a href="/test/Themmon">THÊM PHÒNG MÁY</a>

					</tr>


				</table>
			</div>
		</div>
		<script type="text/javascript">
			function Redirect() {
				var id = document.getElementById("txtname").value;
				alert("XIN CHAO:" + id);
				var url = "<c:url value="tk"/>" + "/" + id;
				window.location.href = url;
			}
		</script>
	<br style="clear: both" />
	
	</div>
</body>
 
</html>

