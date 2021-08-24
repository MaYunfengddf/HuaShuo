package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.CustomerInputDto;
import com.huashuo.mapper.CustomerInputMapper;

@Service
public class CustomerInputServiceImpl implements CustomerInputService {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	public CustomerInputMapper customerInputMapper;
	
	public String input(String name,String quantity,String price,String model) {
		CustomerInputServiceImpl customerInputServiceImpl = new CustomerInputServiceImpl();
		String id = customerInputServiceImpl.idPrice();
		
		CustomerInputDto customerInputDto = new CustomerInputDto();
		customerInputDto.setId(id);
		customerInputDto.setName(name);
		customerInputDto.setPurchaseQuantity(quantity);
		customerInputDto.setPurchasePrice(price);
		customerInputDto.setPurchaseModel(model);
		
		int cart = customerInputMapper.insert(customerInputDto);
		System.out.println(cart);
		return "添加成功:" + cart + "条信息";
	}
	public String delete(String id) {
		CustomerInputDto customerInputDto = new CustomerInputDto();
		customerInputDto.setId(id);
		
		int cart = customerInputMapper.delete(customerInputDto);
		System.out.println(cart);
		return "删除成功:" + cart + "条信息";
	}
	public String modify(String name,String quantity,String price,String model,String id) {
		CustomerInputDto customerInputDto = new CustomerInputDto();
		customerInputDto.setName(name);
		customerInputDto.setPurchaseQuantity(quantity);
		customerInputDto.setPurchasePrice(price);
		customerInputDto.setPurchaseModel(model);
		customerInputDto.setId(id);
		
		int cart = customerInputMapper.update(customerInputDto);
		System.out.println(cart);
		return "修改成功:" + cart + "条信息";
	}
	public String inquiry() {
		List<CustomerInputDto> cart = customerInputMapper.findAll();
		System.out.println(cart);
		
		String str = String.valueOf(cart);
		return str;
	}
	
	//获取ID并实现自增
			public String idPrice() {
				try {
					String id = "";
					Class.forName(DRIVER_CLASS);
					Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
					Statement sta = conn.createStatement();
					ResultSet res = sta.executeQuery("select * from HuaShuoCustomerInquiry order by id");

					while(res.next()) {
						id =  res.getString("id");
					}
					int id2 = Integer.valueOf(id);
					System.out.println(id2);
					int id3 = ++id2;
					System.out.println(id3);
					String id4 = String.valueOf(id3);
					
					return id4;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}
