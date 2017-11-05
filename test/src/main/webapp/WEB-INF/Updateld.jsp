<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page session="false"%>



<div class="section">
	<div class="form-group">
	  <form method="POST" action="${pageContext.request.contextPath}/Editlichday">
		<table id="" class="table">
			<thead>
				<tr>
					<th style="width: 100px;" colspan="1">Mã Phòng</th>
					<th style="width: 100px;" colspan="1">Tên Phòng</th>
					<th style="width: 200px;" colspan="1">Số Máy</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${pmbean != null }">
					<tr class="odd">
						<td class="center">${pmbean.id}</td>
						<td class="center">${pmbean.ma_user}</td>
						<td class="center ">${pmbean.malopdl}</td>
						<td class="center ">${pmbean.mamon}</td>
						<td class="center ">${pmbean.lichday}</td>
					</tr>
				</c:if>
			</tbody>
				<tr>
				<td>ID</td>
				<td><input name="id" id="id" value="${pmbean.id}" /></td>
			</tr>
			<tr>
				<td>Mã User</td>
				<td><input name="ma_user" id="ma_user" value="${pmbean.ma_user}" /></td>
			</tr>
			<tr>
				<td>Mã lớp đl</td>
				<td><input name="malopdl" id="malopdl" value="${pmbean.malopdl}" /></td>
			</tr>
			<tr>
				<td>Mã môn</td>
				<td><input name="mamon" id="mamon" value="${pmbean.mamon}" /></td>
			</tr>
			<tr>
				<td>Lịch dạy</td>
				<td><input name="lichday" id="lichday" value="${pmbean.lichday}" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
		  </form>
	</div>
</div>


