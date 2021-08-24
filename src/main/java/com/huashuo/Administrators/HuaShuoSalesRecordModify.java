package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 全部商品销售记录维护 改
 * @author MaYunfeng
 *
 */
public class HuaShuoSalesRecordModify {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	public String modify(String name,String model,String price,String quantity,String id) {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("修改客户信息");
			
			int purchaseQuantity = Integer.valueOf(quantity);
			int PurchasePrice = Integer.valueOf(price);
			Statement sta = conn.createStatement();           //编号 名字  数量  价格  型号 
			sta.executeUpdate("UPDATE HuaShuoSalesRecord SET NAME='" + name + "',Model = '" + model + 
					 		"',Price =" + PurchasePrice + ",Quantity = " + purchaseQuantity + "WHERE ID=" + id + ";");
			
			System.out.println("修改H2数据库成功");;
			return "修改成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入H2数据库失败");
		}
		return null;
	}
}
