package fpt.finish.bean;

public class User_Role_haui {
	private long ma_role;
	private String tengv;
	private String ma_user_haui;
	private String role;

	

	public User_Role_haui(long ma_role, String tengv, String ma_user_haui, String role) {
		super();
		this.ma_role = ma_role;
		this.tengv = tengv;
		this.ma_user_haui = ma_user_haui;
		this.role = role;
	}

	public User_Role_haui() {
		super();
	}

	public long getMa_role() {
		return ma_role;
	}

	public void setMa_role(long ma_role) {
		this.ma_role = ma_role;
	}
	

	public String getTengv() {
		return tengv;
	}

	public void setTengv(String tengv) {
		this.tengv = tengv;
	}

	public String getMa_user_haui() {
		return ma_user_haui;
	}

	public void setMa_user_haui(String ma_user_haui) {
		this.ma_user_haui = ma_user_haui;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
