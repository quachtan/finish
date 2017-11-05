<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page session="false"%>



<div class="section">
	<div class="form-group">
	  <form method="POST" action="${pageContext.request.contextPath}/Suamon">
		<table id="" class="table">
			<thead>
				<tr>
					<th style="width: 100px;" colspan="1">Mã môn</th>
					<th style="width: 100px;" colspan="1">Tên môn</th>
				
				</tr>
			</thead>
			<tbody>
				<c:if test="${pmbean != null }">
					<tr class="odd">
						<td class="center">${pmbean.mamon}</td>
						<td class="center">${pmbean.tenmon}</td>
				
					</tr>
				</c:if>
			</tbody>
				<tr>
				<td>MLDL</td>
				<td><input name="mamon" id="mamon" value="${pmbean.mamon}" /></td>
			</tr>
			<tr>
				<td>TLOD</td>
				<td><input name="tenmon" id="tenmon" value="${pmbean.tenmon}" /></td>
			</tr>
			
		</table>
		<input type="submit" value="Submit" />
		  </form>
	</div>
</div>


