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

import com.huashuo.beans.AddressRequest;
import com.huashuo.beans.AllGoodsResponse;
import com.huashuo.mapper.AddressDto;
import com.huashuo.service.AddressService;

/*
 * 收件地址
 */
@RestController
@RequestMapping("/huashuo")
public class AddressController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);

	@Autowired
	private AddressService addressService;
	/**
	 * 收件地址 添加
	 * @return
	 */
	@RequestMapping("/AddressInput")
	public AllGoodsResponse AddressInput(@RequestBody AddressRequest addressRequest,HttpServletRequest request){
		System.out.println("增加收件地址");

		log.info("手机号:{}，收件人地址:{}，收件人名字:{}",addressRequest.getPhone(), addressRequest.getAddress(), addressRequest.getName());
		
		//获取账号
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("购物车:" + names.length);
		
		String accountd = "";
		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);
			
		  
	        Object value = session.getAttribute(name);  
	        
	        System.out.println("key:" + name +":value:"+value);
	        accountd = String.valueOf(value);
		}
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = addressService.input(accountd, addressRequest.getPhone(),addressRequest.getAddress(), addressRequest.getName());
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
	 * 收件地址 删除
	 * @return
	 */
	@RequestMapping("/AddressDelete")
	public AllGoodsResponse AddressDelete(@RequestBody AddressRequest addressRequest){
		System.out.println("删除收件地址");
		log.info("收件地址ID{}",addressRequest.getId());
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = addressService.delete(addressRequest.getId());
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
	 * 收件地址 修改
	 * @return
	 */
	@RequestMapping("/AddressModify")
	public AllGoodsResponse AddressModify(@RequestBody AddressRequest addressRequest){
		System.out.println("修改收件地址");

		log.info("手机号:{}，收件人地址:{}，收件人名字:{}，收件人ID:{}", 
				addressRequest.getPhone(),addressRequest.getAddress(), addressRequest.getName(), addressRequest.getId());
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = addressService.modify(addressRequest.getPhone(),
				addressRequest.getAddress(), addressRequest.getName(), addressRequest.getId());
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
	 * 修改默认地址
	 * @param addressRequest
	 * @return
	 */
	@RequestMapping("/AddressModify2")
	public AllGoodsResponse AddressModify2(@RequestBody AddressRequest addressRequest){
		System.out.println("修改默认地址");

		log.info("2默认地址 1非默认地址:{}，ID:{}",addressRequest.getDefault2(), addressRequest.getId());
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = addressService.modify2( addressRequest.getDefault2(), addressRequest.getId());
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
	 * 收件地址 查询
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/AddressQuery")
	public List<AddressDto> AddressQuery(HttpServletRequest request){
		System.out.println("查询所有收件地址");
		HttpSession session = request.getSession();

		String[] names = session.getValueNames();
		System.out.println("收件地址:" + names.length);

		//迭代器
		for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
			String name = String.valueOf(e.nextElement());
			System.out.println(name);


			Object value = session.getAttribute(name);  

			System.out.println("key:" + name +"value:"+value);
			if("123456".equals(String.valueOf(value))){
				List<AddressDto> str1 = addressService.query();
				return str1;
			}else {
				List<AddressDto> str1 = addressService.query(String.valueOf(value));
				return str1;
			}
		}
		return null;
	}
}
