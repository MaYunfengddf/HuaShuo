package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 生成订单
 * @author MaYunfeng
 *
 */
public class HuaShuoGenerateOrder {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String order(String id1,String id2,String id3) {
		System.out.println("查询购物车全部商品");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();

			ResultSet res = sta.executeQuery("SELECT * FROM HuaShuoShoppingCart");

			String strQuery = "";
			int i = 0;
			while(res.next()) {
				//获取数据库中账号 并赋值
				String id =  res.getString("id");
				if(id.equals(id1) || id.equals(id2) ||id.equals(id3)) {
					//获取数据库中密码 并赋值
					String name =  res.getString("name");
					String model =  res.getString("model");
					String price =  res.getString("price");
					String quantity =  res.getString("Quantity");

					System.out.println("商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + quantity +"\r\n");
					strQuery += "商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + quantity +"\r\n";
					int y = Integer.valueOf(price);
					i += y;
				}
			}
			System.out.println("查询结束 一共" + i + "元");
			
			return "查询购物车全部商品\n" + strQuery + "查询结束  一共" + i + "元";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
