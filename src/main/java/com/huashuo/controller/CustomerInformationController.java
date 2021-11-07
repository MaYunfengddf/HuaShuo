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
import com.huashuo.beans.CustomerRequest;
import com.huashuo.mapper.CustomerInputDto;
import com.huashuo.service.CustomerInputService;

@RestController
@RequestMapping("/huashuo")
public class CustomerInformationController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);

	@Autowired
	public CustomerInputService customerInputService;
	/**
	 * 客户信息维护 增
	 * @return
	 */
	@RequestMapping("/CustomerWrite")
	public AllGoodsResponse CustomerWrite(@RequestBody CustomerRequest customerRequest){
		log.info("订单账号{}，订单键{}", 
				customerRequest.getAccounta(), customerRequest.getName());

		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = customerInputService.input(customerRequest.getAccounta(), customerRequest.getName());
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
	 * 客户信息维护 删
	 * @return
	 */
	@RequestMapping("/CustomerDelete")
	public AllGoodsResponse CustomerDelete(@RequestBody CustomerRequest customerRequest){
		log.info("订单ID{}",customerRequest.getId());

		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = customerInputService.delete(customerRequest.getId());
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
	 * 客户信息维护 改
	 * @return
	 */
	@RequestMapping("/CustomerModify")
	public AllGoodsResponse CustomerModify(@RequestBody CustomerRequest customerRequest){
		log.info("订单账号{}，订单键{}，订单Id{}", 
				customerRequest.getAccounta(), customerRequest.getName(), customerRequest.getId());

		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = customerInputService.modify(customerRequest.getAccounta(), customerRequest.getName(), customerRequest.getId());
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
	 * 客户信息维护 查
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/CustomerInquiry")
	public List<CustomerInputDto> CustomerInquiry(HttpServletRequest request){
		System.out.println("查询客户信息");
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("客户:" + names.length);

		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);


			Object value = session.getAttribute(name);  

			System.out.println("key:" + name +"value:"+value);
			//123456为管理员账号 管理员查询会直接查询全部客户信息
			if("123456".equals(String.valueOf(value))){
				List<CustomerInputDto> str = customerInputService.inquiry();
				return str;
			}else {
				List<CustomerInputDto> str = customerInputService.inquiry2(String.valueOf(value));
				return str;
			}
		}
		return null;
	}

	/**
	 * 查客户的全部销售记录
	 * @return
	 */
	@RequestMapping("/CustomerInquiry2")
	public List<CustomerInputDto> CustomerInquiry2(HttpServletRequest request){
		System.out.println("查询客户全部销售信息");
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("客户:" + names.length);

		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);


			Object value = session.getAttribute(name);  

			System.out.println("key:" + name +"value:"+value);
			List<CustomerInputDto> str = customerInputService.inquiry3();
			return str;
		}
		return null;
	}
}
