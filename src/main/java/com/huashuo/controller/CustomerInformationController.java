package com.huashuo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.Administrators.HuaShouCustomerDelete;
import com.huashuo.Administrators.HuaShouCustomerInquiry;
import com.huashuo.Administrators.HuaShouCustomerModify;
import com.huashuo.Administrators.HuaShouCustomerWrite;

@RestController
@RequestMapping("/huashuo")
public class CustomerInformationController {

	/**xx
	 * 客户信息维护 增
	 * @return
	 */
	@RequestMapping("/CustomerWrite")
	public String CustomerWrite(){
		String account1 = "小米";
		String account2 = "5";
		String account3 = "5555";
		String account4 = "锐龙";
		System.out.println("增加客户信息");
		HuaShouCustomerWrite huaShouCustomerWrite = new HuaShouCustomerWrite();
		String str = huaShouCustomerWrite.write(account1,account2,account3,account4);
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
		HuaShouCustomerDelete huaShouCustomerDelete = new HuaShouCustomerDelete();
		String str = huaShouCustomerDelete.delete(id);
		return str;
	}
	
	/**
	 * 客户信息维护 改
	 * @return
	 */
	@RequestMapping("/CustomerModify")
	public String CustomerModify(){
		String account1 = "小黑";
		String account2 = "4";
		String account3 = "5511";
		String account4 = "锐龙2";
		String id = "5";
		System.out.println("修改客户信息");
		HuaShouCustomerModify huaShouCustomerModify = new HuaShouCustomerModify();
		String str = huaShouCustomerModify.modify(account1,account2,account3,account4,id);
		return str;
	}
	
	/**
	 * 客户信息维护 查
	 * @return
	 */
	@RequestMapping("/CustomerInquiry")
	public String CustomerInquiry(){
		System.out.println("查询客户信息");
		HuaShouCustomerInquiry huaShouCustomerInquiry = new HuaShouCustomerInquiry();
		String str = huaShouCustomerInquiry.inquiry();
		return str;
	}
}
