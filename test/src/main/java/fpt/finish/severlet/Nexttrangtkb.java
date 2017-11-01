package fpt.finish.severlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;
@WebServlet(urlPatterns = { "/next" } )
public class Nexttrangtkb extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Nexttrangtkb() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("EE");
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
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
		} else { try {
			 user=  DBUtils.queryDangky(conn);
        } catch (SQLException e) {
            e.printStackTrace();
         
        } 
		
		
		 
		for (int i = 0; i < user.size(); i++) {
			if (loginedUser.getMa_user().equals(user.get(i).getMa_user_haui())) {
				String ngay=request.getParameter("ngay");

				if(ngay.equals("")){
		Date date = new Date();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		String dateFormat = formatter.format(date);
		
		c1.setTime(date);
	//	c1.roll(Calendar.DAY_OF_YEAR,7);
		//c2.setTime(c1.getTime());
	//	String thu2=formatter1.format(c1.getTime());
		if(dateFormat.equals("Mon")){
			c1.roll(Calendar.DAY_OF_YEAR,7);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
		if(dateFormat.equals("Tue")){
			c1.roll(Calendar.DAY_OF_YEAR,6);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}if(dateFormat.equals("Wed")){
			c1.roll(Calendar.DAY_OF_YEAR,5);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
		if(dateFormat.equals("Thu")){
			c1.roll(Calendar.DAY_OF_YEAR,4);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
		if(dateFormat.equals("Fri")){
			c1.roll(Calendar.DAY_OF_YEAR,3);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
		if(dateFormat.equals("Sat")){
			c1.roll(Calendar.DAY_OF_YEAR,2);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
		if(dateFormat.equals("Sun")){
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu2=formatter.format(c1.getTime());
			String thu2check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu3=formatter.format(c1.getTime());
			String thu3check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu4=formatter.format(c1.getTime());
			String thu4check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR, 1);
			String thu5=formatter.format(c1.getTime());
			String thu5check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu6=formatter.format(c1.getTime());
			String thu6check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String thu7=formatter.format(c1.getTime());
			String thu7check=formatter1.format(c1.getTime());
			c1.roll(Calendar.DAY_OF_YEAR,1);
			String cn=formatter.format(c1.getTime());
			String cncheck=formatter1.format(c1.getTime());
			String dateFormat1 = formatter1.format(user.get(i).getThoigian());
			String formatter2 = formatter.format(date);
			System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
			if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
				String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				// HttpSession sessions= request.getSession();
				request.setAttribute("thu2sang", user.get(i));

			}
			if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
				String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2chieu", user.get(i));

			}

			if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
				String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu2toi", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
				String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3sang", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
				String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3chieu", user.get(i));

			}
			if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
				String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu3toi", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
				String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4sang", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
				String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4chieu", user.get(i));

			}
			if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
				String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu4toi", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
				String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5sang", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
				String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5chieu", user.get(i));

			}
			if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
				String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu5toi", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
				String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6sang", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
				String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6chieu", user.get(i));

			}
			if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
				String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu6toi", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
				String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7sang", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
				String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7chieu", user.get(i));

			}
			if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
				String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
						+ user.get(i).getTenphong();
				request.setAttribute("thu7toi", user.get(i));

			}
			request.setAttribute("ngay",thu2check);

		}
				}
				else{
					Date datengay;
					try {
						datengay = new SimpleDateFormat("dd-MM-yyyy").parse(ngay);
					
					Calendar c1 = Calendar.getInstance();
					Calendar c2 = Calendar.getInstance();
					//String dateFormat = formatter.format(date);
					
					c1.setTime(datengay);
					c1.roll(Calendar.DAY_OF_YEAR,7);
					String thu2=formatter.format(c1.getTime());
					String thu2check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR,1);
					String thu3=formatter.format(c1.getTime());
					String thu3check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR,1);
					String thu4=formatter.format(c1.getTime());
					String thu4check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR, 1);
					String thu5=formatter.format(c1.getTime());
					String thu5check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR,1);
					String thu6=formatter.format(c1.getTime());
					String thu6check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR,1);
					String thu7=formatter.format(c1.getTime());
					String thu7check=formatter1.format(c1.getTime());
					c1.roll(Calendar.DAY_OF_YEAR,1);
					String cn=formatter.format(c1.getTime());
					String cncheck=formatter1.format(c1.getTime());
					String dateFormat1 = formatter1.format(user.get(i).getThoigian());
					
					if (thu2.equals("Mon") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu2check)) {
						String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						// HttpSession sessions= request.getSession();
						request.setAttribute("thu2sang", user.get(i));

					}
					if (thu2.equals("Mon") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu2check)) {
						String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu2chieu", user.get(i));

					}

					if (thu2.equals("Mon") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu2check)) {
						String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu2toi", user.get(i));

					}
					if (thu3.equals("Tue") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu3check)) {
						String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu3sang", user.get(i));

					}
					if (thu3.equals("Tue") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu3check)) {
						String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu3chieu", user.get(i));

					}
					if (thu3.equals("Tue") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu3check)) {
						String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu3toi", user.get(i));

					}
					if (thu4.equals("Wed") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu4check)) {
						String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu4sang", user.get(i));

					}
					if (thu4.equals("Wed") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu4check)) {
						String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu4chieu", user.get(i));

					}
					if (thu4.equals("Wed") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu4check)) {
						String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu4toi", user.get(i));

					}
					if (thu5.equals("Thu") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu5check)) {
						String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu5sang", user.get(i));

					}
					if (thu5.equals("Thu") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu5check)) {
						String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu5chieu", user.get(i));

					}
					if (thu5.equals("Thu") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu5check)) {
						String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu5toi", user.get(i));

					}
					if (thu6.equals("Fri") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu6check)) {
						String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu6sang", user.get(i));

					}
					if (thu6.equals("Fri") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu6check)) {
						String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu6chieu", user.get(i));

					}
					if (thu6.equals("Fri") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu6check)) {
						String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu6toi", user.get(i));

					}
					if (thu7.equals("Sat") && user.get(i).getCa().equals("sang") && dateFormat1.equals(thu7check)) {
						String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu7sang", user.get(i));

					}
					if (thu7.equals("Sat") && user.get(i).getCa().equals("chieu") && dateFormat1.equals(thu7check)) {
						String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu7chieu", user.get(i));

					}
					if (thu7.equals("Sat") && user.get(i).getCa().equals("toi") && dateFormat1.equals(thu7check)) {
						String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
								+ user.get(i).getTenphong();
						request.setAttribute("thu7toi", user.get(i));

					}
					request.setAttribute("ngay",thu2check);

					 File temp = File.createTempFile("i-am-a-temp-file", ".tmp" );
					 
			    	    String absolutePath = temp.getAbsolutePath();
			    	    System.out.println("File path : " + absolutePath);
			 
			    	    String filePath = absolutePath.
			    	    	     substring(0,absolutePath.lastIndexOf(File.separator));
			 
			    	    System.out.println("File path : " + filePath);
			 
			    	

					
				}catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		}
		}
		 RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/thoikhoabieu.jsp");
	        dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
