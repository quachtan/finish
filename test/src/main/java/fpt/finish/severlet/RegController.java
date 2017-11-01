package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.UserDao;
import fpt.finish.bean.User_haui;
import fpt.finish.until.Md5Lib;
import fpt.finish.until.MyUtils;



public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("err", "");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/page/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		   Connection conn = MyUtils.getStoredConnection(req);
		String err = "";
		if (req.getParameter("ma_user").trim().length() < 4 || req.getParameter("ma_user").trim().length() > 12) {
			err += "Mã giảng viên từ 4-12 ký tự <br>";

		}
		if (req.getParameter("username").trim().length() < 6 || req.getParameter("username").trim().length() > 24) {
			err += "Tên tài khoản từ 6-24 ký tự <br>";

		}
		if (req.getParameter("password").trim().length() < 4 || req.getParameter("password").trim().length() > 12) {
			err += "Mật khẩu từ 6-24 ký tự <br>";

		}
		if (req.getParameter("tengv").trim().equals("")) {
			err += "Tên giảng viên không được để trống <br>";
		}
		if (req.getParameter("email").trim().equals("")) {
			err += "Email không được để trống <br>";

		}
		if (req.getParameter("sdt").trim().equals("")) {
			err += "Số điện thoại không được để trống <br>";
		}
		if(!req.getParameter("re-password").equals(req.getParameter("password"))){
			err+="Mật khẩu nhập lại không khớp";
		}else{
			err="";
		}
		if(err.equals(""))
		{
			Md5Lib md5 = new Md5Lib();
			User_haui user_Haui = new User_haui();
			user_Haui.setMa_user(req.getParameter("ma_user"));
			user_Haui.setUserName(req.getParameter("username"));
			user_Haui.setPassword(md5.md5(req.getParameter("password")));
			user_Haui.setTengv(req.getParameter("tengv"));
			user_Haui.setEmail(req.getParameter("email"));
			user_Haui.setSdt(req.getParameter("sdt"));
			//user_Haui.setMa_role(1);
			UserDao impl = new UserDao();
			impl.insert_User(user_Haui,conn);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/page/ok.jsp");
			dispatcher.forward(req, resp);
			
		}
		else{
			req.setAttribute("err", err);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/page/register.jsp");
			dispatcher.forward(req, resp);
	}
}
}