package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.Product;
import fpt.finish.connection.OracleConnUtils;

public class PhongmayDao {

	

	public  static ArrayList<Phong_May_haui> findAll(Connection conn) throws SQLException {
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
				long somay=resultSet.getLong("somay");
				phmay.setSomay(somay);
				dspm.add(phmay);
			}
		
		return dspm;
	}
	public static void deletepm(Connection conn, long maphong) throws SQLException {
		String sql = "delete from phongmay " + "where maphong = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphong);

		pstm.executeUpdate();
	}
	public static void updatepm(Connection conn, Phong_May_haui pmhaui) throws SQLException {
		String sql = "Update phongmay set somay =?, tenphong=? where maphong=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setLong(3, pmhaui.getMaphong());
		pstm.setString(2, pmhaui.getTenphong());
		pstm.setLong(1, pmhaui.getSomay());
		pstm.executeUpdate();
	}
	public static Phong_May_haui phong_May_haui(Connection conn, long maphong) throws SQLException {
		String sql = "Select * from phongmay a where maphong=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String tenphong = rs.getString("tenphong");
			long somay = rs.getLong("somay");
			Phong_May_haui product = new Phong_May_haui();
			product.setMaphong(maphong);
			product.setTenphong(tenphong);
			product.setSomay(somay);
			return product;
		}
		return null;
	}
	public static void insertPm(Connection conn, Phong_May_haui pm) throws SQLException {
		String sql = "Insert into phongmay(maphong,tenphong,somay) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setLong(1, pm.getMaphong());
		pstm.setString(2, pm.getTenphong());
		pstm.setLong(3, pm.getSomay());

		pstm.executeUpdate();
	}
	
}
