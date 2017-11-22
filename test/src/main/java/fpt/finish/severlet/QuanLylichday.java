package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.LichdayModel;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class QuanLylichday
 */
@WebServlet("/QuanLylichday")
public class QuanLylichday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLylichday() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=MyUtils.getStoredConnection(req);
		

		
		LichdayModel lichday;
		List<LichdayModel> listthaydoi = new ArrayList<LichdayModel>();
		List<LichdayModel> lichdaymodel;
		try {
			 HttpSession session = req.getSession();
				User_haui userhaui = MyUtils.getLoginedUser(session);
				if (userhaui == null) {
					   RequestDispatcher dispatcher = req.getServletContext()
				                .getRequestDispatcher("/DangNhap.jsp");
				        dispatcher.forward(req, response);
				}
				else{
				
				if (userhaui.getMa_role()==1) {
			lichdaymodel = LichdayDao.findAll1(conn);
			for (int i = 0; i < lichdaymodel.size(); i++) {
				lichday = new LichdayModel();
				lichday.setId(lichdaymodel.get(i).getId());
				lichday.setMa_user(lichdaymodel.get(i).getMa_user());
				lichday.setMalopdl(lichdaymodel.get(i).getMalopdl());
				lichday.setMamon(lichdaymodel.get(i).getMamon());
				lichday.setLichday(lichdaymodel.get(i).getLichday());
				listthaydoi.add(lichday);

			}
			req.setAttribute("listThayDoi", listthaydoi);
				
			
				
			
			   RequestDispatcher dispatcher = req.getServletContext()
		                .getRequestDispatcher("/Quanlylichday.jsp");
		        dispatcher.forward(req, response);
				}
				else{
					RequestDispatcher dispatcher = req.getServletContext()
			                .getRequestDispatcher("/DangNhap.jsp");
			        dispatcher.forward(req, response);
				}
				}
		} catch (SQLException e) {
				
			RequestDispatcher dispatcher = req.getServletContext()
	                .getRequestDispatcher("/DangNhap.jsp");
	        dispatcher.forward(req, response);
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
