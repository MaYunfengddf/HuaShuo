package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.SalesRecordDto;
import com.huashuo.mapper.SalesRecordMapper;

@Service
public class SalesRecordServiceImpl implements SalesRecordService {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	public SalesRecordMapper salesRecordMapper;
	
	public String write(String name,String model,String price,String quantity) {
		ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();
		String id = shoppingCartServiceImpl.idPrice();
		
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setId(id);
		salesRecord.setName(name);
		salesRecord.setModel(model);
		salesRecord.setPrice(price);
		salesRecord.setQuantity(quantity);
		
		int cart = salesRecordMapper.insert(salesRecord);
		System.out.println(cart);
		return "添加成功:" + cart + "条信息";
	}
	
	public String delete(String id) {
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setId(id);
		
		int cart = salesRecordMapper.delete(salesRecord);
		System.out.println(cart);
		return "删除成功:" + cart + "条信息";
	}
	
	public String modify(String name,String model,String price,String quantity,String id) {
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setName(name);
		salesRecord.setModel(model);
		salesRecord.setPrice(price);
		salesRecord.setQuantity(quantity);
		salesRecord.setId(id);
		
		int cart = salesRecordMapper.update(salesRecord);
		System.out.println(cart);
		return "修改成功:" + cart + "条信息";
	}
	
	public String inquiry() {
		List<SalesRecordDto> cart = salesRecordMapper.findAll();
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
					ResultSet res = sta.executeQuery("select * from HUASHUOSHOPPINGCART order by id");

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
