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
import fpt.finish.until.Md5Lib;
import fpt.finish.until.MyUtils;


/**
 * Servlet implementation class AddNewUser
 */
@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/AddNewUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=MyUtils.getStoredConnection(request);
		UserDao userDao=new UserDao();
		//Md5Lib md5Lib=new Md5Lib();
		String ma_user=request.getParameter("ma_user");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(userDao.checkNewUser(username,conn)==true){
			request.setAttribute("err", "Tài khoản đã tồn tại");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/AddNewUser.jsp");
			rd.forward(request, response);
		}else{
		
		userDao.insert_tk(ma_user, username, password,conn);
		response.sendRedirect("qluser");
		}
	}

}
