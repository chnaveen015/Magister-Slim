package com.magister.slim.model;

public class UserAuth {
	private String status;
	private String role;
	

	

	public UserAuth(String status, String role) {
		super();
		this.status = status;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
//package com.magister.slim.model;
//
//public class UserAuth {
//	private String userId;
//	private String userName;
//	private String role;
//	private String token;
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
//	public UserAuth(String userId, String userName, String role, String token) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.role = role;
//		this.token = token;
//	}
//	@Override
//	public String toString() {
//		return "UserAuth [userId=" + userId + ", userName=" + userName + ", role=" + role + ", token=" + token + "]";
//	}
//	
//	public UserAuth(String status)
//	{
//		this.token=status;
//	}
//
//	
//
//	
//
//	
//}
