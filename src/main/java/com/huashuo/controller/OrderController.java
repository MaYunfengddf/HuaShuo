package com.huashuo.controller;

import java.util.Enumeration;
import java.util.Iterator;
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
import com.huashuo.beans.OrderRequest;
import com.huashuo.mapper.OrderQueryDto;
import com.huashuo.service.OrderQueryService;
import com.huashuo.service.PaymentService;

@RestController
@RequestMapping("/huashuo")
public class OrderController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);

	@Autowired
	private OrderQueryService orderQueryService;

	//生成订单
	@Autowired
	private PaymentService paymentService;

	/**                
	 * 订单记录是客户个人购买记录
	 * 增加订单记录 
	 * @return
	 */
	@RequestMapping("/OrderWriting")
	public AllGoodsResponse OrderWriting(@RequestBody OrderRequest orderRequest,HttpServletRequest request){

		log.info("订单键{}", orderRequest.getKey());
		System.out.println("前端返回健" + orderRequest.getKey2());
		
		//获取账号
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
		
		
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = false;
		List<String> list = orderRequest.getKey2();
		Iterator<String> iterator = list.iterator();
	        while(iterator.hasNext()){
	            String next = iterator.next();
	            System.out.println(next);
	            boo = orderQueryService.input(str, next);
	        }    
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
	 *删除订单记录
	 * @return
	 */
	@RequestMapping("/OrderDelete")
	public AllGoodsResponse OrderDelete(@RequestBody OrderRequest orderRequest){
		log.info("订单ID{}",orderRequest.getId());

		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = orderQueryService.delete(orderRequest.getId());
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
	 * 修改所有订单记录
	 * @return
	 */
	@RequestMapping("/OrderModify")
	public AllGoodsResponse OrderModify(@RequestBody OrderRequest orderRequest){
		log.info("订单账号{}，订单键{}，订单Id{}", 
				orderRequest.getAccountc(), orderRequest.getKey(), orderRequest.getId());

		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = orderQueryService.modify(orderRequest.getAccountc(), orderRequest.getKey(), orderRequest.getId());
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
	 * 查询所有订单记录post
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/OrderQuery")
	public List<OrderQueryDto> OrderQuery(HttpServletRequest request){
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("订单:" + names.length);

		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);
			
		  
	        Object value = session.getAttribute(name);  
	        
	        System.out.println("key:" + name +"value:"+value);
	        
	        if("123456".equals(String.valueOf(value))){
				List<OrderQueryDto> str1 = orderQueryService.orderQuery();
				return str1;
			}else {
				List<OrderQueryDto> str2 = orderQueryService.orderQueryPersonal(String.valueOf(value));
				return str2;
			}

		}
		return null;
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
