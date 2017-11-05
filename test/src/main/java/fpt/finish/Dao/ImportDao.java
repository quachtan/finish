package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fpt.finish.bean.Monhocmodel;
import fpt.finish.bean.User_haui;

public class ImportDao {
	public static void improtexcel(String urlfile, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
	
		String sql=" LOAD DATA INFILE  ?  INTO TABLE lichday "
				+ " FIELDS TERMINATED BY ?  " 
                + " (ma_user, malopdl, mamon, lichday) ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, urlfile);
		pstm.setString(2, ",");
		
	
		pstm.executeUpdate();
	}
	public static void improtexcelmon(String urlfile, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
	
		String sql=" LOAD DATA INFILE  ?  INTO TABLE monhoc "
				+ " FIELDS TERMINATED BY ?  " 
                + " (mamon, tenmon) ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, urlfile);
		pstm.setString(2, ",");
		
	
		pstm.executeUpdate();
	}
	public static void improtexcellop(String urlfile, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
	
		String sql=" LOAD DATA INFILE  ?  INTO TABLE lophoc "
				+ " FIELDS TERMINATED BY ?  " 
                + " (malopdl , tenlopondinh) ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, urlfile);
		pstm.setString(2, ",");
		
	
		pstm.executeUpdate();
	}
}
