package com.mgr.netflix.client.vo;

public class ClientLoginVO {
	
	private String email;
	private String password;
	private String membership;
	private boolean rememberemail;
	
	//constructor
	public ClientLoginVO() {
		
	}
	
	public ClientLoginVO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	//getter setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}

	public boolean getRememberemail() {
		return rememberemail;
	}

	public void setRememberemail(boolean rememberemail) {
		this.rememberemail = rememberemail;
	}
	
	
	
	
	
}
