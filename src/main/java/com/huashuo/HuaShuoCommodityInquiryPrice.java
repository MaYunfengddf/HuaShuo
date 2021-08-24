package com.huashuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *  华硕客户
 * 商品price 价格查询
 * @author MaYunfeng
 *
 */
public class HuaShuoCommodityInquiryPrice {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	//4查询商品价格
	public String queryPrice(String str1,String str2) {
		System.out.println("查询商品价格");
		//判断输入最小为数字
		boolean boo1 = false;

		//判断输入最大为数字
		boolean boo2 = false;
		//标记循环次数
		int i = 1;
		int y = 1;
		for (char c : str1.toCharArray()) {
			if(Character.isDigit(c)) {
				System.out.println("判断第" + i++ + "位为: 数字");
				boo1 = true;
			}else {
				System.out.println("判断第" + i++ + "位为: 其他字符 请重新输入");
				//如输入的有一次不为数字 结束该次循环
				boo1 = false;
				return "非数字";
			}
		}

		for (char c : str2.toCharArray()) {
			if(Character.isDigit(c)) {
				System.out.println("判断第" + y++ + "位为: 数字");
				boo2 = true;
			}else {
				System.out.println("判断第" + y++ + "位为: 其他字符 请重新输入");
				//如输入的有一次不为数字 结束该次循环
				boo2 = false;
				return "非数字";
			}
		}
		//判断输入的最小值 和最大值都为数字
		if(boo1 && boo2) {
			try {
				Class.forName(DRIVER_CLASS);
				Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
				Statement sta = conn.createStatement();
				//最低
				int pri1 = Integer.valueOf(str1);
				//最高
				int pri2= Integer.valueOf(str2);
				ResultSet res = sta.executeQuery("select *from HUASHUOALLGOODS where price  between "+ pri1 + " and " + pri2 +"; ");

				String strPrice = "";
				while(res.next()){
					//获取数据库中账号 并赋值
					String id =  res.getString("id");
					//获取数据库中密码 并赋值

					String name =  res.getString("name");
					String model =  res.getString("model");
					String price =  res.getString("price");
					String InventoryQuantity =  res.getString("InventoryQuantity");
					System.out.println("商品编号:" + id + " \r\n 商品名称:" + name + "\r\n 商品型号:" + model + " \r\n 商品价格:" + price + " \r\n 商品库存:" + InventoryQuantity +"\r\n");
					strPrice +="商品编号:" + id + " \r\n <br>商品名称:" + name + "\r\n <br>商品型号:" + model + " \r\n <br>商品价格:" + price + " \r\n <br>商品库存:" + InventoryQuantity +"\r\n<br><br>";
				}
				return strPrice;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}