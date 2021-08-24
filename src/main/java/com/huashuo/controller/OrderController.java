package com.huashuo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.mapper.OrderQueryDto;
import com.huashuo.service.OrderQueryService;
import com.huashuo.service.OrderWritingService;
import com.huashuo.service.PaymentService;

@RestController
@RequestMapping("/huashuo")
public class OrderController {

	@Autowired
	private OrderQueryService orderQueryService;
	
	@Autowired
	private OrderWritingService orderWritingService;
	
	@Autowired
	private PaymentService paymentService;
	/**                                    
	 * 查询所有订单记录
	 * @return
	 */
	@RequestMapping("/OrderQuery")
	public List<OrderQueryDto> OrderQuery(){
		System.out.println("查询所有订单记录");
		List<OrderQueryDto> str = orderQueryService.OrderQuery();
		return str;
	}
	
	/**
	 * 写入所有订单记录 
	 * @return
	 */
	@RequestMapping("/OrderWriting")
	public String OrderWriting(){
		String name = "小米笔记本";
		String model = "锐龙";
		String price = "5555";
		String quantity = "1";
		System.out.println("写入所有订单记录");
		String str = orderWritingService.registerSystem(name,model,price,quantity);
		return str;
	}
	
	
	/**
	 * 生成订单/付款
	 * @return
	 */
	@RequestMapping("/GenerateOrder")
	public String GenerateOrder(){
		String id = "4";
		System.out.println("生成订单付款");
		String str =paymentService.payment(id);
		
		return str +"\r\n" + "付款成功";
	}
}
