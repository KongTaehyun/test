package com.mgr.netflix.client.vo;

public class ClientVO {
	
	private String email;
	private String password;
	private String membership;
	private String name;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String age;
	private String address;
	private String phone;
	private String billingDate;
	
	// 생성자
	public ClientVO() {
		
	}

	public ClientVO(String email, String password, String membership, String name, String birthYear, String birthMonth,
			String birthDay, String age, String address, String phone, String billingDate) {
		super();
		this.email = email;
		this.password = password;
		this.membership = membership;
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.billingDate = billingDate;
	}

	//getter,setter
	
	
	public String getEmail() {
		return email;
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
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	//비밀번호가 같지 않을 경우 false반환
	public boolean CheckPassword(String password) {
		if(!(this.password.equals(password))) {
			return false;
		}
		return true;
	}
}
