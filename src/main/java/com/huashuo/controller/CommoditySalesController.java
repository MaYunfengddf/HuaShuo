package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.SalesRecordService;

@RestController
@RequestMapping("/huashuo")
public class CommoditySalesController {

	@Autowired
	private SalesRecordService salesRecordService;
	/**SalesRecordDto
	 * 全部商品销售记录维护 增
	 * @return
	 */
	@RequestMapping("/SalesRecordWrite")
	public String SalesRecordWrite(){
		String name = "华硕笔记本";
		String model = "飞行堡垒";
		String price = "5511";
		String inventoryQuantity = "1";
		System.out.println("增加所有销售记录");
		String str = salesRecordService.write(name,model,price,inventoryQuantity);
		return str;
	}
	
	/**
	 * 全部商品销售记录维护 删
	 * @return
	 */
	@RequestMapping("/SalesRecordDelete")
	public String SalesRecordDelete(){
		String id = "7";
		System.out.println("删除所有销售记录");
		String str = salesRecordService.delete(id);
		return str;
	}
	
	/**
	 * 全部商品销售记录维护 改
	 * @return
	 */
	@RequestMapping("/SalesRecordModify")
	public String SalesRecordModify(){
		String name = "小米笔记本";
		String model = "Air";
		String price = "5655";
		String inventoryQuantity = "75";
		String id = "7";
		System.out.println("修改所有销售记录");
		String str = salesRecordService.modify(name,model,price,inventoryQuantity,id);
		return str;
	}
	
	/**
	 * 全部商品销售记录维护 查
	 * @return
	 */
	@RequestMapping("/SalesRecordInquiry")
	public String SalesRecordInquiry(){
		System.out.println("查询所有销售记录");
		String str = salesRecordService.inquiry();
		return str;
	}
}
