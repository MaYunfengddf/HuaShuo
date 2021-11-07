package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.OrderQueryDto;

public interface OrderQueryService {
	//增
	public boolean input(String accountc,String key);

	//购物车 删
	public boolean delete(String id);
	
	//购物车 改
	public boolean modify(String accountc,String key,String id);
	//查
	public List<OrderQueryDto> orderQuery();
	
	public List<OrderQueryDto> orderQueryPersonal(String accountc);
}
