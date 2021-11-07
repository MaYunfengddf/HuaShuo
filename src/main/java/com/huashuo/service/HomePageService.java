package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.HomePageDto;

public interface HomePageService {
	//主页 增
	public boolean write(String recommend);
	//主页 删
	public boolean delete(String id);
	//主页 改
	public boolean modify(String recommend,String id);
	//主页 默认查
	public List<HomePageDto> inquiry();
	//主页 input查
	public List<HomePageDto> allQuery(String query);
}
