package com.huashuo.Administrators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 客户信息维护 增 
 * @author MaYunfeng
 *
 */
public class HuaShouCustomerWrite {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private String id;

	/**
	 * 写入数据库信息
	 * id  序号
	 * @param str2  客户名字
	 * @param str3	购买数量
	 * @param str4	商品单价格
	 * @param str5	商品型号
	 * @return
	 */
	public String write(String str2,String str3,String str4,String str5) {
		HuaShouCustomerWrite huaShouCustomerWrite =new HuaShouCustomerWrite();

		String str1 = huaShouCustomerWrite.idPrice();
		try {

			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

			int id = Integer.valueOf(str1);
			int quantity = Integer.valueOf(str3);
			int price = Integer.valueOf(str4);
			Statement sta = conn.createStatement();           //编号 名字  数量  价格  型号
			sta.execute("INSERT INTO HuaShuoCustomerInquiry VALUES("+ ++id + ",'" + str2 + "'," + quantity + "," + price + ",'" + str5 + "');");
			System.out.println("写入H2数据库成功");
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
			ResultSet res = sta.executeQuery("select * from HuaShuoCustomerInquiry");

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
