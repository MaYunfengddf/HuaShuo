package com.huashuo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.CommodityDto;
import com.huashuo.mapper.CommodityMapper;

@Service
public class CommodityInquiryServiceImpl implements CommodityInquiryService{
	@Autowired 
	private CommodityMapper commodityMapper;

	/**
	 * 商品查询ID
	 */
	public List<CommodityDto> inquiryId(String id) {
		List<CommodityDto> commodity = commodityMapper.findAllId();
		return commodity;
	}
	
	//商品查询名字
	public List<CommodityDto> inquiryName(String name) {
		CommodityDto commodityDto = new CommodityDto();
		commodityDto.setName(name);

		System.out.println(commodityDto);
		List<CommodityDto> commodity = commodityMapper.findAllName(commodityDto);
		return commodity;
	}
	
	//商品查询型号
	public List<CommodityDto> inquiryModel(String model) {
		CommodityDto commodityDto = new CommodityDto();
		commodityDto.setModel(model);

		List<CommodityDto> commodity = commodityMapper.findAllModel(commodityDto);
		return commodity;
	}
	//商品查询价格
	public List<CommodityDto> inquryPrice(String small,String large) {
		BigDecimal commodityDto1 = new BigDecimal(small);
		BigDecimal commodityDto2 = new BigDecimal(large);
		List<CommodityDto> commodity = commodityMapper.findAllPrice(commodityDto1,commodityDto2);
		return commodity;
	}
}
