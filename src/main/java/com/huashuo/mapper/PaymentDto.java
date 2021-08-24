package com.huashuo.mapper;

public class PaymentDto {
	
	private String id;
	private String name;
	private String model;
	private String price;
	private String quantity;
	
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "{id = " + this.id + ", name = " + this.name + ", model = " + this.model + ", price = " + this.price +", quantity = " + this.quantity +"}\r\n";
	}
}
