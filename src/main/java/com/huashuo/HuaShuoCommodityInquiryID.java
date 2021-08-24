package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 华硕客户
 * 商品ID查询
 * @author MaYunfeng
 *
 */
public class HuaShuoCommodityInquiryID {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";


	//1查询商品编号
	public String queryID(String str) {
		System.out.println("查询商品编号");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			
			String strID = "";

			ResultSet res = sta.executeQuery("SELECT * FROM HUASHUOALLGOODS");
			while(res.next()) {
				//获取数据库中账号 并赋值
				String id =  res.getString("id");

				//获取数据库中密码 并赋值
				if(str.equals(id)) {
					String name =  res.getString("name");
					String model =  res.getString("model");
					String price =  res.getString("price");
					String InventoryQuantity =  res.getString("InventoryQuantity");

					System.out.println("商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + InventoryQuantity +"\r\n");
					strID +="商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + InventoryQuantity +"\r\n";
				}
			}
			return strID;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
