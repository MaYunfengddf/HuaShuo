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

import com.huashuo.mapper.ShoppingCartDto;
import com.huashuo.mapper.ShoppingCartMapper;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
		//购物车 增
		public boolean input(String accountb,String key) {
		
			
			ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();
			String id = shoppingCartServiceImpl.idPrice();
			//自动获取当前时间
			String time = shoppingCartServiceImpl.time();
			
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setId(id);
			shoppingCart.setAccountb(accountb);
			shoppingCart.setTime(time);
			shoppingCart.setKey(key);
			shoppingCart.setNum("1");
			
			int cart = shoppingCartMapper.insert(shoppingCart);
			System.out.println(cart);
			return true;
		}
		
		//购物车 删
		public boolean delete(String id) {
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setId(id);
			
			int cart = shoppingCartMapper.delete(shoppingCart);
			System.out.println(cart);
			return true;
		}
		
		//购物车 改
		public boolean modify(String accountb,String key,String id) {
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setAccountb(accountb);
			shoppingCart.setKey(key);
			shoppingCart.setId(id);
			
			int cart = shoppingCartMapper.update(shoppingCart);
			System.out.println(cart);
			return true;
		}
		
		//购物车 查
		public List<ShoppingCartDto> query(String accountb) {
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setAccountb(accountb);
			
			List<ShoppingCartDto> cart = shoppingCartMapper.findAll(shoppingCart);
			System.out.println(cart);
			return cart;
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
		
		//自动获取当前时间
		public String time() {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time = df.format(new Date());
			 System.out.println("自动获取当前时间" + time);// new Date()为获取当前系统时间
			 return time;
		}
}
