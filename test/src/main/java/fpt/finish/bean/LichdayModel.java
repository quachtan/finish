package fpt.finish.bean;

public class LichdayModel {
	private long id;
	private String ma_user;
	private String malopdl;
	private String mamon;
	private String lichday;
	public LichdayModel( String ma_user, String malopdl, String mamon, String lichday) {
		super();
	
		this.ma_user = ma_user;
		this.malopdl = malopdl;
		this.mamon = mamon;
		this.lichday = lichday;
	}
	public LichdayModel() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMa_user() {
		return ma_user;
	}
	public void setMa_user(String ma_user) {
		this.ma_user = ma_user;
	}
	public String getMalopdl() {
		return malopdl;
	}
	public void setMalopdl(String malopdl) {
		this.malopdl = malopdl;
	}
	public String getMamon() {
		return mamon;
	}
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}
	public String getLichday() {
		return lichday;
	}
	public void setLichday(String lichday) {
		this.lichday = lichday;
	}
	
	

}
