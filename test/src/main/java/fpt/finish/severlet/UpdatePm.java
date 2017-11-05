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

import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class UpdatePm
 */
@WebServlet("/editpm")
public class UpdatePm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long maphong = Long.parseLong(request.getParameter("maphong"));
		Connection conn = MyUtils.getStoredConnection(request);
		Phong_May_haui timphongmodel = null;
		try {
			timphongmodel = PhongmayDao.phong_May_haui(conn, maphong);
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pmbean",timphongmodel);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/UpdatePm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Phong_May_haui pmhaui = new Phong_May_haui();
		Connection conn = MyUtils.getStoredConnection(request);
		long maphong = Long.parseLong(request.getParameter("maphong"));
		String tenphong = request.getParameter("tenphong");
		long somay = Long.parseLong(request.getParameter("somay"));
		pmhaui.setMaphong(maphong);
		pmhaui.setTenphong(tenphong);
		pmhaui.setSomay(somay);
		try {
			PhongmayDao.updatepm(conn, pmhaui);
			response.sendRedirect(request.getContextPath() + "/Viewphongmay");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
