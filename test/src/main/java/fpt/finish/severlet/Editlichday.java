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
 * Servlet implementation class Editlichday
 */
@WebServlet("/Editlichday")
public class Editlichday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editlichday() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Connection conn = MyUtils.getStoredConnection(request);
		LichdayModel lichdayModel = null;
		try {
			lichdayModel = LichdayDao.lichdayid(conn, id);
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pmbean",lichdayModel);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Updateld.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LichdayModel pmhaui = new LichdayModel();
		Connection conn = MyUtils.getStoredConnection(request);
		long id = Long.parseLong(request.getParameter("id"));
		String ma_user = request.getParameter("ma_user");
		String malopdl = request.getParameter("malopdl");
		String mamon = request.getParameter("mamon");
		String lichday=request.getParameter("lichday");
		pmhaui.setId(id);
		pmhaui.setMa_user(ma_user);
		pmhaui.setMalopdl(malopdl);
		pmhaui.setMamon(mamon);
		pmhaui.setLichday(lichday);
		try {
			LichdayDao.updatelichday(conn, pmhaui);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/QuanLylichday");
	}
}
