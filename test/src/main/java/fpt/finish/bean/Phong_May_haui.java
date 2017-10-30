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
	public Phong_May_haui(long id, long maphong, String tenphong, long somay, String ma_user_haui, String ca,
			String mamon, Date thoigian, String trangthai) {
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
	}
	public Phong_May_haui() {
		super();
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


	

	
	
	
	
}
