<%@page import="fpt.finish.until.MyUtils"%>
<%@page import="java.sql.Connection"%>
<%@page import="fpt.finish.Dao.MonhocDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>
	<div class="container">
		<jsp:include page="Header.jsp" />
		<jsp:include page="menu.jsp" />
		<%
			String errLD = "";
			String errDK = "";
			if (request.getAttribute("errLD") != null) {
				errLD = (String) request.getAttribute("errLD");
			}
			if (request.getAttribute("errDK") != null) {
				errDK = (String) request.getAttribute("errDK");
			}
		%>

		<form action="<%=request.getContextPath()%>/dangkypmform"
			method="POST" role="form">
			<div class="col-md-4 col-md-offset-4 formcontainer">
				<legend><a class="glyphicon glyphicon-arrow-left" href="<%=request.getContextPath()%>/Abcd"></a>Xác nhận đăng ký</legend>

				<div class="form-group">
					<label for="">Mã giảng viên:</label> <input type="text"
						readonly="readonly" class="form-control" name="ma_user_haui"
						value="<%=session.getAttribute("magv")%>"> <label for="">Mã
						phòng:</label> <input type="text" readonly="readonly" class="form-control"
						name="maphong" value="<%=session.getAttribute("maphong")%>">
					<label for="">Lớp độc lập:</label> <select name="malopdl"
						id="input" class="form-control" required="required">
						<%
							int m = Integer.parseInt(String.valueOf(session.getAttribute("solopdl")));
							for (int i = 0; i < m; i++) {
								out.print("<option value='" + session.getAttribute(String.valueOf(i)) + "'>"
										+ session.getAttribute(String.valueOf(i)) + "</option>");
							}
						%>
					</select> <label for="">Môn học:</label> <select name="mamon" id="input"
						class="form-control" required="required">
						<%
							MonhocDao monhocDao = new MonhocDao();
							Connection conn = MyUtils.getStoredConnection(request);
							int n = Integer.parseInt(String.valueOf(session.getAttribute("somon")));
							for (int j = m + 1; j < n; j++) {
								out.print("<option value='"
										+ monhocDao.check_mamon(String.valueOf(session.getAttribute(String.valueOf(j))), conn) + "'>"
										+ session.getAttribute(String.valueOf(j)) + "</option>");
							}
						%>
					</select> <label for="">Ca:</label> <input type="text" readonly="readonly"
						class="form-control" name="ca"
						value="<%=session.getAttribute("ca")%>"> <label for="">Ngày
						đăng ký:</label> <input type="text" readonly="readonly"
						class="form-control" name="day"
						value="<%=session.getAttribute("day")%>">
					<p class='err'><%=errLD%></p>
					<p class='err'><%=errDK%></p>

				</div>



				<button type="submit" class="btn btn-primary">Xác nhận</button>
			</div>
		</form>
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>