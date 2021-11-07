package com.huashuo.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.beans.AllGoodsResponse;
import com.huashuo.beans.ShoppingCartRequest;
import com.huashuo.mapper.ShoppingCartDto;
import com.huashuo.service.ShoppingCartService;

@RestController
@RequestMapping("/huashuo")
public class ShoppingCartController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	/**
	 * 添加购物车 ID时间自动生成
	 * @return
	 */
	@RequestMapping("/ShoppingCartInput")
	public AllGoodsResponse ShoppingCartInput(@RequestBody ShoppingCartRequest shoppingCartRequest,HttpServletRequest request){
		System.out.println("添加购物车");
		log.info("健:{}",shoppingCartRequest.getKey());
		
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("购物车:" + names.length);
		
		String str = "";
		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);
			
		  
	        Object value = session.getAttribute(name);  
	        
	        System.out.println("key:" + name +":value:"+value);
	        str = String.valueOf(value);
		}
		boolean boo = shoppingCartService.input(str,shoppingCartRequest.getKey());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/**
	 * 删除购物车
	 * @return
	 */
	@RequestMapping("/ShoppingCartDelete")
	public AllGoodsResponse ShoppingCartDelete(@RequestBody ShoppingCartRequest shoppingCartRequest){
		System.out.println("删除购物车");
		log.info("购物车ID{}",shoppingCartRequest.getCat());
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = shoppingCartService.delete(shoppingCartRequest.getCat());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/**
	 * 修改购物车 时间不可改
	 * @return
	 */
	@RequestMapping("/ShoppingCartModify")
	public AllGoodsResponse ShoppingCartModify(@RequestBody ShoppingCartRequest shoppingCartRequest){
		System.out.println("修改购物车");

		log.info("账号:{},健:{}，购物车ID:{}", 
				shoppingCartRequest.getAccountb(),shoppingCartRequest.getKey(),shoppingCartRequest.getId());
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = shoppingCartService.modify(shoppingCartRequest.getAccountb(),shoppingCartRequest.getKey(),shoppingCartRequest.getId());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/** 
	 * 
	 * 查询所有购物车
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/ShoppingCartQuery")
	public List<ShoppingCartDto> ShoppingCartQuery(HttpServletRequest request){
		System.out.println("查询所有购物车");
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("购物车:" + names.length);

		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);
			
		  
	        Object value = session.getAttribute(name);  
	        
	        System.out.println("key:" + name +"value:"+value);
	        
			List<ShoppingCartDto> str1 = shoppingCartService.query(String.valueOf(value));
			return str1;

		}
		return null;
	}
}
