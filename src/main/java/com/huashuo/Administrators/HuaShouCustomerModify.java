package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 客户信息维护 改
 * @author MaYunfeng
 *
 */
public class HuaShouCustomerModify {
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
	public String modify(String name,String quantity,String price,String model,String id) {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("修改客户信息");
			
			int purchaseQuantity = Integer.valueOf(quantity);
			int PurchasePrice = Integer.valueOf(price);
			Statement sta = conn.createStatement();           //编号 名字  数量  价格  型号 
			sta.executeUpdate("UPDATE HuaShuoCustomerInquiry SET NAME='" + name + "',PurchaseQuantity = " + purchaseQuantity + 
					 		",PurchasePrice =" + PurchasePrice + ",PurchaseModel = '" + model + "'WHERE ID=" + id + ";");
			
			System.out.println("修改H2数据库成功");;
			return "修改成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入H2数据库失败");
		}
		return null;
	}
}
