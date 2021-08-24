package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 华硕客户
 * 商品mode 型号查询
 * @author MaYunfeng
 *
 */
public class HuaShuoCommodityInquiryModel {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	//3查询商品型号
		public String queryModel(String str) {

				try {
					Class.forName(DRIVER_CLASS);
					Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
					Statement sta = conn.createStatement();
					ResultSet res = sta.executeQuery("SELECT * FROM  HUASHUOALLGOODS WHERE model LIKE '%"+ str + "%'");
					
					String strModel = "";
					
					while(res.next()){
						//获取数据库中账号 并赋值
						String id =  res.getString("id");
						//获取数据库中密码 并赋值

						String name =  res.getString("name");
						String model =  res.getString("model");
						String price =  res.getString("price");
						String InventoryQuantity =  res.getString("InventoryQuantity");
						System.out.println("商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + InventoryQuantity +"\r\n");
						strModel += "商品编号:" + id + " \r\n <br> 商品名称:" + name + "\r\n <br> 商品型号:" + model + " \r\n <br> 商品价格:" + price + " \r\n <br> 商品库存:" + InventoryQuantity +"\r\n<br><br>";
					}
					return strModel;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
		}
}
