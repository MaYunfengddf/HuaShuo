package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.CommodityInquiryService;

@RestController
@RequestMapping("/huashuo")
public class CommodityInquiryController {
	
	@Autowired
	private CommodityInquiryService commodityInquiryService;
	/**
	 * 查询ID
	 * @return
	 * @RequestParam("id") String id
	 */
	@RequestMapping("/CommodityInquiryID")
	public String CommodityInquiryID(){
		String id = "5";
		System.out.println(id + "查询ID");
		String str = commodityInquiryService.inquiryId(id);
		return str;
	}

	/**
	 * @RequestParam("name") String name
	 * 查询name
	 * @return
	 */
	@RequestMapping("/CommodityInquiryName")
	public String CommodityInquiryName(){
		String name = "华硕";
		System.out.println(name + "查询name");
		String str = commodityInquiryService.inquiryName(name);
		return str;
	}
	
	/** 
	 * @RequestParam("mode") String mode
	 * 查询mode 型号查询
	 * @return
	 */
	@RequestMapping("/CommodityInquiryModel")
	public String CommodityInquiryModel(){
		String model = "飞行";
		System.out.println(model + "查询mode 型号查询");
		String str = commodityInquiryService.inquiryModel(model);
		return str;
	}
	
	/** 
	 * @RequestParam("price1") String price1,@RequestParam("price2") String price2
	 * 查询price 价格查询
	 * @return
	 */
	@RequestMapping("/CommodityInquiryPrice")
	public String CommodityInquiryPrice(){
		String price1 = "5555";
		String price2 = "88888";
		System.out.println(price1 + "查询price 价格查询" + price2);
		String str = commodityInquiryService.inquryPrice(price1,price2);
		return str;
	}
}
