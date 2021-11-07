package com.huashuo.service;

public interface LoginService {
	//客户登录
	public boolean loginSystem(String account,String password);
	//管理员登录
	public boolean manageSystem(String manageAccount,String managePassword);
}
