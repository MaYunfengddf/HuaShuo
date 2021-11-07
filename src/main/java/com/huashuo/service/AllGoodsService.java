package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.AllGoodsDto;

public interface AllGoodsService {
	//所有商品维护 增
	public boolean write(String name,String model,String colour,String size,String price,String images,String quantity,
						String type,String processor,String memory,String harddisk);
	//所有商品维护 删
	public boolean delete(String id);
	//所有商品维护 改
	public boolean modify(String name,String model,String colour,String size,String price,String images,String quantity,
						String type,String processor,String memory,String harddisk,String id);
	//所有商品维护 查
	public List<AllGoodsDto> inquiry();
	
	//指定id 查
	public List<AllGoodsDto> inquiry(String id);
}
