package fpt.finish.bean;

public class Mon_Hoc_haui {
	
	private String mamon;
	private String tenmon;
	private String malopdl;
	private String ma_user;
	
	public Mon_Hoc_haui(String mamon, String tenmon, String malopdl, String ma_user) {
		super();
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.malopdl = malopdl;
		this.ma_user = ma_user;
	}

	public Mon_Hoc_haui() {
		super();
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getTenmon() {
		return tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getMalopdl() {
		return malopdl;
	}

	public void setMalopdl(String malopdl) {
		this.malopdl = malopdl;
	}

	public String getMa_user() {
		return ma_user;
	}

	public void setMa_user(String ma_user) {
		this.ma_user = ma_user;
	}
	
	

}
