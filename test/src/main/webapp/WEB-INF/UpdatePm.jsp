<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page session="false"%>



<div class="section">
	<div class="form-group">
	  <form method="POST" action="${pageContext.request.contextPath}/editpm">
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
						<td class="center">${pmbean.maphong}</td>
						<td class="center ">${pmbean.tenphong}</td>
						<td class="center ">${pmbean.somay}</td>

					</tr>
				</c:if>
			</tbody>
			<tr>
				<td>Mã Phòng</td>
				<td><input name="maphong" id="maphong" value="${pmbean.maphong}" /></td>
			</tr>
			<tr>
				<td>Tên Phòng</td>
				<td><input name="tenphong" id="tenphong" value="${pmbean.tenphong}" /></td>
			</tr>
			<tr>
				<td>Số Máy</td>
				<td><input name="somay" id="somay" value="${pmbean.somay}" /></td>
			</tr>

		</table>
		<input type="submit" value="Submit" />
		  </form>
	</div>
</div>


