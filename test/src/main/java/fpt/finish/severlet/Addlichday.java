package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.LichdayModel;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Addlichday
 */
@WebServlet("/Addlichday")
public class Addlichday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addlichday() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Insertld.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=MyUtils.getStoredConnection(request);
		LichdayModel lichdaybean=new LichdayModel();
		String ma_user=request.getParameter("ma_user");
		String malopdl=request.getParameter("malopdl");
		String mamon=request.getParameter("mamon");
		String lichday=request.getParameter("lichday");
		
		lichdaybean.setMa_user(ma_user);
		lichdaybean.setMalopdl(malopdl);
		lichdaybean.setMamon(mamon);
		lichdaybean.setLichday(lichday);
		try {
			LichdayDao.insertld(conn, lichdaybean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/QuanLylichday");
}

}
