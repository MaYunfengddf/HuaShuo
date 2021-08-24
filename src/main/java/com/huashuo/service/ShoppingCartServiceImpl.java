package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
		public String input(String name,String model,String price,String quantity) {
			ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();
			String id = shoppingCartServiceImpl.idPrice();
			
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setId(id);
			shoppingCart.setName(name);
			shoppingCart.setModel(model);
			shoppingCart.setPrice(price);
			shoppingCart.setQuantity(quantity);
			
			int cart = shoppingCartMapper.insert(shoppingCart);
			System.out.println(cart);
			return "添加成功:" + cart + "条信息";
		}
		
		//购物车 删
		public String delete(String id) {
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setId(id);
			
			int cart = shoppingCartMapper.delete(shoppingCart);
			System.out.println(cart);
			return "删除成功:" + cart + "条信息";
		}
		
		//购物车 改
		public String modify(String name,String model,String price,String quantity,String id) {
			ShoppingCartDto shoppingCart = new ShoppingCartDto();
			shoppingCart.setName(name);
			shoppingCart.setModel(model);
			shoppingCart.setPrice(price);
			shoppingCart.setQuantity(quantity);
			shoppingCart.setId(id);
			
			int cart = shoppingCartMapper.update(shoppingCart);
			System.out.println(cart);
			return "修改成功:" + cart + "条信息";
		}
		
		//购物车 查
		public String query() {
			List<ShoppingCartDto> cart = shoppingCartMapper.findAll();
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
