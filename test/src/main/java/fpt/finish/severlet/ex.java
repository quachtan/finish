package fpt.finish.severlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.GroupLayout.Alignment;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.BLACK;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fpt.finish.Dao.EmployeeDAO;
import fpt.finish.bean.Employee;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.DBUtils;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class ex
 */
@WebServlet("/ex")
public class ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet1 = workbook.createSheet("Employees sheet");
      //  spreadsheet1.addMergedRegion(CellRangeAddress.valueOf("B2:D5"));
      
      
        spreadsheet1.setColumnWidth(1, 6000);
        spreadsheet1.setColumnWidth(2, 6000);
        spreadsheet1.setColumnWidth(3, 6000);
        spreadsheet1.setColumnWidth(4, 6000);
        spreadsheet1.setColumnWidth(5, 6000);
        spreadsheet1.setColumnWidth(6, 6000);
        spreadsheet1.setColumnWidth(7, 6000);
        HashMap hm = new HashMap();
        List<Employee> list = EmployeeDAO.listEmployees();
 
        int rownum = 4;
        int rowtoi=7;
        int rowsang=5;
        int rowchieu=6;
        int rowheader=0;
        int rowheader1=1;
        int rowcenter=2;
        Cell cell;
     
        Row row;
        Row rowcen;
        Row rows;
        Row rowc;
        Row rowt;
        Row rowh;
        Row rowh1;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
        HSSFCellStyle headerstyle = Header(workbook);
   
        row = spreadsheet1.createRow(rownum);
        row.setHeight((short) 800);
        rows=spreadsheet1.createRow(rowsang);
        rows.setHeight((short) 1500);
        rowc=spreadsheet1.createRow(rowchieu);
        rowc.setHeight((short) 1500);
        rowt=spreadsheet1.createRow(rowtoi);
        rowt.setHeight((short) 1500);
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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);
						         

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
							String cnsang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnsang",cnsang);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(cnn)) {
							String cnchieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cnchieu",cnchieu);

						}
						if (cn.equals("Sun") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(cnn)) {
							String cntoi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("cntoi",cntoi);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu2n)) {
							String thu2sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							// HttpSession sessions= request.getSession();
							  hm.put("thu2sang",thu2sang);

						}
						if (thu2.equals("Mon") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu2n)) {
							String thu2chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2chieu",thu2chieu);

						}

						if (thu2.equals("Mon") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu2n)) {
							String thu2toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu2toi",thu2toi);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu3n)) {
							String thu3sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3sang",thu3sang);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu3n)) {
							String thu3chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3chieu",thu3chieu);

						}
						if (thu3.equals("Tue") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu3n)) {
							String thu3toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu3toi",thu3toi);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu4n)) {
							String thu4sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4sang",thu4sang);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu4n)) {
							String thu4chieu =""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4chieu",thu4chieu);

						}
						if (thu4.equals("Wed") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu4n)) {
							String thu4toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu4toi",thu4toi);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu5n)) {
							String thu5sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5sang",thu5sang);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu5n)) {
							String thu5chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5chieu",thu5chieu);

						}
						if (thu5.equals("Thu") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu5n)) {
							String thu5toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu5toi",thu5toi);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu6n)) {
							String thu6sang = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6sang",thu6sang);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu6n)) {
							String thu6chieu = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6chieu",thu6chieu);

						}
						if (thu6.equals("Fri") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu6n)) {
							String thu6toi = ""+ user.get(i).getMalopdl()
									+ "\r\n"+user.get(i).getTenmon()+
									"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
							  hm.put("thu6toi",thu6toi);

						}
						
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Sang") && dateFormat1.equals(thu7n)) {
								String thu7sang = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								
					           hm.put("thu7sang",thu7sang);
					        

							}
							if (thu7.equals("Sat") && user.get(i).getCa().equals("Chieu") && dateFormat1.equals(thu7n)) {
								String thu7chieu = ""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7chieu",thu7chieu);
					           

							}
							 if (thu7.equals("Sat") && user.get(i).getCa().equals("Toi") && dateFormat1.equals(thu7n)) {
								String thu7toi =""+ user.get(i).getMalopdl()
										+ "\r\n"+user.get(i).getTenmon()+
										"\r\n"+user.get(i).getTengv()+""+user.get(i).getTenlopondinh()+";LT:"+user.get(i).getLichday();
								hm.put("thu7toi",thu7toi);						      
							}
					}				
				}
			
			}
			spreadsheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		    rowh=spreadsheet1.createRow(rowheader);
	        cell = rowh.createCell(0, CellType.STRING);
	        cell.setCellValue("TRƯỜNG ĐẠI HỌC CÔNG NGHIỆP HÀ NỘI");
	        cell.setCellStyle(headerstyle);
	        //
	        spreadsheet1.addMergedRegion(new CellRangeAddress(2, 2, 2, 5));
		    rowcen=spreadsheet1.createRow(rowcenter);
	        cell = rowcen.createCell(2, CellType.STRING);
	        cell.setCellValue("LỊCH THỰC HÀNH PHÒNG MÁY");
	        cell.setCellStyle(headerstyle);
	        //
	        spreadsheet1.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
		    rowh1=spreadsheet1.createRow(rowheader1);
	        cell = rowh1.createCell(1, CellType.STRING);
	        cell.setCellValue("KHOA CÔNG NGHỆ THÔNG TIN");
	        cell.setCellStyle(headerstyle);
	        ////
			cell = rows.createCell(0, CellType.STRING);
            cell.setCellValue("Sáng");
            cell.setCellStyle(style);
            cell = rowc.createCell(0, CellType.STRING);
            cell.setCellValue("Chiều");
            cell.setCellStyle(style);
            cell = rowt.createCell(0, CellType.STRING);
            cell.setCellValue("Tối");
            cell.setCellStyle(style);
            ////
			// TODO Auto-generated method stub//\
			cell = rows.createCell(1, CellType.STRING);
            cell.setCellValue((String) hm.get("thu2sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(1, CellType.STRING);
            cell.setCellValue((String) hm.get("thu2chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(1, CellType.STRING);
            cell.setCellValue((String) hm.get("thu2toi"));
            cell.setCellStyle(style);
            ///
			cell = rows.createCell(2, CellType.STRING);
            cell.setCellValue((String) hm.get("thu3sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(2, CellType.STRING);
            cell.setCellValue((String) hm.get("thu3chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(2, CellType.STRING);
            cell.setCellValue((String) hm.get("thu3toi"));
            cell.setCellStyle(style);
			//
			cell = rows.createCell(3, CellType.STRING);
            cell.setCellValue((String) hm.get("thu4sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(3, CellType.STRING);
            cell.setCellValue((String) hm.get("thu4chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(3, CellType.STRING);
            cell.setCellValue((String) hm.get("thu4toi"));
            cell.setCellStyle(style);
			///
			cell = rows.createCell(4, CellType.STRING);
            cell.setCellValue((String) hm.get("thu5sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(4, CellType.STRING);
            cell.setCellValue((String) hm.get("thu5chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(4, CellType.STRING);
            cell.setCellValue((String) hm.get("thu5toi"));
            cell.setCellStyle(style);
			///
			cell = rows.createCell(5, CellType.STRING);
            cell.setCellValue((String) hm.get("thu6sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(5, CellType.STRING);
            cell.setCellValue((String) hm.get("thu6chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(5, CellType.STRING);
            cell.setCellValue((String) hm.get("thu6toi"));
            cell.setCellStyle(style);
            /////
			cell = rows.createCell(6, CellType.STRING);
            cell.setCellValue((String) hm.get("thu7sang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(6, CellType.STRING);
            cell.setCellValue((String) hm.get("thu7chieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(6, CellType.STRING);
            cell.setCellValue((String) hm.get("thu7toi"));
            cell.setCellStyle(style);
			//
            cell = rows.createCell(7, CellType.STRING);
            cell.setCellValue((String) hm.get("cnsang"));
            cell.setCellStyle(style);
            cell = rowc.createCell(7, CellType.STRING);
            cell.setCellValue((String) hm.get("cnchieu"));
            cell.setCellStyle(style);
            cell = rowt.createCell(7, CellType.STRING);
            cell.setCellValue((String) hm.get("cntoi"));
            cell.setCellStyle(style);
            //
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("Ca");
	        cell.setCellStyle(style);
	        // EmpName
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("Thứ2");
	        cell.setCellStyle(style);
	        // Salary
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Thứ3");
	        cell.setCellStyle(style);
	        // Grade
	        cell = row.createCell(3, CellType.STRING);
	        cell.setCellValue("Thứ4");
	        cell.setCellStyle(style);
	        // Bonus
	        cell = row.createCell(4, CellType.STRING);
	        cell.setCellValue("Thứ5");
	        cell.setCellStyle(style);
	        ///
	        cell = row.createCell(5, CellType.STRING);
	        cell.setCellValue("Thứ6");
	        cell.setCellStyle(style);
	        ////
	        cell = row.createCell(6, CellType.STRING);
	        cell.setCellValue("Thứ7");
	        cell.setCellStyle(style);
	        ///
	        cell = row.createCell(7, CellType.STRING);
	        cell.setCellValue("Chủ nhật");
	        cell.setCellStyle(style);
	       
	        // Data
	      /*  for (Employee emp : list) {
	           
	        }*/
	        File rootDir = new File(LOCAL_EXCEL_ROOT_PATH);
	        rootDir.mkdirs();
	        FileOutputStream out = new FileOutputStream(new File(LOCAL_EXCEL_FILE_PATH));
	        workbook.write(out);
	        out.close();
		}
	}
	  private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
	        HSSFFont font = workbook.createFont();

	        font.setBold(true);
	       /* font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());*/
	        HSSFCellStyle style = workbook.createCellStyle();
	        style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());

	      
	        style.setFillPattern(FillPatternType.NO_FILL);
	      
	        style.setFont(font);
	        style.setWrapText(true);
	        style.setVerticalAlignment(VerticalAlignment.CENTER);
	        style.setBorderBottom(BorderStyle.THICK);
	        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

	       
	        style.setBorderLeft(BorderStyle.THICK);
	        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

	       
	        style.setBorderRight(BorderStyle.THICK);
	        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

	      
	        style.setBorderTop(BorderStyle.THICK);
	        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	       
	     
	      
	        return style;
	    }
	  private static HSSFCellStyle Header(HSSFWorkbook workbook) {
	        HSSFFont font = workbook.createFont();
	  
	        font.setBold(true);
	       /* font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());*/
	        HSSFCellStyle style = workbook.createCellStyle();
	      
	        style.setFont(font);
	        return style;
	    }
	  private static SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
	    private static String LOCAL_EXCEL_ROOT_PATH = "C:/demo";
	    private static String LOCAL_EXCEL_FILE_PATH = LOCAL_EXCEL_ROOT_PATH + "/trong" + YYYYMMDDHHMMSS.format(new Date()) + ".xls";
}
