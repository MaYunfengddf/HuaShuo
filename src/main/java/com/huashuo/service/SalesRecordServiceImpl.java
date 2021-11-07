package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.SalesRecordDto;
import com.huashuo.mapper.SalesRecordMapper;

@Service
public class SalesRecordServiceImpl implements SalesRecordService {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	public SalesRecordMapper salesRecordMapper;
	
	public String write(String alls) {
		//自动获取数据库id
		SalesRecordServiceImpl salesRecordServiceImpl = new SalesRecordServiceImpl();
		String id = salesRecordServiceImpl.idPrice();
		//自动获取当前时间
		String time = salesRecordServiceImpl.time();
      
		
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setId(id);
		salesRecord.setTime(time);
		salesRecord.setAlls(alls);
		
		int cart = salesRecordMapper.insert(salesRecord);
		System.out.println(cart);
		return "添加成功:" + cart + "条信息";
	}
	
	public String delete(String id) {
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setId(id);
		
		int cart = salesRecordMapper.delete(salesRecord);
		System.out.println(cart);
		return "删除成功:" + cart + "条信息";
	}
	
	public String modify(String alls,String id) {
		SalesRecordDto salesRecord = new SalesRecordDto();
		salesRecord.setAlls(alls);
		salesRecord.setId(id);
		
		int cart = salesRecordMapper.update(salesRecord);
		System.out.println(cart);
		return "修改成功:" + cart + "条信息";
	}
	
	public String inquiry() {
		List<SalesRecordDto> cart = salesRecordMapper.findAll();
		System.out.println(cart);
		
		String str = String.valueOf(cart);
		return str;
	}
	
	//获取ID并实现自增
	public String idPrice() {
		try {
			String id = "";
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement sta = conn.createStatement();
			ResultSet res = sta.executeQuery("select * from HUASHUOSALESRECORD  order by id");

			while(res.next()) {
				id =  res.getString("id");
			}
			int id2 = Integer.valueOf(id);
			int id3 = ++id2;
			
			String id4 = String.valueOf(id3);
			
			return id4;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//自动获取当前时间
	public String time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());
		 System.out.println("自动获取当前时间" + time);// new Date()为获取当前系统时间
		 return time;
	}
	
}
