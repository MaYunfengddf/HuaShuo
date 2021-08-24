package com.huashuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.RegisterDto;
import com.huashuo.mapper.RegisterMapper;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterMapper registerMapper;
	
	public boolean registerSystem(String account,String password) {
		System.out.println("华硕注册系统");
		
		RegisterDto register = new RegisterDto();
		register.setAccount(account);
		register.setPassword(password);
		
		int count = registerMapper.insert(register);
		System.out.println("原始" + count);
		return true;
	}
}
