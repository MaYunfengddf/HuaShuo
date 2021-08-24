package com.huashuo.mapper;

public class CustomerInputDto {
	private String id;
	private String name;
	private String purchaseQuantity;
	private String purchasePrice;
	private String purchaseModel;
	
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
	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchaseModel() {
		return purchaseModel;
	}
	public void setPurchaseModel(String purchaseModel) {
		this.purchaseModel = purchaseModel;
	}
	
	@Override
	public String toString() {
		return "{id = " + this.id + ", name = " + this.name + ", purchaseQuantity = " + this.purchaseQuantity + ", purchaseModel = " + this.purchaseModel + ", purchaseModel = " + this.purchaseModel +"}\r\n";
	}
}
