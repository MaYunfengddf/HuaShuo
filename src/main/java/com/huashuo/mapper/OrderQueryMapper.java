package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderQueryMapper {
	public int insert(OrderQueryDto orderQuery);
	
	public int delete(OrderQueryDto orderQuery);
	
	public int update(OrderQueryDto orderQuery);
	
	public List<OrderQueryDto> findAll();
	
	public List<OrderQueryDto> findAccountc(OrderQueryDto orderQuery);
}
