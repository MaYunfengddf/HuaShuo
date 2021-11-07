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
	
	public boolean write(String name,String model,String colour,String size,String price,String images,String quantity,
						String type,String processor,String memory,String harddisk) {
		AllGoodsServiceImpl allGoodsServiceImpl = new AllGoodsServiceImpl();
		String id = allGoodsServiceImpl.idPrice();
		
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setId(id);
		allGoods.setName(name);
		allGoods.setModel(model);
		allGoods.setColour(colour);
		allGoods.setSize(size);
		allGoods.setPrice(price);
		allGoods.setImages(images);
		allGoods.setQuantity(quantity);
		allGoods.setType(type);
		allGoods.setProcessor(processor);
		allGoods.setMemory(memory);
		allGoods.setHarddisk(harddisk);
		
		int cart = allGoodsMapper.insert(allGoods);
		System.out.println(cart);
		
		return true;
	}
	
	public boolean delete(String id) {
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setId(id);
		
		int cart = allGoodsMapper.delete(allGoods);
		System.out.println(cart);
		return true;
	}
	
	public boolean modify(String name,String model,String colour,String size,String price,String images,String quantity,
						String type,String processor,String memory,String harddisk,String id) {
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setName(name);
		allGoods.setModel(model);
		allGoods.setColour(colour);
		allGoods.setSize(size);
		allGoods.setPrice(price);
		allGoods.setImages(images);
		allGoods.setQuantity(quantity);
		allGoods.setType(type);
		allGoods.setProcessor(processor);
		allGoods.setMemory(memory);
		allGoods.setHarddisk(harddisk);
		allGoods.setId(id);
		System.out.println("实现类" + allGoods);
		int cart = allGoodsMapper.update(allGoods);
		System.out.println(cart);
		return true;
	}
	
	public List<AllGoodsDto> inquiry() {
		List<AllGoodsDto> all = allGoodsMapper.findAll();
		System.out.println(all);
		return all;
	}
	
	public List<AllGoodsDto> inquiry(String id) {
		AllGoodsDto allGoods = new AllGoodsDto();
		allGoods.setId(id);
		
		List<AllGoodsDto> all = allGoodsMapper.findAll2(allGoods);
		System.out.println(all);
		return all;
	}
	
	//获取ID并实现自增
			public String idPrice() {
				try {
					String id = "";
					Class.forName(DRIVER_CLASS);
					Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
					Statement sta = conn.createStatement();
					ResultSet res = sta.executeQuery("select * from HUASHUOALLGOODS order by id");

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
