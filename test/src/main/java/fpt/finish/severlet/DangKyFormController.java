package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.MonhocDao;
import fpt.finish.Dao.UserDao;
import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.bean.LichdayModel;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;





public class DangKyFormController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao=new UserDao();
		HttpSession session=req.getSession();
		Connection conn=MyUtils.getStoredConnection(req);
		User_haui loginedUser = MyUtils.getLoginedUser(session);
		String username=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");
		String magv;
		
			magv=loginedUser.getMa_user();
			session.setAttribute("magv", magv);
			String ca=req.getParameter("ca");
			String day=req.getParameter("day");
			String maphong=req.getParameter("maphong");
			session.setAttribute("ca", ca);
			session.setAttribute("day", day);
			session.setAttribute("maphong", maphong);
			 MonhocDao monhocDao=new MonhocDao();
			LichdayDao lichdayDao=new LichdayDao();
			ArrayList<LichdayModel> dsmh=lichdayDao.findAll(magv,conn);
			int i=0;
			for (LichdayModel lophoc : dsmh) {
				session.setAttribute(String.valueOf(i),lophoc.getMalopdl());
				i++;
			}
			session.setAttribute("solopdl", i);
			int j=i+1;
			for (LichdayModel monhoc : dsmh) {
				session.setAttribute(String.valueOf(j), monhocDao.check_tenmon(monhoc.getMamon(),conn));
				j++;
			}
			session.setAttribute("somon", j);
		
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/DangKyForm.jsp");
		dispatcher.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Connection conn = MyUtils.getStoredConnection(req);
		DangkyDao dangkyDao=new DangkyDao();
		LichdayDao lichdaydao=new LichdayDao();
		
		String ma_user=req.getParameter("ma_user_haui");
		String mp=req.getParameter("maphong");
		String ca=req.getParameter("ca");
		String malopdl=req.getParameter("malopdl");
		String mamon=req.getParameter("mamon");
		String thoigian=req.getParameter("day");
		int maphong=Integer.parseInt(mp);
		String c_ma_user=dangkyDao.check_trungDK(thoigian, ca, conn);
		if(lichdaydao.checkLD(malopdl, mamon,conn)==false){
			req.setAttribute("errLD", "Lớp độc lập và môn không hợp lệ");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/DangKyForm.jsp");
			dispatcher.forward(req, resp);
		}else{
			if(ma_user.trim().compareTo(c_ma_user)==0){
				req.setAttribute("errTM", "Bạn đã có lịch đăng ký trong buổi này!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("/DangKyForm.jsp");
				dispatcher.forward(req, resp);
			}else{
			if(dangkyDao.checkAddDK(maphong, thoigian, ca,conn)==true){
				req.setAttribute("errDK", "Phòng đã được đăng ký. Vui lòng chọn phòng khác!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("/DangKyForm.jsp");
				dispatcher.forward(req, resp);
			}else{
				Dang_ky_haui pmdk=new Dang_ky_haui(maphong, ma_user, ca, mamon, malopdl, Date.valueOf(thoigian));
				dangkyDao.insert_Dangky(pmdk,conn);
				
				resp.sendRedirect(req.getContextPath()+"/Abcd");
			}}
	}
	}
}
