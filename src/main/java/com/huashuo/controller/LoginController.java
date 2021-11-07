package com.huashuo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.beans.LoginRequest;
import com.huashuo.beans.LoginResponse;
import com.huashuo.service.LoginService;
import com.huashuo.service.RegisterService;

@RestController
@RequestMapping("/huashuo")
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;
	/**
	 * 客户登录
	 * @return
	 */
	@RequestMapping("/loginSystem")
	public LoginResponse loginSystem(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
		log.info("客户登录账号{}，密码{}", loginRequest.getAccount(), loginRequest.getPassword());
		
		
		LoginResponse loginResponse = new LoginResponse();
		boolean boo = loginService.loginSystem(loginRequest.getAccount(), loginRequest.getPassword());
		if(boo) {
			//session
			HttpSession session = request.getSession();
			session.setAttribute("Account", loginRequest.getAccount());
			
			loginResponse.setCode("0000");
			loginResponse.setMessage("登录成功");
			System.out.println("登录成功");
		} else {
			loginResponse.setCode("9999");
			loginResponse.setMessage("登录失败");
			System.out.println("登录失败");
		}
		
		return loginResponse;
	}
	
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping("/manage")
	public LoginResponse manage(HttpServletRequest request, @RequestBody LoginRequest loginRequest){
		log.info("管理员登录账号{}，密码{}", loginRequest.getManageAccount(), loginRequest.getManagePassword());
		
		
		LoginResponse loginResponse = new LoginResponse();
		boolean boo = loginService.manageSystem(loginRequest.getManageAccount(), loginRequest.getManagePassword());
		if(boo) {
			//session
			HttpSession session = request.getSession();
			session.setAttribute("Account", loginRequest.getManageAccount());
			
			loginResponse.setCode("0000");
			loginResponse.setMessage("登录成功");
			System.out.println("登录成功");
		} else {
			loginResponse.setCode("9999");
			loginResponse.setMessage("登录失败");
			System.out.println("登录失败");
		}
		
		return loginResponse;
	}
	
	/**
	 * 注册账号密码
	 * @return
	 */
	@RequestMapping("/RegisterSystem")
	public boolean RegisterSystem( @RequestParam("account") String account,@RequestParam("password") String password){
		boolean str = registerService.registerSystem(account,password);
		return str;
	}
}
