package com.huashuo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
	public int insert(RegisterDto register);
}
