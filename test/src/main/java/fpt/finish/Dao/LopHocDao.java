package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lophoc.getTenlopondinh();
	}
}
