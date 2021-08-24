package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 管理员
 * 全部商品销售记录维护 增
 * @author MaYunfeng
 *
 */
public class HuaShuoSalesRecordWrite {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private String id;
	
	public String write(String name,String model,String price,String quantity) {
		HuaShuoSalesRecordWrite huaShuoSalesRecordWrite = new HuaShuoSalesRecordWrite();
		try {

			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

			int id = Integer.valueOf(huaShuoSalesRecordWrite.idPrice());
			int price1 = Integer.valueOf(price);
			int quantity1 = Integer.valueOf(quantity);
			
			Statement sta = conn.createStatement();
			sta.execute("INSERT INTO HuaShuoSalesRecord VALUES("+ ++id + ",'" + name + "','" + model + "'," + price1 + "," + quantity1 + ");");
			System.out.println("写入全部商品成功");
			return "写入全部商品成功";
		}catch(Exception q) {

			q.printStackTrace();
			System.out.println("写入H2数据库失败");
		}
		return null;
	}
	
	/**
	 * 获取数据库ID
	 * 总销售信息
	 * @return
	 */
	public String idPrice() {

		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HuaShuoSalesRecord");

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
