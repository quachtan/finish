package fpt.finish.bean;

import java.util.Date;

public class Dang_ky_haui {
	private int id;
	private long maphong;
	private String ma_user_haui;
	private String ca;
	private String mamon;
	private String malopdl;
	private Date thoigian;
	


	public Dang_ky_haui(long maphong, String ma_user_haui, String ca, String mamon, String malopdl,
			Date thoigian) {
		super();
		this.maphong = maphong;
		this.ma_user_haui = ma_user_haui;
		this.ca = ca;
		this.mamon = mamon;
		this.malopdl = malopdl;
		this.thoigian = thoigian;
	}

	public Dang_ky_haui() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMalopdl() {
		return malopdl;
	}

	public void setMalopdl(String malopdl) {
		this.malopdl = malopdl;
	}

	public long getMaphong() {
		return maphong;
	}

	public void setMaphong(long maphong) {
		this.maphong = maphong;
	}

	public String getMa_user_haui() {
		return ma_user_haui;
	}

	public void setMa_user_haui(String ma_user_haui) {
		this.ma_user_haui = ma_user_haui;
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

	
	
	

}
