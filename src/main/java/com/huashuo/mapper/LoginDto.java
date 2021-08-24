package com.huashuo.mapper;

public class LoginDto {
private static final long serialVersionUID = 683169959697444795L;
	
	private String account;
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{id = " + this.account + ", name = " + this.password + "}";
	}
}
