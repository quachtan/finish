package fpt.finish.severlet;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/chuyen")

public class UploadFileServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public static final String SAVE_DIRECTORY = "uploadDir";
 
   public UploadFileServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
 
       RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/uploadFile.jsp");
 
       dispatcher.forward(request, response);
   }
 
   
 
}
