<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
	<div class="container">
		
		<p style="color: red;">${errorString}</p>
		<div class="section">
			<div class="form-group">
				<table id="" class="table">

					<tr>
						<th>Ca</th>
						<th>Chủ nhật
						<th>thứ hai</th>
						<th>thứ ba</th>
						<th>thứ tư</th>
						<th>thứ năm</th>
						<th>thứ sáu</th>
						<th>thứ bảy</th>
					</tr>
					<tr>
						<td>Sáng</td>
						<td>${cnsang.malopdl}<br>${cnsang.tenmon}<br>${cnsang.tengv}<br>${cnsang.tenlopondinh}<br>${cnsang.lichday}<br> <c:if
								test="${cnsang.tenphong != null}">

								<a href="huyphong?id=${cnsang.id}">Huy</a>
							</c:if></td>
						<td>${thu2sang.malopdl}<br>${thu2sang.tenmon}<br>${thu2sang.tengv}<br>${thu2sang.tenlopondinh}<br>${thu2sang.lichday}<br> <c:if
								test="${thu2sang.tenphong != null}">

								<a href="huyphong?id=${thu2sang.id}">Huy</a>
							</c:if></td>

						<td>${thu3sang.malopdl}<br>${thu3sang.tenmon}<br>${thu3sang.tengv}<br>${thu3sang.tenlopondinh}<br>${thu3sang.lichday}<br> <c:if
								test="${thu3sang.tenphong != null}">

								<a href="huyphong?id=${thu3sang.id}">Huy</a>
							</c:if></td>
						<td>${thu4sang.malopdl}<br>${thu4sang.tenmon}<br>${thu4sang.tengv}<br>${thu4sang.tenlopondinh}<br>${thu4sang.lichday}<br> <c:if
								test="${thu4sang.tenphong != null}">
								<a href="huyphong?id=${thu4sang.id}">Huy</a>
							</c:if>
						</td>
						<td>${thu5sang.malopdl}<br>${thu5sang.tenmon}<br>${thu5sang.tengv}<br>${thu5sang.tenlopondinh}<br>${thu5sang.lichday}<br> <c:if
								test="${thu5sang.tenphong != null}">

								<a href="huyphong?id=${thu5sang.id}">Huy</a>
							</c:if></td>
						<td>${thu6sang.malopdl}<br>${thu6sang.tenmon}<br>${thu6sang.tengv}<br>${thu6sang.tenlopondinh}<br>${thu6sang.lichday}<br> <c:if
								test="${thu6sang.tenphong != null}">
								<a href="huyphong?id=${thu6sang.id}">Delete</a>
							</c:if></td>
						<td>${thu7sang.malopdl}<br>${thu7sang.tenmon}<br>${thu7sang.tengv}<br>${thu7sang.tenlopondinh}<br>${thu7sang.lichday}<br> <c:if
								test="${thu7sang.tenphong != null}">

								<a href="huyphong?id=${thu7sang.id}">Huy</a>
							</c:if></td>
					</tr>
					<tr>
						<td>Chiều</td>
						<td>${cnchieu.malopdl}<br>${cnchieu.tenmon}<br>${cnchieu.tengv}<br>${cnchieu.tenlopondinh}<br>${cnchieu.lichday}<c:if
								test="${cnchieu.tenphong != null}">

								<a href="huyphong?id=${cnchieu.id}">Huy</a>
							</c:if></td>
						<td>${thu2chieu.malopdl}<br>${thu2chieu.tenmon}<br>${thu2chieu.tengv}<br>${thu2chieu.tenlopondinh}<br>${thu2chieu.lichday}<c:if
								test="${thu2chieu.tenphong != null}">

								<a href="huyphong?id=${thu2chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu3chieu.malopdl}<br>${thu3chieu.tenmon}<br>${thu3chieu.tengv}<br>${thu3chieu.tenlopondinh}<br>${thu3chieu.lichday}<c:if
								test="${thu3chieu.tenphong != null}">

								<a href="huyphong?id=${thu3chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu4chieu.malopdl}<br>${thu4chieu.tenmon}<br>${thu4chieu.tengv}<br>${thu4chieu.tenlopondinh}<br>${thu4chieu.lichday}<c:if
								test="${thu4chieu.tenphong != null}">

								<a href="huyphong?id=${thu4chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu5chieu.malopdl}<br>${thu5chieu.tenmon}<br>${thu5chieu.tengv}<br>${thu5chieu.tenlopondinh}<br>${thu5chieu.lichday} <br>
							<c:if test="${thu5chieu.tenphong != null}">
								<a href="huyphong?id=${thu5chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu6chieu.malopdl}<br>${thu6chieu.tenmon}<br>${thu6chieu.tengv}<br>${thu6chieu.tenlopondinh}<br>${thu6chieu.lichday}<br>
							<c:if test="${thu6chieu.tenphong != null}">

								<a href="huyphong?id=${thu6chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu7chieu.malopdl}<br>${thu7chieu.tenmon}<br>${thu7chieu.tengv}<br>${thu7chieu.tenlopondinh}<br>${thu7chieu.lichday}<br>
							<c:if test="${thu7chieu.tenphong != null}">

								<a href="huyphong?id=${thu7chieu.id}">Huy</a>
							</c:if></td>
					<tr>
						<td>Tối</td>
						<td>${cntoi.malopdl}<br>${cntoi.tenmon}<br>${cntoi.tengv}<br>${cntoi.tenlopondinh}<br>${cntoi.lichday}<c:if
								test="${cntoi.tenphong != null}">

								<a href="huyphong?id=${cntoi.id}">Huy</a>
							</c:if></td>
						<td>${thu2toi.malopdl}<br>${thu2toi.tenmon}<br>${thu2toi.tengv}<br>${thu2toi.tenlopondinh}<br>${thu2toi.lichday}<c:if
								test="${thu2toi.tenphong != null}">

								<a href="huyphong?id=${thu2toi.id}">Huy</a>
							</c:if></td>
						<td>${thu3toi.malopdl}<br>${thu3toi.tenmon}<br>${thu3toi.tengv}<br>${thu3toi.tenlopondinh}<br>${thu3toi.lichday}<c:if
								test="${thu3toi.tenphong != null}">

								<a href="huyphong?id=${thu3toi.id}">Huy</a>
							</c:if></td>
						<td>${thu4toi.malopdl}<br>${thu4toi.tenmon}<br>${thu4toi.tengv}<br>${thu4toi.tenlopondinh}<br>${thu4toi.lichday}<c:if
								test="${thu4toi.tenphong != null}">

								<a href="huyphong?id=${thu4toi.id}">Huy</a>
							</c:if></td>
						<td>${thu5toi.malopdl}<br>${thu5toi.tenmon}<br>${thu5toi.tengv}<br>${thu5toi.tenlopondinh}<br>${thu5toi.lichday}<c:if
								test="${thu5toi.tenphong != null}">

								<a href="huyphong?id=${thu5toi.id}">Huy</a>
							</c:if></td>
						<td>${thu6toi.malopdl}<br>${thu6toi.tenmon}<br>${thu6toi.tengv}<br>${thu6toi.tenlopondinh}<br>${thu6toi.lichday}<c:if
								test="${thu6toi.tenphong != null}">

								<a href="huyphong?id=${thu6toi.id}">Huy</a>
							</c:if></td>
						<td>${thu7toi.malopdl}<br>${thu7toi.tenmon}<br>${thu7toi.tengv}<br>${thu7toi.tenlopondinh}<br>${thu7toi.lichday}<c:if
								test="${thu7toi.tenphong != null}">

								<a href="huyphong?id=${thu7toi.id}">Huy</a>
							</c:if></td>
					</tr>
				</table>
				<p>${ngay}</p>
				<a href="next?ngay=${ngay}">>></a>
				<a href="lui?ngay=${ngay}">AA</a>
			</div>
		</div>
		<br style="clear: both" />
		
	</div>



</body>

</html>