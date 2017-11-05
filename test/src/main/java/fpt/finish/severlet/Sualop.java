package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.LopHocDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.LopHocModel;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Sualop
 */
@WebServlet("/Sualop")
public class Sualop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sualop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("malopdl");
		Connection conn = MyUtils.getStoredConnection(request);
		LopHocModel timphongmodel = null;
		try {
			timphongmodel = LopHocDao.lichdayid(conn, id);
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pmbean",timphongmodel);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/sualop.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LopHocModel pmhaui = new LopHocModel();
		Connection conn = MyUtils.getStoredConnection(request);
		String malopdl=request.getParameter("malopdl");
		String tenlopondinh=request.getParameter("tenlopondinh");
		
		pmhaui.setMalopdl(malopdl);
		pmhaui.setTenlopondinh(tenlopondinh);
	
		try {
			LopHocDao.updatelichday(conn, pmhaui);
			response.sendRedirect(request.getContextPath() + "/Quanlylop");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
