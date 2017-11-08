package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.UserDao;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;



@WebServlet("/qluser")
public class QuanLyUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
			User_haui userhaui = MyUtils.getLoginedUser(session);
			if (userhaui == null) {
				   RequestDispatcher dispatcher = request.getServletContext()
			                .getRequestDispatcher("/WEB-INF/DangNhap.jsp");
			        dispatcher.forward(request, response);
			}
			else{
			
			if (userhaui.getMa_role()==1) {
		UserDao userDao=new UserDao();
		Connection conn=MyUtils.getStoredConnection(request);
		ArrayList<User_haui> list=userDao.findAll(conn);
		request.setAttribute("listUser", list);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/QuanLyNguoiDung.jsp");
		rd.forward(request, response);
			}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
