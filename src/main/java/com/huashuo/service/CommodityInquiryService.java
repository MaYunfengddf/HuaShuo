package com.huashuo.service;

import java.util.List;

import com.huashuo.mapper.CommodityDto;

public interface CommodityInquiryService {
	//商品查询ID
	public List<CommodityDto> inquiryId(String id);
	//商品查询名字
	public List<CommodityDto> inquiryName(String name);
	//商品查询型号
	public List<CommodityDto> inquiryModel(String model);
	//商品查询价格
	public List<CommodityDto> inquryPrice(String small,String large);
}
