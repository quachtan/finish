package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.UserDao;
import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.until.MyUtils;



public class DangKyFormController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public DangKyFormController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao=new UserDao();
		HttpSession session=req.getSession();
		 Connection conn = MyUtils.getStoredConnection(req);
		String username=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");
		String magv;
		try {
			magv = userDao.check_magv(username, password,conn);
			req.setAttribute("magv", magv);
			String ca=req.getParameter("ca");
			String day=req.getParameter("day");
			req.setAttribute("ca", ca);
			req.setAttribute("day", day);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/page/DangKyForm.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Connection conn = MyUtils.getStoredConnection(req);
		DangkyDao dangkyDao=new DangkyDao();
		String ma_user=req.getParameter("ma_user_haui");
		String mp=req.getParameter("maphong");
		String ca=req.getParameter("ca");
		String malopdl=req.getParameter("malopdl");
		String mamon=req.getParameter("mamon");
		String thoigian=req.getParameter("day");
		int maphong=Integer.parseInt(mp);
		Dang_ky_haui pmdk=new Dang_ky_haui(maphong, ma_user, ca, mamon,malopdl, Date.valueOf(thoigian));
		dangkyDao.insert_Dangky(pmdk, conn);
	}
}
