<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
   <a href="${pageContext.request.contextPath}/thoikhoabieu">Thoi khoa bieu</a>
   <a href="${pageContext.request.contextPath}/Abcd">Dang ky phong</a>
   <a href="${pageContext.request.contextPath}/dangkytk">Tao tai khoan</a>
   <a href="${pageContext.request.contextPath}/QuanLylichday">Quanlylichday</a>
     <a href="${pageContext.request.contextPath}/Quanlymon">Quanlymon</a>
       <a href="${pageContext.request.contextPath}/Quanlylop">Quanlylop</a>
         <a href="${pageContext.request.contextPath}/qluser">Quanlynguoidung</a>
           <a href="${pageContext.request.contextPath}/Viewphongmay">Quanlypm</a>
   |
   <%--  <a href="${pageContext.request.contextPath}/timkiem">Tim kiem</a>
   | --%>
  <%--  <a href="${pageContext.request.contextPath}/productList">Product List</a>
   |
   <a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
   | --%>
   <a href="${pageContext.request.contextPath}/login">Login</a>
   <c:if test="${loginedUser !=null}">
  
    
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>
    
</div>  