package com.huashuo.beans;

public class LoginRequest {
	// 客户登录账号
	private String account;
	// 客户登录密码
	private String password;
	
	// 管理员登录账号
	private String manageAccount;
	// 管理员登录密码
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
	
}
