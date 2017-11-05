package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.LichdayModel;
import fpt.finish.bean.LopHocModel;



public class LopHocDao {

	public String check_lopOD(String malopdl,Connection conn){
	
		LopHocModel lophoc=new LopHocModel();
		String sql="SELECT `tenlopondinh` FROM `lophoc` WHERE malopdl=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, malopdl);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				lophoc.setTenlopondinh(resultSet.getString("tenlopondinh"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lophoc.getTenlopondinh();
	}
	public  static ArrayList<LopHocModel> findAll1(Connection conn) throws SQLException {
		ArrayList<LopHocModel> dspm = new ArrayList<>();

		String sql = "SELECT * FROM lophoc";
		
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				LopHocModel phmay = new LopHocModel();
				String malopdl=resultSet.getString("malopdl");
				phmay.setMalopdl(malopdl);
				String tenlopondinh=resultSet.getString("tenlopondinh");
				phmay.setTenlopondinh(tenlopondinh);
				
				dspm.add(phmay);
			}
		
		return dspm;
	}
	public static void deletelh(Connection conn, String malopdl) throws SQLException {
		String sql = "delete from lophoc " + "where malopdl = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, malopdl);

		pstm.executeUpdate();
	}
	public static void insertlh(Connection conn, LopHocModel lh) throws SQLException {
		String sql = "Insert into lophoc(malopdl,tenlopondinh) values (?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, lh.getMalopdl());
		pstm.setString(2, lh.getTenlopondinh());
		pstm.executeUpdate();
	}
	public static LopHocModel lichdayid(Connection conn, String malopdl) throws SQLException {
		String sql = "Select * from lophoc a where malopdl=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, malopdl);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
		
		
			String tenlopondinh=rs.getString("tenlopondinh");
			
			LopHocModel product = new LopHocModel();
			product.setMalopdl(malopdl);
			product.setTenlopondinh(tenlopondinh);
			
			return product;
		}
		return null;
	}
	public static void updatelichday(Connection conn, LopHocModel pmhaui) throws SQLException {
		String sql = "Update lophoc set tenlopondinh = ? where malopdl = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		
		pstm.setString(1, pmhaui.getTenlopondinh());
		pstm.setString(2, pmhaui.getMalopdl());
		pstm.executeUpdate();
	}
}
