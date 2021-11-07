package com.huashuo.service;

public interface SalesRecordService {
	//全部商品销售记录 增
	public String write(String alls);
	//全部商品销售记录 删
	public String delete(String id);
	//全部商品销售记录 改
	public String modify(String alls,String id);
	//全部商品销售记录 查
	public String inquiry();
}
