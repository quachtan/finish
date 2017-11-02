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
}
