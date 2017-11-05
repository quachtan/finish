package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.LopHocDao;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Xoalop
 */
@WebServlet("/Xoalop")
public class Xoalop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xoalop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=MyUtils.getStoredConnection(request);
		String id=request.getParameter("malopdl");
			try {
				LichdayDao.deleteldlh(conn, id);
				LopHocDao.deletelh(conn, id);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect(request.getContextPath() + "/Quanlylop");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
