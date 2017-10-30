package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.UserAccount;
import fpt.finish.bean.User_Role_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;

@WebServlet(urlPatterns = { "/thoikhoabieu" })
public class Thoikhoabieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Thoikhoabieu() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);

		List<Phong_May_haui> user = null;
		// Kiểm tra người dùng đã đăng nhập (login) chưa.
		User_haui loginedUser = MyUtils.getLoginedUser(session);

		// Nếu chưa đăng nhập (login).
		if (loginedUser == null) {
			// Redirect (Chuyển hướng) tới trang login.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
			try {
				String ma_user_haui = loginedUser.getMa_user();
				User_Role_haui role = DBUtils.Role(conn, ma_user_haui);
				user = DBUtils.queryDangky(conn);
				if (role.getRole().equals("admin")) {
					for (int i = 0; i < user.size(); i++) {
						if (loginedUser.getMa_user().equals(user.get(i).getMa_user_haui())) {
							SimpleDateFormat formatter = new SimpleDateFormat("EE");
							// Date date = new Date();
							String dateFormat = formatter.format(user.get(i).getThoigian());
							System.out.println("Ngày đã được định dạng : " + dateFormat);
							if (dateFormat.equals("Mon") && user.get(i).getCa().equals("sang")) {
								String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								// HttpSession sessions= request.getSession();
								request.setAttribute("thu2sang", user.get(i));

							}
							if (dateFormat.equals("Mon") && user.get(i).getCa().equals("chieu")) {
								String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu2chieu", user.get(i));

							}

							if (dateFormat.equals("Mon") && user.get(i).getCa().equals("toi")) {
								String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu2toi", user.get(i));

							}
							if (dateFormat.equals("Tue") && user.get(i).getCa().equals("sang")) {
								String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu3sang", user.get(i));

							}
							if (dateFormat.equals("Tue") && user.get(i).getCa().equals("chieu")) {
								String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu3chieu", user.get(i));

							}
							if (dateFormat.equals("Tue") && user.get(i).getCa().equals("toi")) {
								String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu3toi", user.get(i));

							}
							if (dateFormat.equals("Wed") && user.get(i).getCa().equals("sang")) {
								String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu4sang", user.get(i));

							}
							if (dateFormat.equals("Wed") && user.get(i).getCa().equals("chieu")) {
								String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu4chieu", user.get(i));

							}
							if (dateFormat.equals("Wed") && user.get(i).getCa().equals("toi")) {
								String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu4toi", user.get(i));

							}
							if (dateFormat.equals("Thu") && user.get(i).getCa().equals("sang")) {
								String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu5sang", user.get(i));

							}
							if (dateFormat.equals("Thu") && user.get(i).getCa().equals("chieu")) {
								String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu5chieu", user.get(i));

							}
							if (dateFormat.equals("Thu") && user.get(i).getCa().equals("toi")) {
								String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu5toi", user.get(i));

							}
							if (dateFormat.equals("Fri") && user.get(i).getCa().equals("sang")) {
								String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu6sang", user.get(i));

							}
							if (dateFormat.equals("Fri") && user.get(i).getCa().equals("chieu")) {
								String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu6chieu", user.get(i));

							}
							if (dateFormat.equals("Fri") && user.get(i).getCa().equals("toi")) {
								String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu6toi", user.get(i));

							}
							if (dateFormat.equals("Sat") && user.get(i).getCa().equals("sang")) {
								String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu7sang", user.get(i));

							}
							if (dateFormat.equals("Sat") && user.get(i).getCa().equals("chieu")) {
								String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu7chieu", user.get(i));

							}
							if (dateFormat.equals("Sat") && user.get(i).getCa().equals("toi")) {
								String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
										+ user.get(i).getTenphong();
								request.setAttribute("thu7toi", user.get(i));

							}

						}
					}
					RequestDispatcher dispatcher //
							= this.getServletContext().getRequestDispatcher("/WEB-INF/thoikhoabieu.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher //
							= this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp");
					dispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
