package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 购物车维护 增
 * 华硕购物车信息
 * @author MaYunfeng
 */
public class HuaShuoShoppingCartInput {

	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String shoppingCartInput(String str1,String str2,String str3,String str4) {
		HuaShuoIdPrice huaShuoIdPrice = new HuaShuoIdPrice();
		int id = Integer.valueOf(huaShuoIdPrice.idPrice());

		try {
			int in1 = Integer.valueOf(str3);

			int in2 = Integer.valueOf(str4);

			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);


			Statement sta = conn.createStatement();
			sta.execute("INSERT INTO HuaShuoShoppingCart VALUES("+ ++id + ",'" + str1 + "','" + str2 + "'," + in1 + "," + in2 + ");");
			System.out.println("写入购物车库成功");
			return "写入购物车成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入购物车失败");
		}
		return null;
	}
}
