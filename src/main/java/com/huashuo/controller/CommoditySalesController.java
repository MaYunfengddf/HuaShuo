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
	/** 
	 * 数据库已删  查询全部商品直接查全部订单记录 就行
	 * 
	 * 
	 * 全部商品记录是商家可以查看所有顾客在该店铺购买的记录
	 * 全部商品销售记录维护 增@RequestParam("name") String name,@RequestParam("model") String model,
								@RequestParam("price") String price,@RequestParam("inventoryQuantity") String inventoryQuantity
								ID  	TIME  	ALLS 
	 * @return
	 */
	@RequestMapping("/SalesRecordWrite")
	public String SalesRecordWrite(){
		String alls = "11"; 
		System.out.println("增加所有销售记录");
		String str = salesRecordService.write(alls);
		return str;
	}
	
	/**@RequestParam("id") String id
	
	 * 全部商品销售记录维护 删
	 * @return
	 */
	@RequestMapping("/SalesRecordDelete")
	public String SalesRecordDelete(){
		String id = "3";
		System.out.println("删除所有销售记录");
		String str = salesRecordService.delete(id);
		return str;
	}
	
	/**@RequestParam("name") String name,@RequestParam("model") String model,
									@RequestParam("price") String price,@RequestParam("inventoryQuantity") String inventoryQuantity,
									@RequestParam("id") String id
	 * 全部商品销售记录维护 改
	 * 时间不可变
	 * @return
	 */
	@RequestMapping("/SalesRecordModify")
	
	public String SalesRecordModify(){
		String alls = "12";
		String id = "3";
		System.out.println("修改所有销售记录");
		String str = salesRecordService.modify(alls,id);
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
