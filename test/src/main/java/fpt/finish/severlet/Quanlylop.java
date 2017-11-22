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

import fpt.finish.Dao.LopHocDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.LopHocModel;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Quanlylop
 */
@WebServlet("/Quanlylop")
public class Quanlylop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quanlylop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=MyUtils.getStoredConnection(req);
		

		
		LopHocModel phongmayhaui;
		List<LopHocModel> listthaydoi = new ArrayList<LopHocModel>();
		List<LopHocModel> timphongmodel;
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
			timphongmodel = LopHocDao.findAll1(conn);
			for (int i = 0; i < timphongmodel.size(); i++) {
				phongmayhaui = new LopHocModel();
				phongmayhaui.setMalopdl(timphongmodel.get(i).getMalopdl());
				phongmayhaui.setTenlopondinh(timphongmodel.get(i).getTenlopondinh());
				

				listthaydoi.add(phongmayhaui);

			}
			req.setAttribute("listThayDoi", listthaydoi);
				
			
				
			
			   RequestDispatcher dispatcher = req.getServletContext()
		                .getRequestDispatcher("/Quanlylop.jsp");
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
