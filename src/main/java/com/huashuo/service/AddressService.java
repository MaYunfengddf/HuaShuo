package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.AddressDto;

public interface AddressService {
	//收件地址 增
	public boolean input(String accountd,String phone,String address,String name);
	
	//收件地址 删
	public boolean delete(String id);
	
	//收件地址 改
	public boolean modify(String phone,String address,String name,String id);
	
	//收件地址 改
		public boolean modify2(String default2,String id);
		
	//收件地址 查
	public List<AddressDto> query(String accountb);
	
	//收件地址 查  管理员
	public List<AddressDto> query();
}
