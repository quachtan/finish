<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page session="false"%>



<div class="section">
	<div class="form-group">
	  <form method="POST" action="${pageContext.request.contextPath}/Sualop">
		<table id="" class="table">
			<thead>
				<tr>
					<th style="width: 100px;" colspan="1">Mã lopdl</th>
					<th style="width: 100px;" colspan="1">Tên lop on dinh</th>
				
				</tr>
			</thead>
			<tbody>
				<c:if test="${pmbean != null }">
					<tr class="odd">
						<td class="center">${pmbean.malopdl}</td>
						<td class="center">${pmbean.tenlopondinh}</td>
				
					</tr>
				</c:if>
			</tbody>
				<tr>
				<td>MLDL</td>
				<td><input name="malopdl" id="malopdl" value="${pmbean.malopdl}" /></td>
			</tr>
			<tr>
				<td>TLOD</td>
				<td><input name="tenlopondinh" id="tenlopondinh" value="${pmbean.tenlopondinh}" /></td>
			</tr>
			
		</table>
		<input type="submit" value="Submit" />
		  </form>
	</div>
</div>


