package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.AllGoodsDto;
import com.huashuo.mapper.AllGoodsMapper;

@Service
public class AllGoodsServiceImpl implements AllGoodsService {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	public AllGoodsMapper allGoodsMapper;
	
	public String write(String name,String model,String price,String inventoryquantity) {
		AllGoodsServiceImpl allGoodsServiceImpl = new AllGoodsServiceImpl();
		String id = allGoodsServiceImpl.idPrice();
		
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setId(id);
		allGoods.setName(name);
		allGoods.setModel(model);
		allGoods.setPrice(price);
		allGoods.setInventoryquantity(inventoryquantity);
		
		int cart = allGoodsMapper.insert(allGoods);
		System.out.println(cart);
		return "添加成功:" + cart + "条信息";
	}
	
	public String delete(String id) {
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setId(id);
		
		int cart = allGoodsMapper.delete(allGoods);
		System.out.println(cart);
		return "删除成功:" + cart + "条信息";
	}
	
	public String modify(String name,String model,String price,String inventoryquantity,String id) {
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setName(name);
		allGoods.setModel(model);
		allGoods.setPrice(price);
		allGoods.setInventoryquantity(inventoryquantity);
		allGoods.setId(id);
		
		int cart = allGoodsMapper.update(allGoods);
		System.out.println(cart);
		return "修改成功:" + cart + "条信息";
	}
	
	public String inquiry() {
		List<AllGoodsDto> all = allGoodsMapper.findAll();
		System.out.println(all);
		
		String str = String.valueOf(all);
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
