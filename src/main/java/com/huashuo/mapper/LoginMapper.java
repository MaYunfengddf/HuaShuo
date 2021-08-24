package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	public List<LoginDto> findAll();
}
