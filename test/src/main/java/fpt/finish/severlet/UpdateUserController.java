package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.UserDao;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;



/**
 * Servlet implementation class UpdateUserController
 */
@WebServlet("/UpdateUser")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String ma_user=request.getParameter("mauser");
		 Connection conn=MyUtils.getStoredConnection(request);
		UserDao dao=new UserDao();
		request.setAttribute("ma_user", ma_user);
		request.setAttribute("tengv",dao.check_thongtin(ma_user,conn).getTengv());
		request.setAttribute("email", dao.check_thongtin(ma_user,conn).getEmail());
		request.setAttribute("sdt", dao.check_thongtin(ma_user,conn).getSdt());
		
		RequestDispatcher rd=request.getRequestDispatcher("/UpdateUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Connection conn=MyUtils.getStoredConnection(request);
		request.setCharacterEncoding("utf-8");
		String ma_user=request.getParameter("ma_user");
		String tengv=request.getParameter("tengv");
		String email=request.getParameter("email");
		String sdt=request.getParameter("sdt");
		User_haui user=new User_haui();
		user.setMa_user(ma_user);
		user.setTengv(tengv);
		user.setEmail(email);
		user.setSdt(sdt);
		UserDao userDao=new UserDao();
		userDao.UpdateUsertheoMa(user,conn);
		response.sendRedirect("qluser");
	}

}
