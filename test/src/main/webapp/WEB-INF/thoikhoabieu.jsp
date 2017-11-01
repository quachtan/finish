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
						<td>${cnsang.tenphong}<br>${cnsang.mamon}<br> <c:if
								test="${cnsang.tenphong != null}">

								<a href="huyphong?id=${cnsang}">Huy</a>
							</c:if></td>
						<td>${thu2sang.tenphong}<br>${thu2sang.mamon}<br> <c:if
								test="${thu2sang.tenphong != null}">

								<a href="huyphong?id=${thu2sang}">Huy</a>
							</c:if></td>

						<td>${thu3sang.tenphong}<br>${thu3sang.mamon}<br> <c:if
								test="${thu3sang.tenphong != null}">

								<a href="huyphong?id=${thu3sang.id}">Huy</a>
							</c:if></td>
						<td>${thu4sang.tenphong}<br>${thu4sang.mamon}<br> <c:if
								test="${thu4sang.tenphong != null}">
								<a href="huyphong?id=${thu4sang.id}">Huy</a>
							</c:if>
						</td>
						<td>${thu5sang.tenphong}<br>${thu5sang.mamon}<br> <c:if
								test="${thu5sang.tenphong != null}">

								<a href="huyphong?id=${thu5sang.id}">Huy</a>
							</c:if></td>
						<td>${thu6sang.tenphong}<br>${thu6sang.mamon}<br> <c:if
								test="${thu6sang.tenphong != null}">
								<a href="huyphong?id=${thu6sang.id}">Delete</a>
							</c:if></td>
						<td>${thu7sang.tenphong}<br>${thu7sang.mamon}<br> <c:if
								test="${thu7sang.tenphong != null}">

								<a href="huyphong?id=${thu7sang.id}">Huy</a>
							</c:if></td>
					</tr>
					<tr>
						<td>Chiều</td>
						<td>${cnchieu.tenphong}<br>${cnchieu.mamon}<c:if
								test="${cnchieu.tenphong != null}">

								<a href="huyphong?id=${thu2chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu2chieu.tenphong}<br>${thu2chieu.mamon}<c:if
								test="${thu2chieu.tenphong != null}">

								<a href="huyphong?id=${thu2chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu3chieu.tenphong}<br>${thu3chieu.mamon}<c:if
								test="${thu3chieu.tenphong != null}">

								<a href="huyphong?id=${thu3chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu4chieu.tenphong}<br>${thu4chieu.mamon}<c:if
								test="${thu4chieu.tenphong != null}">

								<a href="huyphong?id=${thu4chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu5chieu.tenphong}<br>${thu5chieu.mamon} <br>
							<c:if test="${thu5chieu.tenphong != null}">
								<a href="huyphong?id=${thu5chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu6chieu.tenphong}<br>${thu6chieu.mamon}<br>
							<c:if test="${thu6chieu.tenphong != null}">

								<a href="huyphong?id=${thu6chieu.id}">Huy</a>
							</c:if></td>
						<td>${thu7chieu.tenphong}<br>${thu7chieu.mamon}<br>
							<c:if test="${thu7chieu.tenphong != null}">

								<a href="huyphong?id=${thu7chieu.id}">Huy</a>
							</c:if></td>
					<tr>
						<td>Tối</td>
						<td>${cntoi.tenphong}<br>${cntoi.mamon}<c:if
								test="${cntoi.tenphong != null}">

								<a href="huyphong?id=${cntoi.id}">Huy</a>
							</c:if></td>
						<td>${thu2toi.tenphong}<br>${thu2toi.mamon}<c:if
								test="${thu2toi.tenphong != null}">

								<a href="huyphong?id=${thu2toi.id}">Huy</a>
							</c:if></td>
						<td>${thu3toi.tenphong}<br>${thu3toi.mamon}<c:if
								test="${thu3toi.tenphong != null}">

								<a href="huyphong?id=${thu3toi.id}">Huy</a>
							</c:if></td>
						<td>${thu4toi.tenphong}<br>${thu4toi.mamon}<c:if
								test="${thu4toi.tenphong != null}">

								<a href="huyphong?id=${thu4toi.id}">Huy</a>
							</c:if></td>
						<td>${thu5toi.tenphong}<br>${thu5toi.mamon}<c:if
								test="${thu5toi.tenphong != null}">

								<a href="huyphong?id=${thu5toi.id}">Huy</a>
							</c:if></td>
						<td>${thu6toi.tenphong}<br>${thu6toi.mamon}<c:if
								test="${thu6toi.tenphong != null}">

								<a href="huyphong?id=${thu6toi.id}">Huy</a>
							</c:if></td>
						<td>${thu7toi.tenphong}<br>${thu7toi.mamon}<c:if
								test="${thu7toi.tenphong != null}">

								<a href="huyphong?id=${thu7toi.id}">Huy</a>
							</c:if></td>
					</tr>
				</table>
				<p>${ngay}</p>
				<a href="next?ngay=${ngay}">>></a>
			</div>
		</div>
		<br style="clear: both" />
		
	</div>



</body>

</html>