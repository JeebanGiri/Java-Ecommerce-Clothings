package model;

public class RegisterUser {
	private String uname;
	private String uphone;
	private String uemail;
	private String uaddress;
	private String upassword;
	private String imageName;
	public RegisterUser(String uname, String uphone, String uemail, String uaddress, String upassword,
			String imageName) {
		this.uname = uname;
		this.uphone = uphone;
		this.uemail = uemail;
		this.uaddress = uaddress;
		this.upassword = upassword;
		this.imageName = imageName;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
