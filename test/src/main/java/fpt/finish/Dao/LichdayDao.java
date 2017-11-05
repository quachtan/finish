package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.LichdayModel;
import fpt.finish.bean.Phong_May_haui;


public class LichdayDao {
	
	public static ArrayList<LichdayModel> findAll(String ma_user,Connection conn)
	{
	
		String sql="SELECT * FROM `lichday` WHERE `ma_user`=?";
		ArrayList<LichdayModel> dsmh=new ArrayList<>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, ma_user);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				LichdayModel mh=new LichdayModel(resultSet.getString("ma_user"), resultSet.getString("malopdl"), resultSet.getString("mamon"), resultSet.getString("lichday"));
				
				dsmh.add(mh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsmh;
	}
	public String check_lichday(String ma_user,String malopdl,String mamon,Connection conn){
		
		LichdayModel lichdayModel=new LichdayModel();
		String sql="SELECT `lichday` FROM `lichday` WHERE ma_user=? and malopdl=? and mamon=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ma_user);
			pstm.setString(2, malopdl);
			pstm.setString(3, mamon);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				lichdayModel.setLichday(resultSet.getString("lichday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lichdayModel.getLichday();
	}
	public  static ArrayList<LichdayModel> findAll1(Connection conn) throws SQLException {
		ArrayList<LichdayModel> dspm = new ArrayList<>();

		String sql = "SELECT * FROM lichday";
		
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				LichdayModel phmay = new LichdayModel();
				long id=resultSet.getLong("id");
				phmay.setId(id);
				String ma_user = resultSet.getString("ma_user");
				phmay.setMa_user(ma_user);
				String malopdl = resultSet.getString("malopdl");
				phmay.setMalopdl(malopdl);
				String mamon=resultSet.getString("mamon");
				phmay.setMamon(mamon);
				String lichday=resultSet.getString("lichday");
				phmay.setLichday(lichday);
				dspm.add(phmay);
			}
		
		return dspm;
	}
	public static void deleteld(Connection conn, long id) throws SQLException {
		String sql = "delete from lichday " + "where id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, id);

		pstm.executeUpdate();
	}
	public static void deleteldlh(Connection conn, String id) throws SQLException {
		String sql = "delete from lichday " + "where malopdl = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		pstm.executeUpdate();
	}
	public static void deleteldmh(Connection conn, String id) throws SQLException {
		String sql = "delete from lichday " + "where mamon = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		pstm.executeUpdate();
	}
	public static void insertld(Connection conn, LichdayModel ld) throws SQLException {
		String sql = "Insert into lichday(ma_user,malopdl,mamon,lichday) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, ld.getMa_user());
		pstm.setString(2, ld.getMalopdl());
		pstm.setString(3, ld.getMamon());
		pstm.setString(4, ld.getLichday());
		pstm.executeUpdate();
	}
	public static LichdayModel lichdayid(Connection conn, long id) throws SQLException {
		String sql = "Select * from lichday a where id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
		
			String ma_user=rs.getString("ma_user");
			String malopdl=rs.getString("malopdl");
			String mamon=rs.getString("mamon");
			String lichday=rs.getString("lichday");
			LichdayModel product = new LichdayModel();
			product.setId(id);
			product.setMa_user(ma_user);
			product.setMalopdl(malopdl);
			product.setMamon(mamon);
			product.setLichday(lichday);
			return product;
		}
		return null;
	}
	public static void updatelichday(Connection conn, LichdayModel pmhaui) throws SQLException {
		String sql = "Update lichday set ma_user = ? , malopdl = ? , mamon = ? , lichday = ? where id = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, pmhaui.getMa_user());
		pstm.setString(2, pmhaui.getMalopdl());
		pstm.setString(3, pmhaui.getMamon());
		pstm.setString(4, pmhaui.getLichday());
		pstm.setLong(5, pmhaui.getId());
		pstm.executeUpdate();
	}
}
