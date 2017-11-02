package fpt.finish.severlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fpt.finish.Dao.ImportDao;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;
 
@WebServlet("/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
       maxFileSize = 1024 * 1024 * 10, // 10MB
       maxRequestSize = 1024 * 1024 * 50) // 50MB
public class Importexcel extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public static final String SAVE_DIRECTORY = "uploadDir";
 
   public Importexcel() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
 
       RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/uploadFile.jsp");
 
       dispatcher.forward(request, response);
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       
           String description = request.getParameter("description");
           System.out.println("Description: " + description);
 
           Connection conn = MyUtils.getStoredConnection(request);
           
           
         
    
           String errorString = null;
          
           try {
               ImportDao.improtexcel(description, conn);;
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           } 
            
           // Nếu có lỗi, forward (chuyển tiếp) sang trang thông báo lỗi.
           if (errorString != null) {
               // Lưu thông tin vào request attribute trước khi forward sang views.
               request.setAttribute("errorString", errorString);
               // 
               RequestDispatcher dispatcher = request.getServletContext()
                       .getRequestDispatcher("/WEB-INF/deleteProductErrorView.jsp");
               dispatcher.forward(request, response);
           }
           // Nếu mọi thứ tốt đẹp.
           // Redirect (chuyển hướng) sang trang danh sách sản phẩm.
           else {
        	   RequestDispatcher dispatcher = request.getServletContext()
                       .getRequestDispatcher("/WEB-INF/deleteProductErrorView.jsp");
               dispatcher.forward(request, response);
           }
           
   }
  
}