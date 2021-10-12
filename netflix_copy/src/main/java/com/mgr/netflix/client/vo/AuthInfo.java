package com.mgr.netflix.client.vo;

public class AuthInfo {
	//세션에 등록할 클래스로 추후에 추가해줘야한다.
	private String email;
	private String membership;
	private String password;
	private String name;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	
	public AuthInfo() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public AuthInfo(String email, String membership, String password, String name, String birthYear, String birthMonth,
			String birthDay) {
		super();
		this.email = email;
		this.membership = membership;
		this.password = password;
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBirthYear() {
		return birthYear;
	}



	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}



	public String getBirthMonth() {
		return birthMonth;
	}



	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}



	public String getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
