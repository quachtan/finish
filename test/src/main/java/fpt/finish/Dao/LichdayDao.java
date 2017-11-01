package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.LichdayModel;


public class LichdayDao {
	
	public ArrayList<LichdayModel> findAll(String ma_user,Connection conn)
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
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lichdayModel.getLichday();
	}
}
