package com.huashuo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.PaymentDto;
import com.huashuo.mapper.PaymentMapper;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	public String payment(String id) {
		List<PaymentDto> payment = paymentMapper.findAll();
		System.out.println("购物车全部商品" + payment);
		
		String str = "";
		for(PaymentDto paymentDto: payment) {
			if(paymentDto.getId().equals(id)) {
				System.out.println("确定付款的商品" + paymentDto);
				str += paymentDto;
			}
		}
		
		return str;
	}
}
