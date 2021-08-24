package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 全部商品销售记录维护 查
 * @author MaYunfeng
 *
 */
public class HuaShuoSalesRecordInquiry {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String inquiry() {
		System.out.println("查询全部商品销售记录");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();

			ResultSet res = sta.executeQuery("SELECT * FROM HuaShuoSalesRecord");
			
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
			return "查询全部商品销售记录\n" + strQuery + "查询结束";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
