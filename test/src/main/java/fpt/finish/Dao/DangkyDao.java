package fpt.finish.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.connection.OracleConnUtils;

public class DangkyDao {

	public DangkyDao() {

	}
	// Check phòng đã đăng ký theo thứ

	public String check_dangkyCN(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 6) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT2(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian as FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 0) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT3(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 1) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT4(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian as FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 2) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT5(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 3) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT6(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigian FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 4) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}

	public String check_dangkyT7(long maphong, String begintime, String endtime, String ca, Connection conn) {

		String sql = "SELECT thoigia FROM dangky WHERE maphong=? and thoigian>=? and thoigian<=? and ca=?";
		String trangthai = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, maphong);
			pstm.setString(2, begintime);
			pstm.setString(3, endtime);
			pstm.setString(4, ca);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("thu") == 5) {
					trangthai = "Đã đăng ký";
				} else {
					trangthai = "Chưa đăng ký";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trangthai;
	}
	// check phòng máy đã đăng ký

	public boolean checkPMDK(long maphong, String ca, Connection conn) throws SQLException {

		String sql = " SELECT * FROM dangky WHERE maphong = ? and ca = ? ";
		int count = 0;

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphong);
		pstm.setString(2, ca);
		ResultSet resultSet = pstm.executeQuery();

		while (resultSet.next()) {
			count++;
		}
		if (count == 1) {
			return true;
		}

		return false;
	}

	// Đăng ký phòng
	public void insert_Dangky(Dang_ky_haui pmdk, Connection conn) {

		String sql = " INSERT INTO dangky ( maphong , ma_user_haui , ca , mamon , thoigian ) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setLong(1, pmdk.getMaphong());
			pstm.setString(2, pmdk.getMa_user_haui());
			pstm.setString(3, pmdk.getCa());
			pstm.setString(4, pmdk.getMamon());
			pstm.setString(5, "2017-10-3");
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
