package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.Phong_May_haui;
import fpt.finish.connection.OracleConnUtils;

public class PhongmayDao {

	

	public ArrayList<Phong_May_haui> findAll(Connection conn) throws SQLException {
		ArrayList<Phong_May_haui> dspm = new ArrayList<>();

		String sql = "SELECT * FROM phongmay";
		
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				Phong_May_haui phmay = new Phong_May_haui();

				long maphong = resultSet.getLong("maphong");
				phmay.setMaphong(maphong);
				String tenphong = resultSet.getString("tenphong");
				phmay.setTenphong(tenphong);
				dspm.add(phmay);
			}
		
		return dspm;
	}
}
