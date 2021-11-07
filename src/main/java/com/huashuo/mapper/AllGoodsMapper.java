package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllGoodsMapper {
	public int insert(AllGoodsDto id);
	public int delete(AllGoodsDto id);
	public int update(AllGoodsDto id);
	//查询全部
	public List<AllGoodsDto> findAll();
	//查询指定id
	public List<AllGoodsDto> findAll2(AllGoodsDto id);
}
