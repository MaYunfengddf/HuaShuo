package com.huashuo.service;

public interface SalesRecordService {
	//全部商品销售记录 增
	public String write(String name,String model,String price,String quantity);
	//全部商品销售记录 删
	public String delete(String id);
	//全部商品销售记录 改
	public String modify(String name,String model,String price,String quantity,String id);
	//全部商品销售记录 查
	public String inquiry();
}
