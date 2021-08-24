package com.huashuo.service;

public interface ShoppingCartService {
	//购物车 增
	public String input(String name,String model,String price,String quantity);
	
	//购物车 删
	public String delete(String id);
	
	//购物车 改
	public String modify(String name,String model,String price,String quantity,String id);
	
	//购物车 查
	public String query();
}
