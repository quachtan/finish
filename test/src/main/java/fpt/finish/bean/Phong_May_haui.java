package fpt.finish.bean;

import java.util.Date;

public class Phong_May_haui {
	private long id;
	private long maphong;
	private String tenphong;
	private long somay;
	private String ma_user_haui;
	private String ca;
	private String mamon;
	private Date thoigian;
	private String trangthai;
	private String malopdl;
	private String tenmon;
	private String lichday;
    private String	tenlopondinh;
    private String	tengv;
	public Phong_May_haui() {
		super();
	}



	public Phong_May_haui(long id, long maphong, String tenphong, long somay, String ma_user_haui, String ca,
			String mamon, Date thoigian, String trangthai, String malopdl, String tenmon, String lichday,
			String tenlopondinh, String tengv) {
		super();
		this.id = id;
		this.maphong = maphong;
		this.tenphong = tenphong;
		this.somay = somay;
		this.ma_user_haui = ma_user_haui;
		this.ca = ca;
		this.mamon = mamon;
		this.thoigian = thoigian;
		this.trangthai = trangthai;
		this.malopdl = malopdl;
		this.tenmon = tenmon;
		this.lichday = lichday;
		this.tenlopondinh = tenlopondinh;
		this.tengv = tengv;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMaphong() {
		return maphong;
	}
	public void setMaphong(long maphong) {
		this.maphong = maphong;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public long getSomay() {
		return somay;
	}
	public void setSomay(long somay) {
		this.somay = somay;
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
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getMalopdl() {
		return malopdl;
	}
	public void setMalopdl(String malopdl) {
		this.malopdl = malopdl;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public String getLichday() {
		return lichday;
	}
	public void setLichday(String lichday) {
		this.lichday = lichday;
	}
	public String getTenlopondinh() {
		return tenlopondinh;
	}
	public void setTenlopondinh(String tenlopondinh) {
		this.tenlopondinh = tenlopondinh;
	}



	public String getTengv() {
		return tengv;
	}



	public void setTengv(String tengv) {
		this.tengv = tengv;
	}

	
	
    
    
}
