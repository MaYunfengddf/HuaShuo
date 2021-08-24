package com.huashuo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.LoginDto;
import com.huashuo.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper loginMapper;
	
	public boolean loginSystem(String account, String password) {
		System.out.println("登录系统");

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
}
