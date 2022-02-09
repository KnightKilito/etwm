package com.etcxm.www.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private Integer id;
	private String username;
	private String password;
	private String realname;
	private String phone;
	private String type;
	private String address;
	private Integer orderId;
	private String picFile;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getPicFile() {
		return picFile;
	}
	public void setPicFile(String picFile) {
		this.picFile = picFile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, String password, String realname, String phone, String type,
			String address, Integer orderId, String picFile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.phone = phone;
		this.type = type;
		this.address = address;
		this.orderId = orderId;
		this.picFile = picFile;
	}

}
