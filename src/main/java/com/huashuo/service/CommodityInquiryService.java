package com.huashuo.service;

public interface CommodityInquiryService {
	//商品查询ID
	public String inquiryId(String id);
	//商品查询名字
	public String inquiryName(String name);
	//商品查询型号
	public String inquiryModel(String model);
	//商品查询价格
	public String inquryPrice(String small,String large);
}
