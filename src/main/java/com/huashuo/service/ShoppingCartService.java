package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.ShoppingCartDto;

public interface ShoppingCartService {
	//购物车 增
	public boolean input(String accountb,String key);
	
	//购物车 删
	public boolean delete(String id);
	
	//购物车 改
	public boolean modify(String accountb,String key,String id);
	
	//购物车 查
	public List<ShoppingCartDto> query(String accountb);
}
