package com.etcxm.www.service.impl;

import java.util.List;


import com.etcxm.www.dao.ShopDAO;
import com.etcxm.www.dao.impl.ShopDAOImpl;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.service.ShopService;

public class ShopServiceImpl implements ShopService{

	private ShopDAO shopDAO=new ShopDAOImpl();

	@Override
	public List<Shop> findAll() {
		return shopDAO.findAll();
	}

	@Override
	public boolean add(Shop shop) {
		int i = shopDAO.insert(shop);
		return i==1?true:false;			//三元表达式，i==1？ 是返回true，否返回false
	}

	@Override
	public boolean update(Shop shop) {
		int i=shopDAO.update(shop);
		return i==1?true:false;
	}

	@Override
	public boolean delete(int id) {
		int i=shopDAO.delete(id);
		return i==1?true:false;
	}

	@Override
	public Shop findById(int id) {
		return shopDAO.findById(id);
	}

	@Override
	public List<Shop> findByShopNamePage(String shopName,int pageNum, int pageSize) {
		int start=(pageNum-1)*pageSize;
		return shopDAO.findByShopNamePage(shopName,start, pageSize);
	}

	@Override
	public List<Shop> findByShopPrice(double lowPrice, double highPrice) {
		return shopDAO.findByShopPrice(lowPrice,highPrice);
	}

	@Override
	public List<Shop> findAllShopByPage(int pageNum, int pageSize) {
		
		int start=(pageNum-1)*pageSize;		//根据页数计算开始的记录条数是多少
		return shopDAO.findAllShopByPage(start, pageSize);
		
	}
	public List<Shop> findAllShopByShopkeeper(String shopkeepername, int pageNum, int pageSize){
		int start=(pageNum-1)*pageSize;		//根据页数计算开始的记录条数是多少
		return shopDAO.findAllShopByShopkeeper(shopkeepername,start, pageSize);
	}

	@Override
	public int count() {
		return shopDAO.count();
	}

	@Override
	public int countFindByShopName(String shopName) {
		// TODO Auto-generated method stub
		return shopDAO.countFindByShopName(shopName);
	}

	@Override
	public int countFindByUserName(String realname) {
		// TODO Auto-generated method stub
		return shopDAO.countFindByUserName(realname);
	}

	
}
