package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderQueryMapper {
	public List<OrderQueryDto> findAll();
	
	public int insert(OrderQueryDto orderQuery);
}
