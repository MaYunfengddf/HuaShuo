package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomePageMapper {
	//主页 增
	public int insert(HomePageDto homePage);
	//主页 删
	public int delete(HomePageDto homePage);
	//主页 改
	public int update(HomePageDto homePage);
	//主页 默认查
	public List<HomePageDto> findAll();
	//主页 input查
	public List<HomePageDto> allQuery(HomePageDto homePage);
}
