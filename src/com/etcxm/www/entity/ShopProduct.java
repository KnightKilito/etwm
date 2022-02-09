package com.etcxm.www.entity;

import java.io.Serializable;

// µÃÂ¿‡
public class ShopProduct implements Serializable {

	private Integer id;
	
	private String productName;
	private Double productPrice;
	private String productIntroduction;
	private String productPicFile;
	private Double productStar;
	private Integer shopCarProductId;
	private Integer shopCarOrderId;
	private String addressee; 
	private String phone; 
	private String address; 
	private Integer guestId;

	public ShopProduct(Integer id, String productName, Double productPrice, String productIntroduction,
			String productPicFile, Double productStar, Integer shopCarProductId, Integer shopCarOrderId,
			String addressee, String phone, String address, Integer guestId) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productIntroduction = productIntroduction;
		this.productPicFile = productPicFile;
		this.productStar = productStar;
		this.shopCarProductId = shopCarProductId;
		this.shopCarOrderId = shopCarOrderId;
		this.addressee = addressee;
		this.phone = phone;
		this.address = address;
		this.guestId = guestId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductIntroduction() {
		return productIntroduction;
	}

	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}

	public String getProductPicFile() {
		return productPicFile;
	}

	public void setProductPicFile(String productPicFile) {
		this.productPicFile = productPicFile;
	}

	public Double getProductStar() {
		return productStar;
	}

	public void setProductStar(Double productStar) {
		this.productStar = productStar;
	}

	public Integer getShopCarProductId() {
		return shopCarProductId;
	}

	public void setShopCarProductId(Integer shopCarProductId) {
		this.shopCarProductId = shopCarProductId;
	}

	public Integer getShopCarOrderId() {
		return shopCarOrderId;
	}

	public void setShopCarOrderId(Integer shopCarOrderId) {
		this.shopCarOrderId = shopCarOrderId;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
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

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public ShopProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
