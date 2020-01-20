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
