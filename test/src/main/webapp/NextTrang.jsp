<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>
	<div class="container">
		<jsp:include page="Header.jsp" />
		<jsp:include page="menu.jsp" />
		 <form action="next" method="post">
		<table class="table table-hover" border="1">

			<tr style="background-color: yellow;">
				<th>Ca</th>
				<th>Chủ nhật</th>
				<th>thứ hai</th>
				<th>thứ ba</th>
				<th>thứ tư</th> 
				<th>thứ năm</th>
				<th>thứ sáu</th>
				<th>thứ bảy</th>
			</tr>
			<tr>
				<td>Sáng</td>
				<c:if test="${cnsang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${cnsang.tenphong != null}">
				<td>${cnsang.malopdl}<br>${cnsang.tenmon}<br>${cnsang.tengv}<br>${cnsang.tenlopondinh};LT:${cnsang.lichday}<br>
					

						<a href="huyphong?id=${cnsang.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu2sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu2sang.tenphong != null}">
				<td>${thu2sang.malopdl}<br>${thu2sang.tenmon}<br>${thu2sang.tengv}<br>${thu2sang.tenlopondinh};LT:${thu2sang.lichday}<br>
					

						<a href="huyphong?id=${thu2sang.id}">Huỷ</a>
					</td></c:if>
				<c:if test="${thu3sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu3sang.tenphong != null}">
				<td>${thu3sang.malopdl}<br>${thu3sang.tenmon}<br>${thu3sang.tengv}<br>${thu3sang.tenlopondinh};LT:${thu3sang.lichday}<br>
					

						<a href="huyphong?id=${thu3sang.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu4sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu4sang.tenphong != null}">
				<td>${thu4sang.malopdl}<br>${thu4sang.tenmon}<br>${thu4sang.tengv}<br>${thu4sang.tenlopondinh};LT:${thu4sang.lichday}<br>
					
						<a href="huyphong?id=${thu4sang.id}">Huỷ</a>
					
				</td>
				</c:if>
				<c:if test="${thu5sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu5sang.tenphong != null}">
				<td>${thu5sang.malopdl}<br>${thu5sang.tenmon}<br>${thu5sang.tengv}<br>${thu5sang.tenlopondinh};LT:${thu5sang.lichday}<br>
					

						<a href="huyphong?id=${thu5sang.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu6sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu6sang.tenphong != null}">
				<td>${thu6sang.malopdl}<br>${thu6sang.tenmon}<br>${thu6sang.tengv}<br>${thu6sang.tenlopondinh};LT:${thu6sang.lichday}<br>
					
						<a href="huyphong?id=${thu6sang.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu7sang.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu7sang.tenphong != null}">
				<td>${thu7sang.malopdl}<br>${thu7sang.tenmon}<br>${thu7sang.tengv}<br>${thu7sang.tenlopondinh};LT:${thu7sang.lichday}<br>
					

						<a href="huyphong?id=${thu7sang.id}">Huỷ</a>
					</td></c:if>
			</tr>
			<tr>
				<td>Chiều</td>
				<c:if test="${cnchieu.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${cnchieu.tenphong != null}">
				<td>${cnchieu.malopdl}<br>${cnchieu.tenmon}<br>${cnchieu.tengv}<br>${cnchieu.tenlopondinh};LT:${cnchieu.lichday}

						<a href="huyphong?id=${cnchieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu2chieu.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu2chieu.tenphong != null}">
				<td>${thu2chieu.malopdl}<br>${thu2chieu.tenmon}<br>${thu2chieu.tengv}<br>${thu2chieu.tenlopondinh};LT:${thu2chieu.lichday}

						<a href="huyphong?id=${thu2chieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu3chieu.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu3chieu.tenphong != null}">
				<td>${thu3chieu.malopdl}<br>${thu3chieu.tenmon}<br>${thu3chieu.tengv}<br>${thu3chieu.tenlopondinh};LT:${thu3chieu.lichday}

						<a href="huyphong?id=${thu3chieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu4chieu.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu4chieu.tenphong != null}">
				<td>${thu4chieu.malopdl}<br>${thu4chieu.tenmon}<br>${thu4chieu.tengv}<br>${thu4chieu.tenlopondinh};LT:${thu4chieu.lichday}

						<a href="huyphong?id=${thu4chieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu5chieu.tenphong == null}">
				<td></td>
				</c:if>
				<c:if test="${thu5chieu.tenphong != null}">
				<td>${thu5chieu.malopdl}<br>${thu5chieu.tenmon}<br>${thu5chieu.tengv}<br>${thu5chieu.tenlopondinh};LT:${thu5chieu.lichday}
					<br> 
						<a href="huyphong?id=${thu5chieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu6chieu.tenphong == null}">
				<td></td>
				</c:if>
					<c:if test="${thu6chieu.tenphong != null}">
				<td>${thu6chieu.malopdl}<br>${thu6chieu.tenmon}<br>${thu6chieu.tengv}<br>${thu6chieu.tenlopondinh};LT:${thu6chieu.lichday}<br>
				

						<a href="huyphong?id=${thu6chieu.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu7chieu.tenphong == null}">
				<td></td>
				</c:if>
					<c:if test="${thu7chieu.tenphong != null}">
				<td>${thu7chieu.malopdl}<br>${thu7chieu.tenmon}<br>${thu7chieu.tengv}<br>${thu7chieu.tenlopondinh};LT:${thu7chieu.lichday}<br>
				

						<a href="huyphong?id=${thu7chieu.id}">Huỷ</a>
					</td></c:if>
			<tr>
				<td>Tối</td>
					<c:if test="${cntoi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${cntoi.tenphong != null}">
				<td>${cntoi.malopdl}<br>${cntoi.tenmon}<br>${cntoi.tengv}<br>${cntoi.tenlopondinh};LT:${cntoi.lichday}

						<a href="huyphong?id=${cntoi.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu2toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu2toi.tenphong != null}">
				<td>${thu2toi.malopdl}<br>${thu2toi.tenmon}<br>${thu2toi.tengv}<br>${thu2toi.tenlopondinh};LT:${thu2toi.lichday}

						<a href="huyphong?id=${thu2toi.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu3toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu3toi.tenphong != null}">
				<td>${thu3toi.malopdl}<br>${thu3toi.tenmon}<br>${thu3toi.tengv}<br>${thu3toi.tenlopondinh};LT:${thu3toi.lichday}

						<a href="huyphong?id=${thu3toi.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu4toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu4toi.tenphong != null}">
				<td>${thu4toi.malopdl}<br>${thu4toi.tenmon}<br>${thu4toi.tengv}<br>${thu4toi.tenlopondinh};LT:${thu4toi.lichday}

						<a href="huyphong?id=${thu4toi.id}">Huỷ</a>
					</td></c:if>
					<c:if test="${thu5toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu5toi.tenphong != null}">
				<td>${thu5toi.malopdl}<br>${thu5toi.tenmon}<br>${thu5toi.tengv}<br>${thu5toi.tenlopondinh};LT:${thu5toi.lichday}

						<a href="huyphong?id=${thu5toi.id}">Huỷ</a>
					</td></c:if>
						<c:if test="${thu6toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu6toi.tenphong != null}">
				<td>${thu6toi.malopdl}<br>${thu6toi.tenmon}<br>${thu6toi.tengv}<br>${thu6toi.tenlopondinh};LT:${thu6toi.lichday}

						<a href="huyphong?id=${thu6toi.id}">Huỷ</a>
				</td>	</c:if>
				<c:if test="${thu7toi.tenphong == null}">
				<td></td>
				</c:if>
				<c:if
						test="${thu7toi.tenphong != null}">
				
				<td>${thu7toi.malopdl}<br>${thu7toi.tenmon}<br>${thu7toi.tengv}<br>${thu7toi.tenlopondinh};LT:${thu7toi.lichday}
						<a href="huyphong?id=${thu7toi.id}">Huỷ</a>
					</td></c:if>
			</tr>
				
		</table>
		<input type="text" name ="ngay" value="${ngay}">
		 <input type="submit" value="Export To Excel"/>
			</form>
		<a href="next?ngay=${ngay}" style="float: right;">Tiến 1 tuần</a>
		<!--  <input type="submit" value="Export To Excel"/>  -->
		<a href="lui?ngay=${ngay}" style="float: left: ;">Lùi 1 tuần</a>
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>




</body>

</html>