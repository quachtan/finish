package fpt.finish.bean;

import java.util.Date;

public class User_haui {

	private String ma_user;
	private String userName;
	private String password;
	private String tengv;
	private String email;
	private String sdt;
	private long maphong;
	private String ca;
	private String mamon;
	private Date thoigian;
	private String tenphong;

	public User_haui(String ma_user, String userName, String password, String tengv, String email, String sdt,
			long maphong, String ca, String mamon, Date thoigian, String tenphong) {
		super();
		this.ma_user = ma_user;
		this.userName = userName;
		this.password = password;
		this.tengv = tengv;
		this.email = email;
		this.sdt = sdt;
		this.maphong = maphong;
		this.ca = ca;
		this.mamon = mamon;
		this.thoigian = thoigian;
		this.tenphong = tenphong;
	}

	public User_haui() {
		super();
	}

	public String getMa_user() {
		return ma_user;
	}

	public void setMa_user(String ma_user) {
		this.ma_user = ma_user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTengv() {
		return tengv;
	}

	public void setTengv(String tengv) {
		this.tengv = tengv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public long getMaphong() {
		return maphong;
	}

	public void setMaphong(long maphong) {
		this.maphong = maphong;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public String getTenphong() {
		return tenphong;
	}

	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}

}
