package fpt.finish.severlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.UserAccount;
import fpt.finish.bean.User_Role_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;


@WebServlet(urlPatterns = { "/thoikhoabieu" } )
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
				 user=  DBUtils.queryDangky(conn);
		        } catch (SQLException e) {
		            e.printStackTrace();
		         
		        } 
			/*
			 * String ma_user_haui = userhaui.getMa_user(); User_Role_haui user_role
			 * = user_roledao.findByMauserhaui(ma_user_haui); if
			 * (user_role.getRole().equals("admin")) {
			 */
			for (int i = 0; i < user.size(); i++) {
				if (loginedUser.getMa_user().equals(user.get(i).getMa_user_haui())) {
					SimpleDateFormat formatter = new SimpleDateFormat("EE");
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					Date date = new Date();
					Calendar c1 = Calendar.getInstance();
					Calendar c2 = Calendar.getInstance();
					Calendar c3 = Calendar.getInstance();
					Calendar c4 = Calendar.getInstance();
					Calendar c5 = Calendar.getInstance();
					Calendar c6 = Calendar.getInstance();
					Calendar c7 = Calendar.getInstance();
					c1.setTime(date);
					c2.setTime(date);
					c3.setTime(date);

					System.out.println("Ngày ban d?u : " + formatter.format(c1.getTime()));

					String dateFormat = formatter.format(date);
					if(dateFormat.equals("Mon")){
						String thu2=dateFormat;
						String thu2n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Tue")){
						c1.roll(Calendar.DAY_OF_YEAR,-1);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						String thu3=dateFormat;
						String thu3n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu4=formatter.format(c1.getTime());
						String thu4n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu5=formatter.format(c1.getTime());
						String thu5n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6=formatter.format(c1.getTime());
						String thu6n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7=formatter.format(c1.getTime());
						String thu7n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Wed")){
						c1.roll(Calendar.DAY_OF_YEAR,-2);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						String thu4=dateFormat;
						String thu4n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR, 2);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Thu")){
						c1.roll(Calendar.DAY_OF_YEAR,-3);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3=formatter.format(c1.getTime());
						String thu3n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4=formatter.format(c1.getTime());
						String thu4n=formatter1.format(c1.getTime());
						String thu5=dateFormat;
						String thu5n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Fri")){
						c1.roll(Calendar.DAY_OF_YEAR,-4);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3=formatter.format(c1.getTime());
						String thu3n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						String thu6=dateFormat;
						String thu6n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Sat")){
						c1.roll(Calendar.DAY_OF_YEAR,-5);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						String thu7=dateFormat;
						String thu7n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Sun")){
						c1.roll(Calendar.DAY_OF_YEAR,-6);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						String cn=dateFormat;
						String cnn=formatter1.format(date);
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					/*c1.roll(Calendar.DATE, -2);
					System.out.println("Ngày ban d?u : " + formatter.format(c1.getTime()));*/
								}
			}

			// System.out.println(pmhaui);
			 RequestDispatcher dispatcher = request.getServletContext()
		                .getRequestDispatcher("/thoikhoabieu.jsp");
		        dispatcher.forward(request, response);

		}

	/*	@RequestMapping(value = "/huyphong")
		public ModelAndView deletetbk(HttpServletRequest request, HttpServletResponse response1) throws IOException {
			final String APIKey = "BAB12D0B7ABC291AB754A3EFE8DAE8";// Dang ky tai
																	// khoan tai
																	// esms.vn de
																	// lay Key
			final String SecretKey = "B1FEDE65E059C17CAB657E91BE4BB7";
			ModelAndView mv = new ModelAndView("error");
			ModelAndView mv1 = new ModelAndView("redirect:/mail");
			long id = Long.parseLong(request.getParameter("id"));
			Dang_ky_haui dkhaui = new Dang_ky_haui();
			DangKy_haui dk = dkdao.findById(id);
			long maphong = dk.getMaphong();
			String ca = dk.getCa();
			PhongMay_haui pm = pmdao.findByMaphong(maphong);

			dkdao.delete(dk);
			// mail
			response1.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response1.getWriter();
			List<User_hauiModel> user_haui = userDao.findAll();
			for (int i = 0; i < user_haui.size(); i++) {
				User_haui usermail = new User_haui();
				usermail.setEmail(user_haui.get(i).getEmail());

				String to = usermail.getEmail();
				String subject = "xin chao!";
				String message = "toi vua huy phong" + pm.getTenphong() + "ca" + ca;
				String user = "choanhbenemnhe83@gmail.com";
				String pass = "trongmaiyeuha";
				SendMail.send(to, subject, message, user, pass);
				out.println("Mail send successfully");
				////// sms

				String url = "http://rest.esms.vn/MainService.svc/json/SendMultipleMessage_V4_get?ApiKey=A1E877B486F9F4C0BD6DB1F1D65729"
						+ "&SecretKey=84B831AC326EACE2275A5DEA8BD724" + "&SmsType=4&Phone=" + user_haui.get(i).getSdt()
						+ "&Content=" + "abc";

				URL obj;
				try {
					obj = new URL(url);

					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					// you need to encode ONLY the values of the parameters

					con.setRequestMethod("GET");
					con.setRequestProperty("Accept", "application/json");

					int responseCode = con.getResponseCode();
					System.out.println("\nSending 'GET' request to URL : " + url);
					System.out.println("Response Code : " + responseCode);
					if (responseCode == 200)// Ðã g?i URL thành công, tuy nhiên b?n
											// ph?i t? ki?m tra CodeResult xem tin
											// nh?n có g?i thành công không, vì có
											// th? tài kho?n b?n không d? ti?n thì
											// s? th?t b?i
					{
						// Check CodeResult from response
					}
					// Ð?c Response
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					JSONObject json = (JSONObject) new JSONParser().parse(response.toString());
					System.out.println("CodeResult=" + json.get("CodeResult"));
					System.out.println("SMSID=" + json.get("SMSID"));
					System.out.println("ErrorMessage=" + json.get("ErrorMessage"));
					// document.getElementsByTagName("CountRegenerate").item(0).va
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// return "SUCCESS";

			}

			return mv1;
			// String errorString = null;

		}
		@RequestMapping(value="/next")
		public ModelAndView next(HttpServletRequest request) throws ParseException{
			ModelAndView mv=new ModelAndView("common/thoikhoabieu");
			ModelAndView mv1 = new ModelAndView("common/loginView");
			SimpleDateFormat formatter = new SimpleDateFormat("EE");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			HttpSession session = request.getSession();
			User_haui userhaui = MyUtils.getLoginedUser(session);
			if (userhaui == null) {
				return mv1;
			}
			List<Phong_May_haui> user = tkb.list();
			
			 * String ma_user_haui = userhaui.getMa_user(); User_Role_haui user_role
			 * = user_roledao.findByMauserhaui(ma_user_haui); if
			 * (user_role.getRole().equals("admin")) {
			 
			for (int i = 0; i < user.size(); i++) {
				if (userhaui.getMa_user().equals(user.get(i).getMa_user_haui())) {
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

			}
					}
					else{
						Date datengay = new SimpleDateFormat("dd-MM-yyyy").parse(ngay);
						Calendar c1 = Calendar.getInstance();
						Calendar c2 = Calendar.getInstance();
						//String dateFormat = formatter.format(date);
						
						c1.setTime(datengay);
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
			}

			return mv;
		}
	*/	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
				 user=  DBUtils.queryDangky(conn);
		        } catch (SQLException e) {
		            e.printStackTrace();
		         
		        } 
			/*
			 * String ma_user_haui = userhaui.getMa_user(); User_Role_haui user_role
			 * = user_roledao.findByMauserhaui(ma_user_haui); if
			 * (user_role.getRole().equals("admin")) {
			 */
			for (int i = 0; i < user.size(); i++) {
				if (loginedUser.getMa_user().equals(user.get(i).getMa_user_haui())) {
					SimpleDateFormat formatter = new SimpleDateFormat("EE");
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					Date date = new Date();
					Calendar c1 = Calendar.getInstance();
					Calendar c2 = Calendar.getInstance();
					Calendar c3 = Calendar.getInstance();
					Calendar c4 = Calendar.getInstance();
					Calendar c5 = Calendar.getInstance();
					Calendar c6 = Calendar.getInstance();
					Calendar c7 = Calendar.getInstance();
					c1.setTime(date);
					c2.setTime(date);
					c3.setTime(date);

					System.out.println("Ngày ban d?u : " + formatter.format(c1.getTime()));

					String dateFormat = formatter.format(date);
					if(dateFormat.equals("Mon")){
						String thu2=dateFormat;
						String thu2n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Tue")){
						c1.roll(Calendar.DAY_OF_YEAR,-1);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						String thu3=dateFormat;
						String thu3n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu4=formatter.format(c1.getTime());
						String thu4n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu5=formatter.format(c1.getTime());
						String thu5n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6=formatter.format(c1.getTime());
						String thu6n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7=formatter.format(c1.getTime());
						String thu7n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Wed")){
						c1.roll(Calendar.DAY_OF_YEAR,-2);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						String thu4=dateFormat;
						String thu4n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR, 2);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Thu")){
						c1.roll(Calendar.DAY_OF_YEAR,-3);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3=formatter.format(c1.getTime());
						String thu3n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4=formatter.format(c1.getTime());
						String thu4n=formatter1.format(c1.getTime());
						String thu5=dateFormat;
						String thu5n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cnn=formatter1.format(c1.getTime());
						String cn=formatter.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Fri")){
						c1.roll(Calendar.DAY_OF_YEAR,-4);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3=formatter.format(c1.getTime());
						String thu3n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						String thu6=dateFormat;
						String thu6n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Sat")){
						c1.roll(Calendar.DAY_OF_YEAR,-5);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						String thu7=dateFormat;
						String thu7n=formatter1.format(date);
						c1.roll(Calendar.DAY_OF_YEAR,2);
						String cn=formatter.format(c1.getTime());
						String cnn=formatter1.format(c1.getTime());
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					if(dateFormat.equals("Sun")){
						c1.roll(Calendar.DAY_OF_YEAR,-6);
						String thu2=formatter.format(c1.getTime());
						String thu2n=formatter1.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu3n=formatter1.format(c1.getTime());
						String thu3=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR, 1);
						String thu4n=formatter1.format(c1.getTime());
						String thu4=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu5n=formatter1.format(c1.getTime());
						String thu5=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu6n=formatter1.format(c1.getTime());
						String thu6=formatter.format(c1.getTime());
						c1.roll(Calendar.DAY_OF_YEAR,1);
						String thu7n=formatter1.format(c1.getTime());
						String thu7=formatter.format(c1.getTime());
						String cn=dateFormat;
						String cnn=formatter1.format(date);
						String dateFormat1 = formatter1.format(user.get(i).getThoigian());
						String formatter2 = formatter.format(date);
						System.out.println("Ngày dã du?c d?nh d?ng : " + dateFormat);
						if (cn.equals("Sun") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(cnn)) {
							String cnsang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnsang", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cnchieu", user.get(i));

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("cntoi", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							// HttpSession sessions= request.getSession();
							request.setAttribute("thu2sang", user.get(i));

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2chieu", user.get(i));

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu2toi", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3sang", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3chieu", user.get(i));

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu3toi", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4sang", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4chieu", user.get(i));

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu4toi", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5sang", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5chieu", user.get(i));

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu5toi", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6sang", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6chieu", user.get(i));

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu6toi", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
							String thu7sang = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7sang", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
							String thu7chieu = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7chieu", user.get(i));

						}
						if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
							String thu7toi = "mamon:" + user.get(i).getMamon() + "<br>" + "Ten phong:"
									+ user.get(i).getTenphong();
							request.setAttribute("thu7toi", user.get(i));

						}

					}
					/*c1.roll(Calendar.DATE, -2);
					System.out.println("Ngày ban d?u : " + formatter.format(c1.getTime()));*/
								}
			}

		RequestDispatcher rd = request.getRequestDispatcher("/thoikhoabieu2.jsp");
		  rd.forward(request, response);
	}
	}

}
