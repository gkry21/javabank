package com.javabank.domains;

public class AdminBean extends UserBean {

	private String sabun;

	public AdminBean() {
		sabun = "1234";
	}
	
	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	
}
