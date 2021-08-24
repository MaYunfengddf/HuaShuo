package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 购物车维护 删
 * @author MaYunfeng
 *
 */
public class HuaShuoShoppingCartDelete {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	//删除商品ID
	public String delete(String str) {
		HuaShuoShoppingCartQuery huaShuoShoppingCartQuery = new HuaShuoShoppingCartQuery();
		huaShuoShoppingCartQuery.shoppingCartQuery();
		System.out.println("删除商品ID");
		int in = Integer.valueOf(str);
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			sta.executeUpdate("DELETE FROM HuaShuoShoppingCart WHERE ID=" + in + ";");
			System.out.println("删除成功");
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}