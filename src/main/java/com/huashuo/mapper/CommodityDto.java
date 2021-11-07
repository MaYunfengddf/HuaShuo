package com.huashuo.mapper;

public class CommodityDto {
	private String id;//编号
	private String name;//名字
	private String images;//名字
	private String model;//型号
	private String price;//价格
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "{id = " + this.id + ", name = " + this.name +  ", images = " + this.images +", model = " + this.model + ", price = " + this.price +"}\r\n<br>";
	}
}
