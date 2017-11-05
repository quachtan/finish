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
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Deletepm
 */
@WebServlet("/Deletepm")
public class Deletepm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deletepm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User_haui userhaui = MyUtils.getLoginedUser(session);
		Connection conn=MyUtils.getStoredConnection(request);
		long maphong=Long.parseLong(request.getParameter("maphong"));			
			try {
				DangkyDao.deletedk(conn,maphong);
				PhongmayDao.deletepm(conn, maphong);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect(request.getContextPath() + "/Viewphongmay");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
