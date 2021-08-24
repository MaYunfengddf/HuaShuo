package com.huashuo.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 登录验证系统
 * @author MaYunfeng
 *
 */
public class HuaShuoLoginSystem {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private static HuaShuoLoginSystem huaShuoLoginSystem = new HuaShuoLoginSystem();

	public boolean loginSystem(String account,String password) {
		System.out.println("登录系统");

		String accountPassword = huaShuoLoginSystem.queryH2();
		String[] strMap = accountPassword.split(",");

		if(strMap[0].equals(account) && strMap[1].equals(password)) {
			System.out.println("登录成功");
			return true;
		}else {
			System.out.println("登录失败 请重新登录");
			return false;
		}
	}
	public String queryH2() {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("SELECT * FROM  HUASHUOSIGNIN");
			String str = "";
			System.out.println("查询账号密码开始");
			while(res.next()){
				//获取数据库中账号 并赋值
				String account =  res.getString("account");

				//获取数据库中密码 并赋值
				String password =  res.getString("password");
				System.out.println("账户:" + account + " \r\n 密码:" + password + "\r\n");
				str = account +"," + password;
			}
			System.out.println("查询账号密码结束");
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
