package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.connection.OracleConnUtils;

public class DangkyDao {

	public DangkyDao() {

	}
	// Check phòng đã đăng ký theo thứ

	public String check_dangkyCN(long maphong,String thoigian,String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

		
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==6)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	public String check_dangkyT2(long maphong,String thoigian,String ca,Connection conn)
	{
	
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==0)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	public String check_dangkyT3(long maphong,String thoigian, String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==1)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	public String check_dangkyT4(long maphong,String thoigian,String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==2)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	public String check_dangkyT5(long maphong,String thoigian,String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==3)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	public String check_dangkyT6(long maphong,String thoigian,String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==4)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trangthai;
		}
	public String check_dangkyT7(long maphong,String thoigian,String ca,Connection conn)
	{
		
		String sql="SELECT WEEKDAY(thoigian) as 'thu' FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		String trangthai="";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, thoigian);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					if(resultSet.getInt("thu")==5)
					{
						trangthai="Đã đăng ký";
					}
					else{
						trangthai="Chưa đăng ký";
					}
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trangthai;
		}
	// check phòng máy đã đăng ký

	public boolean checkPMDK(long maphong, String ca, Connection conn) throws SQLException {

		String sql = " SELECT * FROM dangky WHERE maphong = ? and ca = ? ";
		int count = 0;

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphong);
		pstm.setString(2, ca);
		ResultSet resultSet = pstm.executeQuery();

		while (resultSet.next()) {
			count++;
		}
		if (count == 1) {
			return true;
		}

		return false;
	}

	// Đăng ký phòng
	public void insert_Dangky(Dang_ky_haui pmdk, Connection conn) {

		String sql = " INSERT INTO dangky ( maphong , ma_user_haui , ca , mamon ,malopdl, thoigian ) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, pmdk.getMaphong());
			pstm.setString(2, pmdk.getMa_user_haui());
			pstm.setString(3, pmdk.getCa());
			pstm.setString(4, pmdk.getMamon());
			pstm.setString(5, pmdk.getMalopdl());
			pstm.setDate(6, (java.sql.Date) pmdk.getThoigian());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	public Dang_ky_haui thongtindangky(long maphong, String ca, String ngay,Connection conn){
	
		Dang_ky_haui ttdk=new Dang_ky_haui();
		String sql="SELECT * FROM `dangky` WHERE maphong=? and thoigian=? and ca=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, maphong);
			pstm.setString(2, ngay);
			pstm.setString(3, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
					ttdk=new Dang_ky_haui(resultSet.getInt("maphong"), resultSet.getString("ma_user_haui"), resultSet.getString("ca"), resultSet.getString("mamon"),resultSet.getString("malopdl"), resultSet.getDate("thoigian"));
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ttdk;
	}
	public static void deletedk(Connection conn, long maphong) throws SQLException {
		String sql = "delete from dangky " + "where maphong = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphong);

		pstm.executeUpdate();
	}
	
}
