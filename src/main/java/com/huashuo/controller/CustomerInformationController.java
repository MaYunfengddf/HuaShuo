package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.CustomerInputService;

@RestController
@RequestMapping("/huashuo")
public class CustomerInformationController {

	@Autowired
	public CustomerInputService customerInputService;
	/**CustomerInputMapper
	 * 客户信息维护 增
	 * @return
	 */
	@RequestMapping("/CustomerWrite")
	public String CustomerWrite(){
		String name = "小米";
		String quantity = "5";
		String price = "5555";
		String model = "锐龙";
		System.out.println("增加客户信息");
		String str = customerInputService.input(name,quantity,price,model);
		return str;
	}
	
	/**
	 * 客户信息维护 删
	 * @return
	 */
	@RequestMapping("/CustomerDelete")
	public String CustomerDelete(){
		String id = "8";
		System.out.println("删除客户信息");
		String str = customerInputService.delete(id);
		return str;
	}
	
	/**
	 * 客户信息维护 改
	 * @return
	 */
	@RequestMapping("/CustomerModify")
	public String CustomerModify(){
		String name = "小黑";
		String quantity = "4";
		String price = "5511";
		String model = "锐龙2";
		String id = "8";
		System.out.println("修改客户信息");
		String str = customerInputService.modify(name,quantity,price,model,id);
		return str;
	}
	
	/**
	 * 客户信息维护 查
	 * @return
	 */
	@RequestMapping("/CustomerInquiry")
	public String CustomerInquiry(){
		System.out.println("查询客户信息");
		String str = customerInputService.inquiry();
		return str;
	}
}
