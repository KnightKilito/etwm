package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopCarProductService {
	public List<ShopProduct> findAll(int userId,String shopName);		//读取所有购物车产品
	public List<ShopProduct> findAllHistory(int userId,String shopName);		//读取所有购物车产品
	public List<ShopProduct> findAllHistory(String shopName);
	public boolean add(int userId,String shopName,ShopProduct shopProduct);	//新增购物车产品
	public boolean insertHistory(int userId, String shopName, List<ShopProduct> list);	//新增购物车产品
	public boolean delete(int userId,String shopName,int id);		//删除购物车产品
	public boolean deleteHistory(int userId,String shopName,int id);		//删除购物车产品
	public ShopProduct findById(int userId,String shopName,int id);	//查询单条购物车
	public int count(int userId,String shopName);		//统计记录个数
	public int countHistory(int userId,String shopName);		//统计记录个数
	public int countHistory(String shopName);
	public double settleShopCar(int userId,String shopName);
	public boolean wipeShopCar(int userId,String shopName);
}
