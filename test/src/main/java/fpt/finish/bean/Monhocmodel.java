package fpt.finish.bean;

public class Monhocmodel {
	private String mamon;
	private String tenmon;	
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
	public Monhocmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Monhocmodel(String mamon, String tenmon) {
		super();
		this.mamon = mamon;
		this.tenmon = tenmon;
	}
	
}
