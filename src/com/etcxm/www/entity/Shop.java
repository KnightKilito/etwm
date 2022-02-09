package com.etcxm.www.entity;

public class Shop {
	private Integer id;
	private String shopName;
	private String shopKeeper;
	private String address;
	private String connectPhone;
	private double avgPrice;
	private String shopPicFile;
	private double shopStar;
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopKeeper() {
		return shopKeeper;
	}
	public void setShopKeeper(String shopKeeper) {
		this.shopKeeper = shopKeeper;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConnectPhone() {
		return connectPhone;
	}
	public void setConnectPhone(String connectPhone) {
		this.connectPhone = connectPhone;
	}
	
	public String getShopPicFile() {
		return shopPicFile;
	}
	public void setShopPicFile(String shopPicFile) {
		this.shopPicFile = shopPicFile;
	}
	
	public double getShopStar() {
		return shopStar;
	}
	public void setShopStar(double shopStar) {
		this.shopStar = shopStar;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(Integer id, String shopName, String shopKeeper, String address, String connectPhone, double avgPrice,
			String shopPicFile, double shopStar) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.shopKeeper = shopKeeper;
		this.address = address;
		this.connectPhone = connectPhone;
		this.avgPrice = avgPrice;
		this.shopPicFile = shopPicFile;
		this.shopStar = shopStar;
	}
	
	

	
	
}
