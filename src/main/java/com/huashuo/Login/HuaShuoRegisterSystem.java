package com.huashuo.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 华硕注册系统
 * @author MaYunfeng
 *
 */
public class HuaShuoRegisterSystem {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public String registerSystem(String account,String password) {
		System.out.println("华硕注册系统");
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			sta.execute("INSERT INTO HUASHUOSIGNIN VALUES(" +account + "," + password + ");");
			System.out.println("写入成功");
			return "写入成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
