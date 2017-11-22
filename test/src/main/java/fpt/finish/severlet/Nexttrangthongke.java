package fpt.finish.severlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
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

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.EmployeeDAO;
import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.LopHocDao;
import fpt.finish.Dao.MonhocDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.Dao.UserDao;
import fpt.finish.bean.Employee;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.AddDayLib;
import fpt.finish.until.MyUtils;

/**
 * Servlet implementation class Nexttrangthongke
 */
@WebServlet("/Nexttrangthongke")
public class Nexttrangthongke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nexttrangthongke() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = MyUtils.getStoredConnection(request);
		  
			
		 HttpSession session = request.getSession();
			User_haui userhaui = MyUtils.getLoginedUser(session);
			if (userhaui == null) {
				   RequestDispatcher dispatcher = request.getServletContext()
			                .getRequestDispatcher("/WEB-INF/DangNhap.jsp");
			        dispatcher.forward(request, response);
			}
			else{
				String ngayhref=request.getParameter("ngay");

				if(ngayhref.equals("")){
   Calendar dayN = Calendar.getInstance();
	String ngay = dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
	int thu = dayN.get(Calendar.DAY_OF_WEEK);
	String dayCN = "";
	String dayT2="";
	String dayT3="";
	String dayT4="";
	String dayT5="";
	String dayT6="";
	String dayT7="";
	if (thu == 1) {
		dayN.add(Calendar.DAY_OF_YEAR,7);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
	}
	if (thu == 2) {
		dayN.add(Calendar.DAY_OF_YEAR,6);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE)+7);
	}

	if (thu == 3) {

		dayN.add(Calendar.DAY_OF_YEAR,5);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));

	}

	if (thu == 4) {

		dayN.add(Calendar.DAY_OF_YEAR,4);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
	}

	if (thu == 5) {

		dayN.add(Calendar.DAY_OF_YEAR,3);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));

	}

	if (thu == 6) {

		dayN.add(Calendar.DAY_OF_YEAR,2);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));

	}

	if (thu == 7) {

		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
		dayN.add(Calendar.DAY_OF_YEAR,1);
		dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
	
	}	
