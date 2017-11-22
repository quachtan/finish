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

import fpt.finish.bean.User_haui;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Abcd
 */
@WebServlet("/Abcd")
public class Abcd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Abcd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Connection conn = MyUtils.getStoredConnection(req);
		  
			
			 HttpSession session = req.getSession();
				User_haui userhaui = MyUtils.getLoginedUser(session);
				if (userhaui == null) {
					   RequestDispatcher dispatcher = req.getServletContext()
				                .getRequestDispatcher("/DangNhap.jsp");
				        dispatcher.forward(req, resp);
				}
				else{
		 RequestDispatcher dispatcher = req.getServletContext()
	                .getRequestDispatcher("/NewFile2.jsp");
	        dispatcher.forward(req, resp);
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
