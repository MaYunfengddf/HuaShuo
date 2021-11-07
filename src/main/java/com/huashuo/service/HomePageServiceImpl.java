package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.HomePageDto;
import com.huashuo.mapper.HomePageMapper;

@Service
public class HomePageServiceImpl implements HomePageService {
	Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	private HomePageMapper homePageMapper;
	
	public boolean write(String recommend) {
		HomePageServiceImpl homePageServiceImpl = new HomePageServiceImpl();
		String id = homePageServiceImpl.idPrice();
		
		HomePageDto homePage = new HomePageDto();
		homePage.setId(id);
		homePage.setRecommend(recommend);
		
		int cart = homePageMapper.insert(homePage);
		System.out.println(cart);
		return true;
	}
	
	public boolean delete(String id) {
		HomePageDto homePage = new HomePageDto();
		homePage.setId(id);
		
		int cart = homePageMapper.delete(homePage);
		System.out.println(cart);
		return true;
	}
	
	
	public boolean modify(String recommend,String id) {
		HomePageDto homePage = new HomePageDto();
		homePage.setRecommend(recommend);
		homePage.setId(id);
		
		int cart = homePageMapper.update(homePage);
		System.out.println(cart);
		return true;
	}
	
	
	public List<HomePageDto> inquiry() {
		List<HomePageDto> cart = homePageMapper.findAll();
		System.out.println(cart);
		return cart;
	}
	
	public List<HomePageDto> allQuery(String query) {
		log.info("input查询");
		HomePageDto homePage = new HomePageDto();
		homePage.setQuery(query);
		
		List<HomePageDto> cart = homePageMapper.allQuery(homePage);
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
			ResultSet res = sta.executeQuery("select * from HOMEPAGE order by id");

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
