package model;

public class User {

	private String userId;
	private String userEmail;
	private String userName;
	private String userPassword;
	private String userRole;
	
	public User(String userId, String email, String username, String password, String role) {
		super();
		this.userId = userId;
		this.userEmail = email;
		this.userName = username;
		this.userPassword = password;
		this.userRole = role;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return userEmail;
	}
	
	public void setEmail(String email) {
		this.userEmail = email;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String username) {
		this.userName = username;
	}
	
	public String getPassword() {
		return userPassword;
	}
	
	public void setPassword(String password) {
		this.userPassword = password;
	}
	
	public String getRole() {
		return userRole;
	}
	
	public void setRole(String role) {
		this.userRole = role;
	}
	
	
}
