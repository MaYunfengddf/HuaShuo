package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.AllGoodsService;

@RestController
@RequestMapping("/huashuo")
public class CommodityController {

	@Autowired
	public AllGoodsService allGoodsService;
	
	/**
	 * 商品维护 增
	 * @return
	 */
	@RequestMapping("/AllGoodsWrite")
	public String AllGoodsWrite(){
		String name = "华硕笔记本";
		String model = "飞行堡垒";
		String price = "5511";
		String inventoryQuantity = "88";
		System.out.println("增加商品");
		String str = allGoodsService.write(name,model,price,inventoryQuantity);
		return str;
	}
	
	/**
	 * 商品维护 删
	 * @return
	 */
	@RequestMapping("/AllGoodsDelete")
	public String AllGoodsDelete(){
		String id = "7";
		System.out.println("删除商品");
		String str = allGoodsService.delete(id);
		return str;
	}
	
	/**
	 * 商品维护 改
	 * @return
	 */
	@RequestMapping("/AllGoodsModify")
	public String AllGoodsModify(){
		String name = "小米笔记本";
		String model = "Air";
		String price = "5655";
		String inventoryQuantity = "75";
		String id = "7";
		System.out.println("修改商品");
		String str = allGoodsService.modify(name,model,price,inventoryQuantity,id);
		return str;
	}
	
	/**
	 * 商品维护 查
	 * @return
	 */
	@RequestMapping("/AllGoodsInquiry")
	public String AllGoodsInquiry(){
		System.out.println("查询商品");
		String str = allGoodsService.inquiry();
		return str;
	}
}
