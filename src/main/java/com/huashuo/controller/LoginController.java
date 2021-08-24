package com.huashuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.service.LoginService;
import com.huashuo.service.RegisterService;

@RestController
@RequestMapping("/huashuo")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;
	/**
	 * 登录 RegisterDto
	 * @return
	 * @RequestParam("account") String account,@RequestParam("password") String password
	 */
	@RequestMapping("/loginSystem")
	public boolean loginSystem(){
		String account = "123456";
		String password = "123456";
		System.out.println(account+"   "+password + "登录");
		boolean boo = loginService.loginSystem(account,password);
		return boo;
	}
	
	/**
	 * 注册账号密码
	 * @return
	 * @RequestParam("account") String account,@RequestParam("password") String password
	 */
	@RequestMapping("/RegisterSystem")
	public boolean RegisterSystem(){
		String account = "55555";
		String password = "55555";
		boolean str = registerService.registerSystem(account,password);
		return str;
	}
}
