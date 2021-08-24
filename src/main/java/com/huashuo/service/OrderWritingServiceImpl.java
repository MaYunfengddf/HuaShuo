package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.OrderQueryDto;
import com.huashuo.mapper.OrderQueryMapper;

@Service
public class OrderWritingServiceImpl implements OrderWritingService{
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	private OrderQueryMapper orderQueryMapper;
	
	public String registerSystem(String name,String model,String price,String quantity) {
		OrderWritingServiceImpl orderWritingServiceImpl = new OrderWritingServiceImpl();
		String id2 = orderWritingServiceImpl.idPrice();
		
		OrderQueryDto orderQuery = new OrderQueryDto();
		orderQuery.setId(id2);
		orderQuery.setName(name);
		orderQuery.setModel(model);
		orderQuery.setPrice(price);
		orderQuery.setQuantity(quantity);
		
		int count = orderQueryMapper.insert(orderQuery);
		System.out.println("写入" + count + "条");
		
		return "写入成功";
	}
	
	public String idPrice() {
		try {
			String id = "";
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HuaShuoOrderQuery order by id");

			while(res.next()) {
				id =  res.getString("id");
			}
			int id2 = Integer.valueOf(id);
			int id3 = ++id2;
			
			String id4 = String.valueOf(id3);
			
			return id4;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
