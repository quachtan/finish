package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fpt.finish.bean.Phong_May_haui;


public  class thoikhaobieuDao {
		public List<Phong_May_haui> list(Connection conn) throws SQLException {
			ArrayList<Phong_May_haui> dspm = new ArrayList<>();

			 String sql = "Select dangky.id,dangky.maphong,phongmay.tenphong,phongmay.somay,dangky.mamon,dangky.ma_user_haui,dangky.thoigian,ca "
						+ " from PHONGMAY,dangky " + "where phongmay.maphong=dangky.maphong "
						+ "group by dangky.maphong,phongmay.tenphong,phongmay.somay,dangky.mamon,dangky.ma_user_haui,dangky.thoigian,ca,dangky.id";

				PreparedStatement pstm = conn.prepareStatement(sql);

				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					Phong_May_haui pmhaui = new Phong_May_haui();
			        	pmhaui.setId(rs.getLong("id"));
			        	pmhaui.setMaphong(rs.getLong("maphong"));
			        	pmhaui.setTenphong(rs.getString("tenphong"));
			        	pmhaui.setSomay(rs.getLong("somay"));
			        	pmhaui.setMamon(rs.getString("mamon"));
			        	pmhaui.setMa_user_haui(rs.getString("ma_user_haui"));
			        	pmhaui.setThoigian(rs.getDate("thoigian"));
			        	pmhaui.setCa(rs.getString("ca"));
			        	dspm.add(pmhaui);
				}
			
			return dspm;
		}

	
	/*	public void deletetkk(long id,Connection conn) throws SQLException {
			
			String query = " delete from dangky where id = ? ";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setLong(1, id);
			ResultSet rs = pstm.executeQuery();
		
				int out = pstm.executeUpdate();
			
		}*/
}
