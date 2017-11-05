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

import fpt.finish.Dao.LopHocDao;
import fpt.finish.Dao.MonhocDao;
import fpt.finish.bean.LopHocModel;
import fpt.finish.bean.Monhocmodel;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Themmon
 */
@WebServlet("/Themmon")
public class Themmon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themmon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/themmon.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=MyUtils.getStoredConnection(request);
		String mamon=request.getParameter("mamon");
		String tenmon=request.getParameter("tenmon");
		Monhocmodel pm=new Monhocmodel();
		pm.setMamon(mamon);
		pm.setTenmon(tenmon);
		try {
			MonhocDao.insertlh(conn, pm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/Quanlymon");
	}

}
