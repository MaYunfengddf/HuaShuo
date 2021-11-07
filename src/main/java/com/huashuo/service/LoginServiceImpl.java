package com.huashuo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.LoginDto;
import com.huashuo.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{
	Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginMapper loginMapper;
	
	public boolean loginSystem(String account, String password) {
		log.info("客户登录系统");

		List<LoginDto> accountPassword = loginMapper.findAll();
		System.out.println("原始" + accountPassword);
		
		boolean flag = false;
		for(LoginDto huaShuoDto: accountPassword) {
			if(huaShuoDto.getAccount().equals(account) && huaShuoDto.getPassword().equals(password)) {
				flag = true;
			}
		}
		return flag;
	}
	public boolean manageSystem(String manageAccount, String managePassword) {
		log.info("管理员登录系统");

		List<LoginDto> accountPassword = loginMapper.manage();
		System.out.println("原始" + accountPassword);
		
		boolean flag = false;
		for(LoginDto huaShuoDto: accountPassword) {
			if(huaShuoDto.getManageAccount().equals(manageAccount) && huaShuoDto.getManagePassword().equals(managePassword)) {
				flag = true;
			}
		}
		return flag;
	}
	
	
}
