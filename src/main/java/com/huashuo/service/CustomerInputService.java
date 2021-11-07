package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.CustomerInputDto;

public interface CustomerInputService {
	//客户信息维护 增
	public boolean input(String accounta,String name);
	//客户信息维护 删
	public boolean delete(String id);
	//客户信息维护 改
	public boolean modify(String accounta,String name,String id);
	//客户信息维护 查
	public List<CustomerInputDto> inquiry();
	//客户信息维护 管理员查
	public List<CustomerInputDto> inquiry2(String accounta);
	//查客户的销售记录
	public List<CustomerInputDto> inquiry3();
}
