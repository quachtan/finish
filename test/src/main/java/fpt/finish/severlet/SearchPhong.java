package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;

@WebServlet(urlPatterns = { "/timkiem" })
public class SearchPhong extends HttpServlet {
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  Connection conn = MyUtils.getStoredConnection(request);
		   String trangthai = request.getParameter("trangthai");
		  String errorString = null;
	        List<Phong_May_haui> list = null;
	      
	        try {
	            list = DBUtils.timkiem(conn, trangthai);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Lưu thông tin vào request attribute trước khi forward sang views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("productList", list);
	    
	        // Forward sang /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/phongmay.jsp");
	        dispatcher.forward(request, response);
	    }
		
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}
