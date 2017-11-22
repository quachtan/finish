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
import fpt.finish.bean.Dang_ky_haui2;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;

@WebServlet(urlPatterns = { "/chitiet" })
public class Chitiet extends HttpServlet {
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  Connection conn = MyUtils.getStoredConnection(request);
		   String maphong = request.getParameter("maphong");
		  String errorString = null;
	        List<Dang_ky_haui2> list = null;
	        String thu2sang=null;
	        String thu2chieu=null;
	        String thu2toi=null;
	        String thu3sang=null;
	        String thu3chieu=null;
	        String thu3toi=null;
	        String thu4sang=null;
	        String thu4chieu=null;
	        String thu4toi=null;
	        String thu5sang=null;
	        String thu5chieu=null;
	        String thu5toi=null;
	        String thu6sang=null;
	        String thu6chieu=null;
	        String thu6toi=null;
	        String thu7sang=null;
	        String thu7chieu=null;
	        String thu7toi=null;
	      
	        try {
	        	//list = DBUtils.chitiet(conn, maphong);
	        	thu2sang=DBUtils.thu2sang(conn, maphong);
	        	thu2chieu=DBUtils.thu2chieu(conn, maphong);
	        	thu2toi=DBUtils.thu2toi(conn, maphong);
	        	thu3chieu=DBUtils.thu3chieu(conn, maphong);
	        	thu3sang=DBUtils.thu3sang(conn, maphong);
	        	thu3toi=DBUtils.thu3toi(conn, maphong);
	        	thu4chieu=DBUtils.thu4chieu(conn, maphong);
	        	thu4sang=DBUtils.thu4sang(conn, maphong);
	        	thu4toi=DBUtils.thu4toi(conn, maphong);
	        	thu5chieu=DBUtils.thu5chieu(conn, maphong);
	        	thu5sang=DBUtils.thu5sang(conn, maphong);
	        	thu5toi=DBUtils.thu5toi(conn, maphong);
	        	thu6chieu=DBUtils.thu6chieu(conn, maphong);
	        	thu6sang=DBUtils.thu6sang(conn, maphong);
	        	thu6toi=DBUtils.thu6toi(conn, maphong);
	        	thu7chieu=DBUtils.thu7chieu(conn, maphong);
	        	thu7sang=DBUtils.thu7sang(conn, maphong);
	        	thu7toi=DBUtils.thu7toi(conn, maphong);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Lưu thông tin vào request attribute trước khi forward sang views.
		      request.setAttribute("errorString", errorString);
		      request.setAttribute("thu2chieu", thu2chieu);
		      request.setAttribute("thu2sang", thu2sang);
		      request.setAttribute("thu2toi", thu2toi);
		      request.setAttribute("thu3chieu", thu3chieu);
		      request.setAttribute("thu3sang", thu3sang);
		      request.setAttribute("thu3toi", thu3toi);
		      request.setAttribute("thu4chieu", thu4chieu);
		      request.setAttribute("thu4sang", thu4sang);
		      request.setAttribute("thu4toi", thu4toi);
		      request.setAttribute("thu5chieu", thu5chieu);
		      request.setAttribute("thu5sang", thu5sang);
		      request.setAttribute("thu5toi", thu5toi);
		      request.setAttribute("thu6chieu", thu6chieu);
		      request.setAttribute("thu6sang", thu6sang);
		      request.setAttribute("thu6toi", thu6toi);
		      request.setAttribute("thu7chieu", thu7chieu);
		      request.setAttribute("thu7sang", thu7sang);
		      request.setAttribute("thu7toi", thu7toi);
	        // Forward sang /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/chitiet.jsp");
	        dispatcher.forward(request, response);
	    }
		
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}
