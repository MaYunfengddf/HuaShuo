package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 华硕客户
 * 写入全部订单
 * @author MaYunfeng
 *
 */
public class HuaShuoOrderWriting {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private String id;

	/**
	 * 写入数据库信息
	 * 华硕购物记录
	 * @param str1
	 * @param str2
	 */
	public String OrderQuery(String str2,String str3,String str4,String str5) {
		HuaShuoOrderWriting huaShuoOrderQuery =new HuaShuoOrderWriting();

		String str1 = huaShuoOrderQuery.idPrice();
		try {

			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

			int id = Integer.valueOf(str1);
			int price = Integer.valueOf(str4);
			int quantity = Integer.valueOf(str5);
			Statement sta = conn.createStatement();           //编号 名字  型号  价格  数量
			sta.execute("INSERT INTO HuaShuoOrderQuery VALUES("+ ++id + ",'" + str2 + "','" + str3 + "'," + price + "," + quantity + ");");
			System.out.println("写入H2数据库成功");
			System.out.println("写入H2数据库成功后数据库信息如下");
			return "写入H2数据库成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入H2数据库失败");
		}
		return null;
	}
	
	/**
	 * 
	 * 获取数据库ID
	 * 购物历史信息
	 * @return
	 */
	public String idPrice() {

		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HuaShuoOrderQuery");

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
