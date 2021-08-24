package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.ShoppingCartService;

@RestController
@RequestMapping("/huashuo")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	/**
	 * @RequestParam("name") String name,@RequestParam("mode") String mode,@RequestParam("price") String price,@RequestParam("quantity") String quantity
	 * 添加购物车
	 * @return
	 */
	@RequestMapping("/ShoppingCartInput")
	public String ShoppingCartInput(){
		String name = "华硕笔记本";
		String model = "飞行堡垒";
		String price = "5560";
		String quantity = "1";
		System.out.println(name + "添加购物车" + model +"  " + price + "   " + quantity);
		String str = shoppingCartService.input(name,model,price,quantity);
		return str;
	}
	
	/**
	 * 删除购物车
	 * @return
	 */
	@RequestMapping("/ShoppingCartDelete")
	public String ShoppingCartDelete(){
		
		String id = "7";
		System.out.println(id + "删除购物车");
		
		String str = shoppingCartService.delete(id);
		return str;
	}
	
	/**
	 * 修改购物车
	 * @return
	 */
	@RequestMapping("/ShoppingCartModify")
	public String ShoppingCartModify(){
		String id = "7";
		String name = "小米笔记本";
		String model = "密";
		String price = "5544";
		String quantity = "1";
		System.out.println(name + "添加购物车" + model +"  " + price + "   " + quantity + "  " + id);
		String str = shoppingCartService.modify(name,model,price,quantity,id);
		return str;
	}
	
	/** 
	 * 查询所有购物车
	 * @return
	 */
	@RequestMapping("/ShoppingCartQuery")
	public String ShoppingCartQuery(){
		System.out.println("查询所有购物车");
		String str = shoppingCartService.query();
		return str;
	}
}
