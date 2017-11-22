package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.LichdayDao;
import fpt.finish.Dao.LopHocDao;
import fpt.finish.Dao.MonhocDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.Dao.UserDao;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.User_haui;
import fpt.finish.until.AddDayLib;
import fpt.finish.until.MyUtils;


@WebServlet(urlPatterns = { "/dangkypms" } )
public class DangKyPmController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public DangKyPmController() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   Connection conn = MyUtils.getStoredConnection(req);
		  
			
				 HttpSession session = req.getSession();
					User_haui userhaui = MyUtils.getLoginedUser(session);
					if (userhaui == null) {
						   RequestDispatcher dispatcher = req.getServletContext()
					                .getRequestDispatcher("/DangNhap.jsp");
					        dispatcher.forward(req, resp);
					}
					else{
		   Calendar dayN = Calendar.getInstance();
			String ngay = dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
			int thu = dayN.get(Calendar.DAY_OF_WEEK);
			String dayCN = "";
			String dayT2="";
			String dayT3="";
			String dayT4="";
			String dayT5="";
			String dayT6="";
			String dayT7="";
			if (thu == 1) {
				dayCN=ngay;
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
			}
			if (thu == 2) {
				dayN.add(Calendar.DAY_OF_YEAR,-1);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
			}

			if (thu == 3) {

				dayN.add(Calendar.DAY_OF_YEAR,-2);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);

			}

			if (thu == 4) {

				dayN.add(Calendar.DAY_OF_YEAR,-3);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
			}

			if (thu == 5) {

				dayN.add(Calendar.DAY_OF_YEAR,-4);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);

			}

			if (thu == 6) {

				dayN.add(Calendar.DAY_OF_YEAR,-5);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);

			}

			if (thu == 7) {

				dayN.add(Calendar.DAY_OF_YEAR,-6);
				dayCN=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT2=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT3=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT4=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT5=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT6=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
				dayN.add(Calendar.DAY_OF_YEAR,1);
				dayT7=dayN.get(Calendar.YEAR) + "-" + (dayN.get(Calendar.MONTH) + 1) + "-" + dayN.get(Calendar.DATE);
			
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
						strs += "<td><a href='dangkypmform?ca="+ca+"&day="+dayCN+"&maphong="+pm.getMaphong();
						strs+="' id='a' >Đăng ký</a> ";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT2+"&maphong="+pm.getMaphong();
						strs+= "'>Đăng ký</a></td>";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT3+"&maphong="+pm.getMaphong();
						strs += "' id='b' >Đăng ký</a></td>";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT4 +"&maphong="+pm.getMaphong();
						strs+="'>Đăng ký</a></td>";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT5 + "&maphong="+pm.getMaphong();
						strs+="'>Đăng ký</a></td>";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT6 +"&maphong="+pm.getMaphong();
						strs+="'>Đăng ký</a></td>";
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
						strs += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT7 +"&maphong="+pm.getMaphong();
						strs+="'>Đăng ký</a></td>";
					}
					strs += "</tr>";
					req.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), strs);
			
				
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
						strc += "<td><a href='dangkypmform?ca="+ca+"&day="+dayCN+"&maphong="+pm.getMaphong();
						strc+="'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT2+"&maphong="+pm.getMaphong();
						strc+= "'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT3+"&maphong="+pm.getMaphong();
						strc += "'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT4 +"&maphong="+pm.getMaphong();
						strc+="'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT5 + "&maphong="+pm.getMaphong();
						strc+="'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT6 +"&maphong="+pm.getMaphong();
						strc+="'>Đăng ký</a></td>";
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
						strc += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT7 +"&maphong="+pm.getMaphong();
						strc+="'>Đăng ký</a></td>";
					}
					strc += "</tr>";
					req.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), strc);
				
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
						strt += "<td><a href='dangkypmform?ca="+ca+"&day="+dayCN+"&maphong="+pm.getMaphong();
						strt+="'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT2+"&maphong="+pm.getMaphong();
						strt+= "'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT3+"&maphong="+pm.getMaphong();
						strt += "'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT4 +"&maphong="+pm.getMaphong();
						strt+="'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT5 + "&maphong="+pm.getMaphong();
						strt+="'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT6 +"&maphong="+pm.getMaphong();
						strt+="'>Đăng ký</a></td>";
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
						strt += "<td><a href='dangkypmform?ca=" + ca + "&day=" + dayT7 +"&maphong="+pm.getMaphong();
						strt+="'>Đăng ký</a></td>";
					}
					strt += "</tr>";
					req.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), strt);
				}
				req.setAttribute("sophong", dspm.size());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("/DangKyPhong.jsp");
		dispatcher.forward(req, resp);
					}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
