package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
}
