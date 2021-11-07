package com.huashuo.mapper;

public class AllGoodsDto {
	private String id;
	private String name;//名字
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
	private String num;//硬盘

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
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return 	"{ id:" + this.id + 
				",  名字: " + this.name +  
				", 型号: " + this.model + 
				", 颜色: " + this.colour + 
				", 屏幕尺寸: " + this.size +  
				", 价格: " + this.price + 
				", 图片: " + this.images + 
				", 库存: " + this.quantity +
				", 定位: " + this.type +
				",处理器: "+this.processor + 
				", 内存: " + this.memory +  
				", 硬盘: " + this.harddisk + 
				", num: " + this.num + " } ";
	}
}
