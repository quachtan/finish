<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Static navbar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div id="navbar" class="navbar-collapse collapse">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/Trangchuuser" />">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<%-- <li class="dropdown"><a href="<c:url value="/" />search">tim phong</a> --%>
				<li><a href="<c:url value="/" />Abcd">Đăng ký phòng
						máy</a></li>
				<li><a href="<c:url value="/" />thoikhoabieu">Thời khoá
						biểu</a></li>
				<c:if test="${loginedUser !=null}">
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>

				</c:if>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>
