package model;

public class User {

	private String userName;
	private String userEmail;
	private String userAddress;
	private String userContact;
	private String userImage;
	private String userPassword;

	public User( String userName, String userEmail, String userAddress, String userContact, String userImage,
			String userPassword) {
		this.userContact = userContact;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userImage = userImage;
		this.userPassword = userPassword;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
