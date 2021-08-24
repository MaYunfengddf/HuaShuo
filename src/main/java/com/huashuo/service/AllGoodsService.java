package com.huashuo.service;

public interface AllGoodsService {
	//所有商品维护 增
	public String write(String name,String model,String price,String inventoryquantity);
	//所有商品维护 删
	public String delete(String id);
	//所有商品维护 改
	public String modify(String name,String model,String price,String inventoryquantity,String id);
	//所有商品维护 查
	public String inquiry();
}
