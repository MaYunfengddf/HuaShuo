package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	//客户
	public List<LoginDto> findAll();
	//管理员
	public List<LoginDto> manage();
}
