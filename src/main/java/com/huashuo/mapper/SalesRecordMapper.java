package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesRecordMapper {
	public int insert(SalesRecordDto salesRecord);
	public int delete(SalesRecordDto salesRecord);
	public int update(SalesRecordDto salesRecord);
	public List<SalesRecordDto> findAll();
}
