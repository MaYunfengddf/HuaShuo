package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 客户信息维护 查
 * @author MaYunfeng
 *
 */
public class HuaShouCustomerInquiry {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String inquiry() {
		System.out.println("查询所有客户信息");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();

			ResultSet res = sta.executeQuery("SELECT * FROM HuaShuoCustomerInquiry");
			
			String strQuery = "";
			while(res.next()) {
				//获取数据库中账号 并赋值
				String id =  res.getString("id");

				//获取数据库中密码 并赋值
				String name =  res.getString("name");
				String quantity =  res.getString("PurchaseQuantity");
				String price =  res.getString("PurchasePrice");
				String model =  res.getString("PurchaseModel");
				

				System.out.println("记录编号:" + id + " \r\n 客户姓名:" + name + " \r\n 购买数量:" + quantity + " \r\n 商品单价格:" + price + "\r\n 商品型号:" + model + "\r\n");
				strQuery += "记录编号:" + id + " \r\n 客户姓名:" + name + " \r\n 购买数量:" + quantity + " \r\n 商品单价格:" + price + "\r\n 商品型号:" + model + "\r\n";
			}
			System.out.println("查询结束");
			return "查询购物车全部商品\n" + strQuery + "查询结束";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
