package com.javabank.domains;

public class CustomerBean extends UserBean{

	private String credit;
	
	public CustomerBean() {
		credit ="1등급";
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	
	
}
