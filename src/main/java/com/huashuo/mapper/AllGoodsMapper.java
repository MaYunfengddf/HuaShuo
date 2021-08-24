package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllGoodsMapper {
	public int insert(AllGoodsDto id);
	public int delete(AllGoodsDto id);
	public int update(AllGoodsDto id);
	public List<AllGoodsDto> findAll();
}
