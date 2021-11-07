package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.OrderQueryDto;
import com.huashuo.mapper.OrderQueryMapper;

@Service
public class OrderQueryServiceImpl implements OrderQueryService{
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	private OrderQueryMapper orderQueryMapper;
	/**
	 * 客户个人订单记录添加
	 */
	public boolean input(String accountc,String key) {
		OrderQueryServiceImpl orderQueryServiceImpl = new OrderQueryServiceImpl();
		String id = orderQueryServiceImpl.idPrice();
		String time = orderQueryServiceImpl.time();
		
		OrderQueryDto orderQuery = new OrderQueryDto();
		orderQuery.setId(id);
		orderQuery.setAccountc(accountc);
		orderQuery.setTime(time);
		orderQuery.setKey(key);
		
		int count = orderQueryMapper.insert(orderQuery);
		System.out.println("写入" + count + "条");
		
		return true;
	}

	/**
	 * 客户个人订单记录删除
	 */
	public boolean delete(String id) {
		OrderQueryDto orderQuery = new OrderQueryDto();
		orderQuery.setId(id);
		
		int cart = orderQueryMapper.delete(orderQuery);
		System.out.println(cart);
		return true;
	}
	
	/**
	 * 客户个人订单记录修改
	 */
	public boolean modify(String accountc,String key,String id) {
		OrderQueryDto orderQuery = new OrderQueryDto();
		orderQuery.setAccountc(accountc);
		orderQuery.setKey(key);
		orderQuery.setId(id);
		
		int cart = orderQueryMapper.update(orderQuery);
		System.out.println(cart);
		return true;
	}
	
	/**
	 * 客户全部订单记录查询
	 */
	public List<OrderQueryDto> orderQuery() {
		List<OrderQueryDto> str = orderQueryMapper.findAll();
		
		return str;
	}
	
	/**
	 * 客户个人订单记录查询
	 */
	public List<OrderQueryDto> orderQueryPersonal(String accountc) {
		OrderQueryDto orderQuery = new OrderQueryDto();
		orderQuery.setAccountc(accountc);
		List<OrderQueryDto> str = orderQueryMapper.findAccountc(orderQuery);
		
		return str;
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
	
	//自动获取当前时间
	public String time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());
		 System.out.println("自动获取当前时间" + time);// new Date()为获取当前系统时间
		 return time;
	}
}
