package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 获取数据库ID
 * 购物车信息
 * @author MaYunfeng
 *
 */
public class HuaShuoIdPrice {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private String id;

	public String idPrice() {

		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HuaShuoShoppingCart");

			while(res.next()) {
				//获取数据库中账号 并赋值
				id =  res.getString("id");
				//获取数据库中密码 并赋值
				System.out.print("id:" + id);
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
