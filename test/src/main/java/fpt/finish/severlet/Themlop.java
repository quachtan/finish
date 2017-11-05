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
 * Servlet implementation class Themlop
 */
@WebServlet("/Themlop")
public class Themlop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themlop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/themlopform.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=MyUtils.getStoredConnection(request);
		String malopdl=request.getParameter("malopdl");
		String tenlopondinh=request.getParameter("tenlopondinh");
		LopHocModel pm=new LopHocModel();
		pm.setMalopdl(malopdl);
		pm.setTenlopondinh(tenlopondinh);
		try {
			LopHocDao.insertlh(conn, pm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/Quanlylop");
}

}
