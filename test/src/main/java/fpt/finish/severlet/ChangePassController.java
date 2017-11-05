package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.UserDao;
import fpt.finish.until.Md5Lib;
import fpt.finish.until.MyUtils;



/**
 * Servlet implementation class ChangePassController
 */
@WebServlet("/ChangePass")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassController() {
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
		HttpSession session = request.getSession();
		session.setAttribute("username", dao.check_username(ma_user,conn));
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/ChangePass.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		Connection conn=MyUtils.getStoredConnection(request);
		Md5Lib md5Lib=new Md5Lib();
		String oldPass=md5Lib.md5(request.getParameter("oldpassword"));
		String newPass=md5Lib.md5(request.getParameter("newpassword"));
		UserDao dao=new UserDao();
		
		if(dao.checkLogin(username, oldPass,conn)==false){
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/ChangePass.jsp");
			rd.forward(request, response);
		}else{
			dao.ChangPass(username, newPass,conn);
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			response.sendRedirect("qluser");
		}
		
	}

}