// Check phòng máy đã đăng ký theo ca
AddDayLib addDayLib=new AddDayLib();
DangkyDao dangkyDao=new DangkyDao();
PhongmayDao phongmayDao=new PhongmayDao();
UserDao userDao=new UserDao();
MonhocDao monhocDao=new MonhocDao();
LopHocDao lopHocDao=new LopHocDao();
LichdayDao lichdayDao=new LichdayDao();
ArrayList<Phong_May_haui> dspm;
try {
	dspm = phongmayDao.findAll(conn);

if(dspm!=null){
	for (Phong_May_haui pm : dspm) {
		// Ca sáng
			String ca = "Sang";
			String strs = "<tr><td>" + pm.getMaphong() + "</td><td>Sáng</td>";
			if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayCN;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
			/*	strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
				/*strs+="<br><input type='button' value='Send' onclick='sendMessage();'/></td>";*/
			}
			if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT2;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT3;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT4;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT5;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT6;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT7;
				strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strs+="'>Đổi phòng</a></td>";*/
			} else {
				strs += "<td></td>";
			}
			strs += "</tr>";
			request.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), strs);
	
		
		// Ca chiều
		
			 ca = "Chieu";
			String strc = "<tr><td>" + pm.getMaphong() + "</td><td>Chiều</td>";
			if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayCN;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT2;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT3;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT4;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT5;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT6;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			if (dangkyDao.check_dangkyT7(pm.getMaphong(),dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT7;
				strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strc+="'>Đổi phòng</a></td>";*/
			} else {
				strc += "<td></td>";
			}
			strc += "</tr>";
			request.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), strc);
		
		// Ca tối
		
			 ca = "Toi";
			String strt = "<tr><td>" + pm.getMaphong() + "</td><td>Tối</td>";
			if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayCN;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT2;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT3;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT4;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT5;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT6;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
				String day=dayT7;
				strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
				strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
				strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
				strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
				/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
				strt+="'>Đổi phòng</a></td>";*/
			} else {
				strt += "<td></td>";
			}
			strt += "</tr>";
			request.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), strt);
		}
		request.setAttribute("sophong", dspm.size());
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
request.setAttribute("soP1tuan", dangkyDao.thongketheophong(dayCN, dayT7, conn));
request.setAttribute("soGV1tuan", dangkyDao.thongketheogv(dayCN, dayT7, conn));
request.setAttribute("soL1tuan", dangkyDao.thongketheoluotdk(dayCN, dayT7, conn));
request.setAttribute("ngay", dayT2);
RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/Nexttrangthongke.jsp");
dispatcher.forward(request, response);
			}
				else{
					
					Date datengay;
					
						try {
							
							datengay = new SimpleDateFormat("yyyy-MM-dd").parse(ngayhref);
							Calendar dayN = Calendar.getInstance();
							dayN.setTime(datengay);
							//int thu=dayN.get(Calendar.DAY_OF_WEEK);
							String dayCN = "";
							String dayT2="";
							String dayT3="";
							String dayT4="";
							String dayT5="";
							String dayT6="";
							String dayT7="";
							dayN.add(Calendar.DAY_OF_YEAR,6);
							dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							dayN.add(Calendar.DAY_OF_YEAR,1);
							dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
							AddDayLib addDayLib=new AddDayLib();
							DangkyDao dangkyDao=new DangkyDao();
							PhongmayDao phongmayDao=new PhongmayDao();
							UserDao userDao=new UserDao();
							MonhocDao monhocDao=new MonhocDao();
							LopHocDao lopHocDao=new LopHocDao();
							LichdayDao lichdayDao=new LichdayDao();
							ArrayList<Phong_May_haui> dspm;
							try {
								dspm = phongmayDao.findAll(conn);

							if(dspm!=null){
								for (Phong_May_haui pm : dspm) {
									// Ca sáng
										String ca = "Sang";
										String strs = "<tr><td>" + pm.getMaphong() + "</td><td>Sáng</td>";
										if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayCN;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*	strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
											/*strs+="<br><input type='button' value='Send' onclick='sendMessage();'/></td>";*/
										}
										if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT2;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT3;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT4;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT5;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT6;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT7;
											strs+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strs += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strs+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strs+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strs+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strs+="'>Đổi phòng</a></td>";*/
										} else {
											strs += "<td></td>";
										}
										strs += "</tr>";
										request.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), strs);
								
									
									// Ca chiều
									
										 ca = "Chieu";
										String strc = "<tr><td>" + pm.getMaphong() + "</td><td>Chiều</td>";
										if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayCN;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT2;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT3;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT4;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT5;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT6;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										if (dangkyDao.check_dangkyT7(pm.getMaphong(),dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT7;
											strc+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strc += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strc+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strc+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strc+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strc+="'>Đổi phòng</a></td>";*/
										} else {
											strc += "<td></td>";
										}
										strc += "</tr>";
										request.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), strc);
									
									// Ca tối
									
										 ca = "Toi";
										String strt = "<tr><td>" + pm.getMaphong() + "</td><td>Tối</td>";
										if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayCN;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT2;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT3;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT4;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT5;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT6;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
											String day=dayT7;
											strt+= "<td>"+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
											strt += "<br>"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
											strt+="<br>"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											strt+="<br>"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
											strt+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
											/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
											strt+="'>Đổi phòng</a></td>";*/
										} else {
											strt += "<td></td>";
										}
										strt += "</tr>";
										request.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), strt);
									}
									request.setAttribute("sophong", dspm.size());
									
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							request.setAttribute("soP1tuan", dangkyDao.thongketheophong(dayCN, dayT7, conn));
							request.setAttribute("soGV1tuan", dangkyDao.thongketheogv(dayCN, dayT7, conn));
							request.setAttribute("soL1tuan", dangkyDao.thongketheoluotdk(dayCN, dayT7, conn));
							request.setAttribute("ngay", dayT2);
							RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/Nexttrangthongke.jsp");
							dispatcher.forward(request, response);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
	
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 Connection conn = MyUtils.getStoredConnection(request);
			User_haui userhaui = MyUtils.getLoginedUser(session);
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
			if (userhaui == null) {
				   RequestDispatcher dispatcher = request.getServletContext()
			                .getRequestDispatcher("/WEB-INF/DangNhap.jsp");
			        dispatcher.forward(request, response);
			}
			else{
				String ngayhref=request.getParameter("ngay");

		
		Date datengay;
		
			
			
					try {
						datengay = new SimpleDateFormat("yyyy-MM-dd").parse(ngayhref);
						Calendar dayN = Calendar.getInstance();
						dayN.setTime(datengay);
						//int thu=dayN.get(Calendar.DAY_OF_WEEK);
						String dayCN = "";
						String dayT2="";
						String dayT3="";
						String dayT4="";
						String dayT5="";
						String dayT6="";
						String dayT7="";
						dayN.add(Calendar.DAY_OF_YEAR,-1);
						dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						dayN.add(Calendar.DAY_OF_YEAR,1);
						dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + (dayN.get(Calendar.DATE));
						AddDayLib addDayLib=new AddDayLib();
						DangkyDao dangkyDao=new DangkyDao();
						PhongmayDao phongmayDao=new PhongmayDao();
						UserDao userDao=new UserDao();
						MonhocDao monhocDao=new MonhocDao();
						LopHocDao lopHocDao=new LopHocDao();
						LichdayDao lichdayDao=new LichdayDao();
						ArrayList<Phong_May_haui> dspm;
						
							dspm = phongmayDao.findAll(conn);

						if(dspm!=null){
							for (int i=0;i<dspm.size();i++) {
								Phong_May_haui pm=dspm.get(i);
								  rows=spreadsheet1.createRow(rowsang+(i*3));
							      rows.setHeight((short) 1500);
							      rowc=spreadsheet1.createRow(rowchieu+(i*3));
							      rowc.setHeight((short) 1500);
							      rowt=spreadsheet1.createRow(rowtoi+(i*3));
							      rowt.setHeight((short) 1500);
							      String ca = "Sang";
									/*String strs = "<tr><td>" + pm.getMaphong() + "</td><td>Sáng</td>";*/
									if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayCN;
										
										 String strscn= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strscn += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strscn+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strscn+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strscn+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
									/*	strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("cnsang"+i, strscn);
									} else {
									/*	String strscn = "<td></td>";*/
										/*strs+="<br><input type='button' value='Send' onclick='sendMessage();'/></td>";*/
									}
									if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT2;
										
										 String strst2= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst2 +="\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst2+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst2+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst2+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t2sang"+i, strst2);
									} else {
										/*strs += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT3;
										 
										 String strst3= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst3 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst3+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst3+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst3+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t3sang"+i, strst3);
									} else {
										/*strs += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT4;
										
										 String strst4= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst4 +="\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst4+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst4+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst4+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t4sang"+i, strst4);
									} else {
										/*strs += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT5;
										
										 String strst5= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst5 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst5+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst5+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst5+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t5sang"+i, strst5);
									} else {
										/*strs += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT6;
										
										 String strst6= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst6 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst6+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst6+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst6+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t6sang"+i, strst6);
									} else {
										/*strs += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT7;
										
										 String strst7= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strst7 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strst7+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strst7+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strst7+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strs+="'>Đổi phòng</a></td>";*/
										hm.put("t7sang"+i, strst7);
									} else {
										/*strs += "<td></td>";*/
									}
									/*strs += "</tr>";
									request.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), strs);*/

								
								// Ca chiều
								
									 ca = "Chieu";
									/*String strc = "<tr><td>" + pm.getMaphong() + "</td><td>Chiều</td>";*/
									if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayCN;
									
										String strccn= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strccn += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strccn+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strccn+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strccn+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("cnchieu"+i, strccn);
									} else {
										/*strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT2;
										
										String strct2= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct2 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct2+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct2+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct2+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strs+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t2chieu"+i, strct2);
									} else {
									/*	strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT3;
										
										String strct3= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct3 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct3+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct3+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct3+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t3chieu"+i, strct3);
									} else {
										/*strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT4;
									
										String strct4= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct4 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct4+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct4+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct4+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t4chieu"+i, strct4);
									} else {
										/*strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT5;
									
										String strct5= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct5 +="\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct5+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct5+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct5+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t5chieu"+i, strct5);
									} else {
										/*strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT6;
										
										String strct6= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct6 +="\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct6+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct6+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct6+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t6chieu"+i, strct6);
									} else {
										/*strc += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT7(pm.getMaphong(),dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT7;
										
										String strct7= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strct7 +="\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strct7+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strct7+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strct7+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strc+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strc+="'>Đổi phòng</a></td>";*/
										hm.put("t7chieu"+i, strct7);
									} else {
										/*strc += "<td></td>";*/
									}
									/*strc += "</tr>";
									request.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), strc);*/
								
								// Ca tối
								
									 ca = "Toi";
									/*String strt = "<tr><td>" + pm.getMaphong() + "</td><td>Tối</td>";*/
									if (dangkyDao.check_dangkyCN(pm.getMaphong(), dayCN, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayCN;
										
										String strtcn= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtcn += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtcn+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtcn+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtcn+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("cntoi"+i, strtcn);
									} else {
										/*strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT2(pm.getMaphong(), dayT2, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT2;
										
										String strtt2= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt2 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt2+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt2+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt2+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t2toi"+i, strtt2);
									} else {
									/*	strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT3(pm.getMaphong(), dayT3, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT3;
										
										String strtt3= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt3 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt3+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt3+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt3+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t3toi"+i, strtt3);
									} else {
										/*strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT4(pm.getMaphong(), dayT4, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT4;
										
										String strtt4= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt4 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt4+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt4+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt4+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t4toi"+i, strtt4);
									} else {
										/*strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT5(pm.getMaphong(), dayT5, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT5;
										
										String strtt5= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt5 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt5+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt5+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt5+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t5toi"+i, strtt5);
									} else {
									/*	strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT6(pm.getMaphong(), dayT6, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT6;
									
									String strtt6= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt6 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt6+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt6+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt6+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t6toi"+i, strtt6);
									} else {
										/*strt += "<td></td>";*/
									}
									if (dangkyDao.check_dangkyT7(pm.getMaphong(), dayT7, ca,conn).trim().compareTo("Đã đăng ký") == 0) {
										String day=dayT7;
										
										String strtt7= ""+dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl();
										strtt7 += "\r\n"+userDao.check_tengv(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(),conn);
										strtt7+="\r\n"+monhocDao.check_tenmon(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										strtt7+="\r\n"+lopHocDao.check_lopOD(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(),conn);
										strtt7+=";LT:"+lichdayDao.check_lichday(dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMa_user_haui(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMalopdl(), dangkyDao.thongtindangky(pm.getMaphong(), ca, day,conn).getMamon(),conn);
										/*strt+="<br><a href='doiphong?ca="+ca+"&day="+day+"&maphong="+pm.getMaphong();
										strt+="'>Đổi phòng</a></td>";*/
										hm.put("t7toi"+i, strtt7);
									} else {
										/*strt += "<td></td>";*/
									}
									/*strt += "</tr>";
									request.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), strt);*/
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
									cell.setCellValue((String) hm.get("t2sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(1, CellType.STRING);
									cell.setCellValue((String) hm.get("t2chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(1, CellType.STRING);
									cell.setCellValue((String) hm.get("t2toi"+i));
									cell.setCellStyle(style);
									///
									cell = rows.createCell(2, CellType.STRING);
									cell.setCellValue((String) hm.get("t3sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(2, CellType.STRING);
									cell.setCellValue((String) hm.get("t3chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(2, CellType.STRING);
									cell.setCellValue((String) hm.get("t3toi"+i));
									cell.setCellStyle(style);
									//
									cell = rows.createCell(3, CellType.STRING);
									cell.setCellValue((String) hm.get("t4sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(3, CellType.STRING);
									cell.setCellValue((String) hm.get("t4chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(3, CellType.STRING);
									cell.setCellValue((String) hm.get("t4toi"+i));
									cell.setCellStyle(style);
									///
									cell = rows.createCell(4, CellType.STRING);
									cell.setCellValue((String) hm.get("t5sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(4, CellType.STRING);
									cell.setCellValue((String) hm.get("t5chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(4, CellType.STRING);
									cell.setCellValue((String) hm.get("t5toi"+i));
									cell.setCellStyle(style);
									///
									cell = rows.createCell(5, CellType.STRING);
									cell.setCellValue((String) hm.get("t6sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(5, CellType.STRING);
									cell.setCellValue((String) hm.get("thu6chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(5, CellType.STRING);
									cell.setCellValue((String) hm.get("t6toi"+i));
									cell.setCellStyle(style);
									/////
									cell = rows.createCell(6, CellType.STRING);
									cell.setCellValue((String) hm.get("t7sang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(6, CellType.STRING);
									cell.setCellValue((String) hm.get("t7chieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(6, CellType.STRING);
									cell.setCellValue((String) hm.get("t7toi"+i));
									cell.setCellStyle(style);
									//
									cell = rows.createCell(7, CellType.STRING);
									cell.setCellValue((String) hm.get("cnsang"+i));
									cell.setCellStyle(style);
									cell = rowc.createCell(7, CellType.STRING);
									cell.setCellValue((String) hm.get("cnchieu"+i));
									cell.setCellStyle(style);
									cell = rowt.createCell(7, CellType.STRING);
									cell.setCellValue((String) hm.get("cntoi"+i));
									cell.setCellStyle(style);
								}
								request.setAttribute("sophong", dspm.size());
							}
							
							request.setAttribute("soP1tuan", dangkyDao.thongketheophong(dayCN, dayT7, conn));
							request.setAttribute("soGV1tuan", dangkyDao.thongketheogv(dayCN, dayT7, conn));
							request.setAttribute("soL1tuan", dangkyDao.thongketheoluotdk(dayCN, dayT7, conn));
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
					}catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
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



