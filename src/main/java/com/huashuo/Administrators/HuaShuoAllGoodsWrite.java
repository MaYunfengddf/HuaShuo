package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 商品维护 增
 * @author MaYunfeng
 *
 */
public class HuaShuoAllGoodsWrite {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private String id;
	
	/**
	 * 写入数据库
	 * 写入仓库信息
	 * @param str1
	 * @param str2
	 */
	public String write(String name,String model,String price,String inventoryQuantity) {
		HuaShuoAllGoodsWrite huaShuoAllGoodsWrite = new HuaShuoAllGoodsWrite();
		
		try {

			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			
			int id = Integer.valueOf(huaShuoAllGoodsWrite.idPrice());
			int price1 = Integer.valueOf(price);
			int inventoryQuantity1 = Integer.valueOf(inventoryQuantity);
			
			Statement sta = conn.createStatement();				//序号   	商品名字  		商品型号 		商品价格 	 商品库存
			sta.execute("INSERT INTO HUASHUOALLGOODS VALUES("+ ++id + ",'" + name + "','" + model + "'," + price1 + "," + inventoryQuantity1 + ");");
			System.out.println("写入总商品成功");
			return "写入总商品成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入总商品失败");
		}
		return null;
	}
	
	/**
	 * 获取仓库ID
	 * @return
	 */
	public String idPrice() {

		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HUASHUOALLGOODS");

			while(res.next()) {
				//获取数据库中账号 并赋值
				id =  res.getString("id");
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
