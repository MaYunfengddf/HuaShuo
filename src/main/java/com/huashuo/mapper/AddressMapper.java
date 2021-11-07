package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
	//收件地址 增
	public int insert(AddressDto addressDto);
	//收件地址 删
	public int delete(AddressDto addressDto);
	//收件地址 改
	public int update(AddressDto addressDto);
	//修改默认地址
	public int update2(AddressDto addressDto);
	//收件地址 查
	public List<AddressDto> findAll(AddressDto addressDto);
	//收件地址 查  管理员
	public List<AddressDto> findAll2();
}
