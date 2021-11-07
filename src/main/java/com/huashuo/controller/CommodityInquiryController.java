package com.huashuo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.mapper.CommodityDto;
import com.huashuo.service.CommodityInquiryService;

@RestController
@RequestMapping("/huashuo")
public class CommodityInquiryController {
	
	@Autowired
	private CommodityInquiryService commodityInquiryService;
	/**
	 * 查询ID
	 * @return
	 */
	@RequestMapping("/CommodityInquiryID")
	public List<CommodityDto> CommodityInquiryID(@RequestParam("id") String id){
		System.out.println(id + "查询ID");
		List<CommodityDto> str = commodityInquiryService.inquiryId(id);
		return str;
	}

	/**
	 * 查询name
	 * @return
	 */
	@RequestMapping("/CommodityInquiryName")
	public List<CommodityDto> CommodityInquiryName(@RequestParam("name") String name){
		System.out.println(name + "查询name");
		List<CommodityDto> str = commodityInquiryService.inquiryName(name);
		return str;
	}
	
	/** 
	 * 查询mode 型号查询
	 * @return
	 */
	@RequestMapping("/CommodityInquiryModel")
	public List<CommodityDto> CommodityInquiryModel(@RequestParam("model") String model){
		System.out.println(model + "查询model 型号查询");
		List<CommodityDto> str = commodityInquiryService.inquiryModel(model);
		return str;
	}
	
	/** 
	 * 查询price 价格查询
	 * @return
	 */
	@RequestMapping("/CommodityInquiryPrice")
	public List<CommodityDto> CommodityInquiryPrice( @RequestParam("price1") String price1,@RequestParam("price2") String price2){
		System.out.println(price1 + "查询price 价格查询" + price2);
		List<CommodityDto> str = commodityInquiryService.inquryPrice(price1,price2);
		return str;
		
	}
}
