package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 华硕商品维护 改
 * @author MaYunfeng
 *
 */
public class HuaShuoAllGoodsModify {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	/**
	 * 华硕客户修改
	 * @param name
	 * @param quantity
	 * @param price
	 * @param model
	 * @param id
	 * @return
	 */
	public String modify(String name,String model,String price,String inventoryQuantity,String id) {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("修改总商品");
			
			int purchaseQuantity = Integer.valueOf(inventoryQuantity);
			int PurchasePrice = Integer.valueOf(price);
			Statement sta = conn.createStatement();           //编号 名字  数量  价格  型号 
			sta.executeUpdate("UPDATE HUASHUOALLGOODS SET NAME='" + name + "',Model = '" + model + "',"
					+ "Price =" + PurchasePrice +  ",inventoryQuantity = " + purchaseQuantity + "WHERE ID=" + id + ";");
			
			System.out.println("修改总商品成功");;
			return "修改总商品成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("修改总商品失败");
		}
		return null;
	}
}
