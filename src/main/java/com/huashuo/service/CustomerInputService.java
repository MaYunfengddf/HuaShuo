package com.huashuo.service;

public interface CustomerInputService {
	//客户信息维护 增
	public String input(String name,String quantity,String price,String model);
	//客户信息维护 删
	public String delete(String id);
	//客户信息维护 改
	public String modify(String name,String quantity,String price,String model,String id);
	//客户信息维护 查
	public String inquiry();
}
