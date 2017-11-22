<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Login Page</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="GET" action="${pageContext.request.contextPath}/timkiem">
         <table border="0">
            <tr>
               <td>User Name</td>
               <td><input type="text" name="trangthai" value="${product.trangthai}" /> </td>
               <td> <a href="${pageContext.request.contextPath}/trong">trong</a></td>
               <td> <a href="${pageContext.request.contextPath}/dadangky">da dang ky</a></td>
            </tr>
         
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
 
      <p style="color:blue;">User Name: tom, password: tom001 or jerry/jerry001</p>
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>