package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Deletelichday
 */
@WebServlet("/Deletelichday")
public class Deletelichday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletelichday() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		Connection conn=MyUtils.getStoredConnection(request);
		long id=Long.parseLong(request.getParameter("id"));			
			try {
			
				LichdayDao.deleteld(conn, id);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect(request.getContextPath() + "/QuanLylichday");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
