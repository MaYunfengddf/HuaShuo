package com.huashuo.mapper;

public class CustomerInputDto {
	private String id;
	private String accounta;
	private String name;
	private String aaa;
	
	private String accountc;//名字
	private String time;//时间
	private String key;//对应全部商品 键
	
	private String model;//型号
	private String colour;//颜色
	private String size;//屏幕尺寸
	private String price;//价格
	private String images;//图片
	private String quantity;//库存
	private String type;//定位
	private String processor;//处理器
	private String memory;//内存
	private String harddisk;//硬盘
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccounta() {
		return accounta;
	}
	public void setAccounta(String accounta) {
		this.accounta = accounta;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAaa() {
		return aaa;
	}
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}
	public String getAccountc() {
		return accountc;
	}
	public void setAccountc(String accountc) {
		this.accountc = accountc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getHarddisk() {
		return harddisk;
	}
	public void setHarddisk(String harddisk) {
		this.harddisk = harddisk;
	}
	@Override
	public String toString() {
		return "{id : " + this.id + 
				", 客户账号 : "+ this.accounta  +
				", 客户名字 : " + this.name  +
				", 客户名字 : " + this.aaa  +
				", 账号:" + this.accountc +
				", 时间:"+this.time +
				", 名字:" + this.key +  
				
				", 型号:" + this.model + 
				", 颜色:" + this.colour + 
				", 屏幕尺寸:" + this.size +  
				", 价格:" + this.price + 
				", 图片:" + this.images + 
				", 库存:" + this.quantity +
				", 定位:" + this.type +
				",处理器:"+this.processor + 
				", 内存:" + this.memory +  
				", 硬盘:" + this.harddisk +
				"}";
	}
}
