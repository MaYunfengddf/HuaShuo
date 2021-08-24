package com.huashuo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.OrderQueryDto;
import com.huashuo.mapper.OrderQueryMapper;

@Service
public class OrderQueryServiceImpl implements OrderQueryService{
	
	@Autowired
	private OrderQueryMapper orderQueryMapper;
	
	public List<OrderQueryDto> OrderQuery() {
		List<OrderQueryDto> str = orderQueryMapper.findAll();
		
		return str;
	}
}
