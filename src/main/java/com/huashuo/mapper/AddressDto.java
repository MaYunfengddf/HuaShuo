package com.huashuo.mapper;

public class AddressDto {
	private String id;
	private String accountd;//账号
	private String phone;//手机号
	private String address;//收件地址
	private String name;//收件人姓名
	private String default2;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountd() {
		return accountd;
	}
	public void setAccountd(String accountd) {
		this.accountd = accountd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefault2() {
		return default2;
	}
	public void setDefault2(String default2) {
		this.default2 = default2;
	}
	
	@Override
	public String toString() {
		return 	"{ id:" + this.id + 
				",  accountd : " + this.accountd + 
				",  手机号: " + this.phone + 
				",  收件人地址: " + this.address + 
				", 收件人名字: " + this.name +  
				", 1不是默认地址 2是默认地址: " + this.default2 + 
				" } ";
	}
}
