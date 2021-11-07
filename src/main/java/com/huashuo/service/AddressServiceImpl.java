package com.huashuo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuo.mapper.AddressDto;
import com.huashuo.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService{
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/D:/H2/01kuaixue";
	private static final String USER = "01";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	
	@Autowired
	private AddressMapper addressMapper;
	
		//收件地址 增
		public boolean input(String accountd,String phone,String address,String name) {

			boolean boo = true;
			AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
			String id = addressServiceImpl.idPrice();
			
			AddressDto addressDto = new AddressDto();
			addressDto.setId(id);
			addressDto.setAccountd(accountd);
			addressDto.setPhone(phone);
			addressDto.setAddress(address);
			addressDto.setName(name);
			
			//判断该账号是否为第一次添加新地址
			try {
				String id2 = "";
				Class.forName(DRIVER_CLASS);
				Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
				Statement sta = conn.createStatement();
				ResultSet res = sta.executeQuery("select * from HUASHUOADDRESS order by accountd");
				while(res.next()) {
					id2 =  res.getString("accountd");
					System.out.println(id2);
					if(accountd.equals(id2) && boo == true) {
						System.out.println("找到");
						boo = false;
					}else {
						System.out.println("未找到");
					}
				}
				if(boo == true) {
					//未找到 就把该账号第一次添加的地址设为默认
					addressDto.setDefault2("2");
				}else {
					//找到了 赋值为非默认
					addressDto.setDefault2("1");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int cart = addressMapper.insert(addressDto);
			System.out.println(cart);
			return true;
		}
		
		//收件地址 删
		public boolean delete(String id) {
			AddressDto addressDto = new AddressDto();
			addressDto.setId(id);
			
			int cart = addressMapper.delete(addressDto);
			System.out.println(cart);
			return true;
		}
		
		//收件地址 改
		public boolean modify(String phone,String address,String name,String id) {
			AddressDto addressDto = new AddressDto();
			addressDto.setPhone(phone);
			addressDto.setAddress(address);
			addressDto.setName(name);
			addressDto.setId(id);
			
			int cart = addressMapper.update(addressDto);
			System.out.println(cart);
			return true;
		}
		//修改默认地址
		public boolean modify2(String default2,String id) {
			AddressDto addressDto = new AddressDto();
			addressDto.setDefault2(default2);
			addressDto.setId(id);
			
			int cart = addressMapper.update2(addressDto);
			System.out.println(cart);
			return true;
		}
		//收件地址 查
		public List<AddressDto> query(String accountd) {
			AddressDto addressDto = new AddressDto();
			addressDto.setAccountd(accountd);
			
			List<AddressDto> cart = addressMapper.findAll(addressDto);
			System.out.println(cart);
			return cart;
		}
		//收件地址 查  管理员
		public List<AddressDto> query() {
			List<AddressDto> cart = addressMapper.findAll2();
			System.out.println(cart);
			return cart;
		}
		
		//获取ID并实现自增
		public String idPrice() {
			try {
				String id = "";
				Class.forName(DRIVER_CLASS);
				Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
				Statement sta = conn.createStatement();
				ResultSet res = sta.executeQuery("select * from huashuoaddress order by id");

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
}
