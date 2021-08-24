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
	
	//商品查询ID
		public String inquiryId(String id) {
			List<CommodityDto> commodity = commodityMapper.findAllId();
			String str = "";
			for(CommodityDto commodityDto: commodity) {
					if(commodityDto.getId().equals(id)) {
						System.out.println(commodityDto);
						str += commodityDto;
					}
				}
			return str;
		}
		//商品查询名字
		public String inquiryName(String name) {
			CommodityDto commodityDto = new CommodityDto();
			commodityDto.setName(name);
			
			System.out.println(commodityDto);
			List<CommodityDto> commodity = commodityMapper.findAllName(commodityDto);
			String str = String.valueOf(commodity);
			return str;
		}
		//商品查询型号
		public String inquiryModel(String model) {
			CommodityDto commodityDto = new CommodityDto();
			commodityDto.setModel(model);
			
			List<CommodityDto> commodity = commodityMapper.findAllModel(commodityDto);
			String str = String.valueOf(commodity);
			return str;
		}
		//商品查询价格
		public String inquryPrice(String small,String large) {
			BigDecimal commodityDto1 = new BigDecimal(small);
			BigDecimal commodityDto2 = new BigDecimal(large);
			List<CommodityDto> commodity = commodityMapper.findAllPrice(commodityDto1,commodityDto2);
			String str = String.valueOf(commodity);
			return str;
		}
}
