package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerInputMapper {
	public int insert(CustomerInputDto customerInputDto);
	public int delete(CustomerInputDto customerInputDto);
	public int update(CustomerInputDto customerInputDto);
	public List<CustomerInputDto> findAll();
	public List<CustomerInputDto> findAll2(CustomerInputDto customerInputDto);
	public List<CustomerInputDto> findAll3();
}
