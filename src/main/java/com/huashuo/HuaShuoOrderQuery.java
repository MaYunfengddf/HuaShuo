package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 华硕客户
 * 订单记录查询
 * @author MaYunfeng
 *CREATE TABLE HuaShuoSignIn(Account INT PRIMARY KEY,
   Password int(18));
 */
public class HuaShuoOrderQuery {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String shoppingCartQuery() {
		System.out.println("查询购物车全部商品");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();

			ResultSet res = sta.executeQuery("SELECT * FROM HuaShuoOrderQuery");

			String strQuery = "";
			while(res.next()) {
				//获取数据库中账号 并赋值
				String id =  res.getString("id");

				//获取数据库中密码 并赋值
				String name =  res.getString("name");
				String model =  res.getString("model");
				String price =  res.getString("price");
				String quantity =  res.getString("Quantity");

				System.out.println("商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + quantity +"\r\n");
				strQuery += "商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + quantity +"\r\n";
			}
			System.out.println("查询结束");
			return "查询购物车全部商品\n" + strQuery + "查询结束";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}