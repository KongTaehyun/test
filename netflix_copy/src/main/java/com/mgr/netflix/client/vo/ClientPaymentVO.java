package com.mgr.netflix.client.vo;

public class ClientPaymentVO {
	private String email;
	private String cardNum;
	private String expireDate;
	private String name;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private boolean agree;
	
	//생성자
	public ClientPaymentVO() {
		//디폴트 생성자가 있어야 스프링 form태그 사용가능
	}
	
	public ClientPaymentVO(String email, String cardNum, String expireDate, String name, String birthYear,
			String birthMonth, String birthDay) {
		super();
		this.email = email;
		this.cardNum = cardNum;
		this.expireDate = expireDate;
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}
	//getter,setter

	public String getEmail() {
		return email;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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

	@Override
	public String toString() {
		return "ClientPaymentVO [email=" + email + ", cardNum=" + cardNum + ", expireDate=" + expireDate + ", name="
				+ name + ", birthYear=" + birthYear + ", birthMonth=" + birthMonth + ", birthDay=" + birthDay
				+ ", agree=" + agree + "]";
	}


	
	
	
	
}
