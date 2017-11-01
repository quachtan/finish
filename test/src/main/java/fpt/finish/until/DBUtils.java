
package fpt.finish.until;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fpt.finish.bean.Dang_ky_haui;
import fpt.finish.bean.Dang_ky_haui2;
import fpt.finish.bean.Phong_May_haui;
import fpt.finish.bean.Product;
import fpt.finish.bean.UserAccount;
import fpt.finish.bean.User_Role_haui;
import fpt.finish.bean.User_haui;

public class DBUtils {

	public static User_haui findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select * from user_haui a " //
				+ " where a.username = ? and a.password= ? ";
		/*
		 * + " and a.ma_user = b.ma_user_haui " + " and c.maphong = b.maphong ";
		 */

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		List<User_haui> list1 = new ArrayList<User_haui>();
		if (rs.next()) {
			// String = rs.getString("Gender");
			String username = rs.getString("username");
			String passwords = rs.getString("password");
			String ma_user = rs.getString("ma_user");
			String tengv = rs.getString("tengv");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			/*
			 * String tenphong=rs.getString("tenphong"); // long maphong=rs.getL
			 * ong("maphong"); String ca=rs.getString("ca"); String
			 * mamon=rs.getString("mamon"); Date
			 * thoigian=rs.getDate("thoigian");
			 */

			User_haui user = new User_haui();
			user.setUserName(username);
			user.setPassword(passwords);
			user.setMa_user(ma_user);
			user.setTengv(tengv);
			user.setEmail(email);
			user.setSdt(sdt);
			// user.setMaphong(maphong);
			/*
			 * user.setCa(ca); user.setMamon(mamon); user.setThoigian(thoigian);
			 * user.setTenphong(tenphong);
			 */
			// user.setGender(gender);
			return user;
		}
		return null;
	}

	public static User_haui findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select * from user_haui a "//
				+ " where a.username = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			// String gender = rs.getString("Gender");
			User_haui user = new User_haui();
			user.setUserName(userName);
			user.setPassword(password);
			// user.setGender(gender);
			return user;
		}
		return null;
	}

	///
	public static String thu2sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Monday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu2sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu2sang;
			}
		}
		return null;
	}

	public static String thu2chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Monday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu2chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu2chieu;
			}
		}
		return null;
	}

	public static String thu2toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Monday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu2toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu2toi;
			}
		}
		return null;
	}

	public static String thu3sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Tuesday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu3sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu3sang;
			}
		}
		return null;
	}

	public static String thu3chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Tuesday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu3chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu3chieu;
			}
		}
		return null;
	}

	public static String thu3toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Tuesday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu3toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu3toi;
			}
		}
		return null;
	}

	public static String thu5sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Thursday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu5sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu5sang;
			}
		}
		return null;
	}

	public static String thu5chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Thursday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu5chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu5chieu;
			}
		}
		return null;
	}

	public static String thu5toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Thursday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu5toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu5toi;
			}
		}
		return null;
	}

	public static String thu6sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Friday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu6sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu6sang;
			}
		}
		return null;
	}

	public static String thu6chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Friday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu6chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu6chieu;
			}
		}
		return null;
	}

	public static String thu6toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Friday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu6toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu6toi;
			}
		}
		return null;
	}

	public static String thu7toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Saturday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu7toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu7toi;
			}
		}
		return null;
	}

	public static String thu7chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Saturday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu7chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu7chieu;
			}
		}
		return null;
	}

	public static String thu7sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Saturday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu7sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu7sang;
			}
		}
		return null;
	}

	public static String thu4chieu(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Wednesday") && ca.equals("chieu")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu2chieu = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:"
						+ ca + "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu2chieu;
			}
		}
		return null;
	}

	public static String thu4sang(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Wednesday") && ca.equals("sang")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu2sang = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu2sang;
			}
		}
		return null;
	}

	public static String thu4toi(Connection conn, //
			String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			if (dateFormat.equals("Wednesday") && ca.equals("toi")) {
				Dang_ky_haui2 user = new Dang_ky_haui2();
				/*
				 * user.setMaphong(maphongdb);
				 * user.setMa_user_haui(ma_user_haui); user.setCa(ca);
				 * user.setMamon(mamon);
				 * 
				 * user.setThoigian(thoigian); user.setDateformat(dateFormat);
				 */
				String thu4toi = "maphong:" + maphongdb + "<br>" + "ma_user_haui:" + ma_user_haui + "<br>" + "ca:" + ca
						+ "<br>" + "mamon:" + mamon + "<br>" + "thoigian:" + thoigian;
				return thu4toi;
			}
		}
		return null;
	}

	// chi tiet
	/*
	 * public static Dang_ky_haui findmaphong(Connection conn, String maphong)
	 * throws SQLException {
	 * 
	 * String sql =
	 * "Select * from DANGKY,phongmay where dangky.maphong = phongmay.maphong and dangky.maphong = ?"
	 * ;
	 * 
	 * PreparedStatement pstm = conn.prepareStatement(sql); pstm.setString(1,
	 * maphong); // List<Dang_ky_haui> list = new ArrayList<Dang_ky_haui>();
	 * ResultSet rs = pstm.executeQuery();
	 * 
	 * if (rs.next()) { long maphongdb=rs.getLong("maphong"); String
	 * ma_user_haui = rs.getString("ma_user_haui"); String
	 * ca=rs.getString("ca"); String mamon=rs.getString("mamon"); Date thoigian=
	 * rs.getDate("thoigian"); Dang_ky_haui user = new Dang_ky_haui();
	 * user.setMaphong(maphongdb); user.setMamon(mamon);
	 * user.setMa_user_haui(ma_user_haui); user.setCa(ca); SimpleDateFormat
	 * formatter = new SimpleDateFormat("EEEEEEEEE"); Date date = new Date();
	 * String dateFormat = formatter.format(thoigian);
	 * System.out.println("Ngày đã được định dạng : "+dateFormat);
	 * 
	 * user.setThoigian(thoigian); return user; } return null; }
	 */
	// chi tiet 2
	public static List<Dang_ky_haui2> chitiet(Connection conn, String maphong) throws SQLException {

		String sql = "Select * from dangky where maphong = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maphong);

		ResultSet rs = pstm.executeQuery();
		List<Dang_ky_haui2> list = new ArrayList<Dang_ky_haui2>();
		while (rs.next()) {
			long maphongdb = rs.getLong("maphong");
			String ma_user_haui = rs.getString("ma_user_haui");
			String ca = rs.getString("ca");
			String mamon = rs.getString("mamon");
			Date thoigian = rs.getDate("thoigian");
			// String gender = rs.getString("Gender");
			Dang_ky_haui2 user = new Dang_ky_haui2();
			user.setMaphong(maphongdb);
			user.setMa_user_haui(ma_user_haui);
			user.setCa(ca);
			user.setMamon(mamon);
			SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE");
			// Date date = new Date();
			String dateFormat = formatter.format(thoigian);
			System.out.println("Ngày đã được định dạng : " + dateFormat);
			user.setThoigian(thoigian);
			user.setDateformat(dateFormat);
			list.add(user);
		}
		return list;
	}

	public static List<Phong_May_haui> timkiem(Connection conn, String trangthai) throws SQLException {

		String sql = "Select * from PHONGMAY where trangthai = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, trangthai);

		ResultSet rs = pstm.executeQuery();
		List<Phong_May_haui> list = new ArrayList<Phong_May_haui>();
		while (rs.next()) {
			long maphong = rs.getLong("maphong");
			String tenphong = rs.getString("tenphong");
			long somay = rs.getLong("somay");

			// String gender = rs.getString("Gender");
			Phong_May_haui user = new Phong_May_haui();
			user.setMaphong(maphong);
			user.setTenphong(tenphong);
			user.setSomay(somay);

			list.add(user);
		}
		return list;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}

	// haui
	public static List<Phong_May_haui> queryphongmay(Connection conn) throws SQLException {
		String sql = "Select * from PHONGMAY where phongmay.trangthai = 'trong' ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Phong_May_haui> list = new ArrayList<Phong_May_haui>();

		while (rs.next()) {
			long maphong = rs.getLong("maphong");
			String tenphong = rs.getString("tenphong");
			long somay = rs.getLong("somay");
			// String mamon=rs.getString("mamon");
			// String ma_user_haui=rs.getString("ma_user_haui");
			Phong_May_haui pm = new Phong_May_haui();

			pm.setMaphong(maphong);
			pm.setTenphong(tenphong);
			pm.setSomay(somay);
			// pm.setMamon(mamon);
			// pm.setMa_user_haui(ma_user_haui);
			list.add(pm);

		}
		return list;

	}

	//
	public static List<Phong_May_haui> queryDangky(Connection conn) throws SQLException {
		String sql = "Select dangky.id,dangky.maphong,phongmay.tenphong,phongmay.somay,dangky.mamon,dangky.ma_user_haui,dangky.thoigian,ca "
				+ " from PHONGMAY,dangky " + "where phongmay.maphong=dangky.maphong "
				+ "group by dangky.maphong,phongmay.tenphong,phongmay.somay,dangky.mamon,dangky.ma_user_haui,dangky.thoigian,ca,dangky.id";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		List<Phong_May_haui> list1 = new ArrayList<Phong_May_haui>();
		while (rs.next()) {
			long maphong = rs.getLong("maphong");
			long id = rs.getLong("id");
			String mamon = rs.getString("mamon");
			String ma_user_haui = rs.getString("ma_user_haui");
			Date thoigian = rs.getDate("thoigian");
			String ca1 = rs.getNString("ca");
			String tenphong = rs.getString("tenphong");
			long somay = rs.getLong("somay");

			Phong_May_haui dk = new Phong_May_haui();
			dk.setMa_user_haui(ma_user_haui);
			dk.setId(id);
			dk.setCa(ca1);
			dk.setMamon(mamon);
			dk.setThoigian(thoigian);
			dk.setMaphong(maphong);
			dk.setTenphong(tenphong);
			dk.setSomay(somay);
			list1.add(dk);

		}
		return list1;

	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());

		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

	public static void huyphong(Connection conn, String id) throws SQLException {
		String sql = "delete from dangky " + "where id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		pstm.executeUpdate();
	}

	public static User_Role_haui Role(Connection conn,String ma_user_haui) throws SQLException {
		String sql = "select * from user_role where ma_user_haui = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, ma_user_haui);
		ResultSet rs = pstm.executeQuery();

		
		while (rs.next()) {
			User_Role_haui user_role=new User_Role_haui();
			long ma_role=rs.getLong("ma_role");
			String ma_user_haui1=rs.getString("ma_user_haui");
			String role=rs.getString("role");
			user_role.setMa_role(ma_role);
			user_role.setMa_user_haui(ma_user_haui1);
			user_role.setRole(role);
			return user_role;
		}
		return null;
	}
}