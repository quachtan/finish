package fpt.finish.severlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.finish.Dao.DangkyDao;
import fpt.finish.Dao.PhongmayDao;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.until.AddDayLib;
import fpt.finish.until.MyUtils;



public class DangKyPmController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public DangKyPmController() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calendar dayN=Calendar.getInstance();
		   Connection conn = MyUtils.getStoredConnection(req);
		String ngay=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
		int thu=dayN.get(Calendar.DAY_OF_WEEK);
		String begintime="";
		String endtime="";
		if(thu==1)
		{
			begintime=ngay;
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
		}
		if(thu==2){
			
			dayN.add(Calendar.DATE, -1);
			begintime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
		}

		if(thu==3){
			
			dayN.add(Calendar.DATE, -2);
			begintime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
			
		}

		if(thu==4){

			dayN.add(Calendar.DATE, -3);
			begintime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+(dayN.get(Calendar.MONTH)+1)+"-"+dayN.get(Calendar.DATE);
		}

		if(thu==5){

			dayN.add(Calendar.DATE, -4);
			begintime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);
			
		}

		if(thu==6){

			dayN.add(Calendar.DATE, -5);
			begintime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);

		}

		if(thu==7){

			dayN.add(Calendar.DATE, -6);
			begintime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);
			dayN.add(Calendar.DATE, +6);
			endtime=dayN.get(Calendar.YEAR)+"-"+dayN.get(Calendar.MONTH)+1+"-"+dayN.get(Calendar.DATE);
		}
		// Check phòng máy đã đăng ký theo ca
		AddDayLib addDayLib=new AddDayLib();
		DangkyDao dangkyDao=new DangkyDao();
		PhongmayDao phongmayDao=new PhongmayDao();
		ArrayList<Phong_May_haui> dspm;
		try {
			dspm = phongmayDao.findAll(conn);
			for (Phong_May_haui pm : dspm){
			//Ca sáng
			if(dangkyDao.checkPMDK(pm.getMaphong(), "S",conn)==true){
				String ca="S";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Sáng</td>";
				if(dangkyDao.check_dangkyCN(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("scn")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"' id="+String.valueOf(pm.getMaphong()).concat("scn")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT2(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st2")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st2")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT3(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st3")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st3")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT4(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st4")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st4")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT5(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st5")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st5")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT6(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st6")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st6")+">Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT7(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("st7")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"' id="+String.valueOf(pm.getMaphong()).concat("st7")+">Đăng ký</a></td>";
				}
				str+="</tr>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), str);
			}
			else{
				String ca="S";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Sáng</td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"'>Đăng ký</a></td>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("s"), str);
			}
			// Ca chiều
			if(dangkyDao.checkPMDK(pm.getMaphong(), "C",conn)==true){
				String ca="C";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Chiều</td>";
				if(dangkyDao.check_dangkyCN(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ccn")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT2(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct2")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT3(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct3")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT4(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct4")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT5(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct5")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT6(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct6")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT7(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("ct7")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"'>Đăng ký</a></td>";
				}
				str+="</tr>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), str);
			}
			else{
				String ca="C";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Chiều</td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"'>Đăng ký</a></td>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("c"), str);
			}
			// Ca tối
			if(dangkyDao.checkPMDK(pm.getMaphong(), "T",conn)==true){
				String ca="T";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Tối</td>";
				if(dangkyDao.check_dangkyCN(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tcn")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT2(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt2")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT3(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt3")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT4(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt4")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT5(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt5")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT6(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt6")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"'>Đăng ký</a></td>";
				}
				if(dangkyDao.check_dangkyT7(pm.getMaphong(), begintime, endtime, ca,conn).trim().compareTo("Đã đăng ký")==0){
					str+="<td><a href='#' id="+String.valueOf(pm.getMaphong()).concat("tt7")+">Đã đăng ký</a></td>";
				}
				else{
					str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"'>Đăng ký</a></td>";
				}
				str+="</tr>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), str);
			}
			else{
				String ca="T";
				String str="<tr><td>"+pm.getMaphong()+"</td><td>Tối</td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+begintime+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday1(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday2(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday3(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday4(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday5(begintime)+"'>Đăng ký</a></td>";
				str+="<td><a href='dangkypmform?ca="+ca+"&day="+addDayLib.addday6(begintime)+"'>Đăng ký</a></td>";
				req.setAttribute(String.valueOf(pm.getMaphong()).concat("t"), str);
			}
			req.setAttribute("sophong", dspm.size());
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			//Ca sáng
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/page/DangKyPhong.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
