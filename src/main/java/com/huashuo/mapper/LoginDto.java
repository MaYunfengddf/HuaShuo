package com.huashuo.mapper;

public class LoginDto {
	
	private String account;
	private String password;
	
	private String manageAccount;
	private String managePassword;
	
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

	public String getManageAccount() {
		return manageAccount;
	}
	public void setManageAccount(String manageAccount) {
		this.manageAccount = manageAccount;
	}
	public String getManagePassword() {
		return managePassword;
	}
	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}
	@Override
	public String toString() {
		return "{account = " + this.account + ", password = " + this.password + 
				"manageAccount = " + this.manageAccount + ", managePassword = " + this.managePassword +"}";
	}
}
