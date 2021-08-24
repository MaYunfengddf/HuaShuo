package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 华硕商品维护 删
 * @author MaYunfeng
 *
 */
public class HuaShuoAllGoodsDelete {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	/**
	 * 华硕商品删除
	 * @param str1
	 * @return
	 */
	public String delete(String str1) {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("删除商品信息");
			
			int id = Integer.valueOf(str1);
			Statement sta = conn.createStatement();          
			sta.executeUpdate("DELETE FROM HUASHUOALLGOODS WHERE ID=" + id + ";");
			
			System.out.println("删除总商品成功");;
			return "删除总商品成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("删除总商品失败");
		}
		return null;
	}
}
