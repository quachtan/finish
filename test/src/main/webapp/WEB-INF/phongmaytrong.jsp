<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>DS phong chua dang ky</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ma phong</th>
          <th>tenphong</th>
          <th>so may</th>
        
          <th>CHI TIET</th>
         
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
             <td>${product.maphong}</td>
             <td>${product.tenphong}</td>
             <td>${product.somay}</td>
              <td><a href="chitiet?maphong=${product.maphong}">Dang ky</a></td> 
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>