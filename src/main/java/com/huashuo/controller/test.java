package com.huashuo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test { 
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	public static void main(String[] args) {
		try {
			String id = "";
			boolean boo = true;
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HUASHUOADDRESS order by accountd");
			while(res.next()) {
				id =  res.getString("accountd");
				System.out.println(id);
				if("12345".equals(id) && boo == true) {
					System.out.println("找到");
					boo = false;
				}else {
					System.out.println("未找到");
				}
			}
			if(boo == true) {
				System.out.println("未找到2");
			}else {
				System.out.println("找到2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
