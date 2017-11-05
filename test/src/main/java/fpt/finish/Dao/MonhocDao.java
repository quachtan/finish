package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.LopHocModel;
import fpt.finish.bean.Monhocmodel;



public class MonhocDao{

	
	public String check_tenmon(String mamon,Connection conn){
	
		
		Monhocmodel monhoc=new Monhocmodel();
		String sql="SELECT `tenmon` FROM `monhoc` WHERE `mamon`=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, mamon);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				monhoc.setTenmon(resultSet.getString("tenmon"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String tenmon=monhoc.getTenmon();
		return tenmon;
		
	}
	public String check_mamon(String tenmon,Connection conn){
		
		Monhocmodel monhoc=new Monhocmodel();
		String sql="SELECT `mamon` FROM `monhoc` WHERE `tenmon`=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, tenmon);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				monhoc.setMamon(resultSet.getString("mamon"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mamon=monhoc.getMamon();
		return mamon;
		
	}
	public  static ArrayList<Monhocmodel> findAll1(Connection conn) throws SQLException {
		ArrayList<Monhocmodel> dspm = new ArrayList<>();

		String sql = "SELECT * FROM monhoc";
		
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				Monhocmodel phmay = new Monhocmodel();
				String mamon=resultSet.getString("mamon");
				phmay.setMamon(mamon);
				String tenmon=resultSet.getString("tenmon");
				phmay.setTenmon(tenmon);
				
				dspm.add(phmay);
			}
		
		return dspm;
	}
	public static void deletelh(Connection conn, String malopdl) throws SQLException {
		String sql = "delete from monhoc " + "where mamon = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, malopdl);

		pstm.executeUpdate();
	}
	public static void insertlh(Connection conn, Monhocmodel lh) throws SQLException {
		String sql = "Insert into monhoc(mamon,tenmon) values (?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, lh.getMamon());
		pstm.setString(2, lh.getTenmon());
		pstm.executeUpdate();
	}
	public static Monhocmodel lichdayid(Connection conn, String malopdl) throws SQLException {
		String sql = "Select * from monhoc a where mamon=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, malopdl);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
		
		
			String tenmon=rs.getString("tenmon");
			
			Monhocmodel product = new Monhocmodel();
			product.setMamon(malopdl);
			product.setTenmon(tenmon);
			
			return product;
		}
		return null;
	}
	public static void updatelichday(Connection conn, Monhocmodel pmhaui) throws SQLException {
		String sql = "Update monhoc set tenmon = ? where mamon = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		
		pstm.setString(1, pmhaui.getTenmon());
		pstm.setString(2, pmhaui.getMamon());
		pstm.executeUpdate();
	}
}
