package com.etcxm.www.service.impl;

import java.util.List;


import com.etcxm.www.dao.ShopProductDAO;
import com.etcxm.www.dao.impl.ShopProductDAOImpl;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;

public class ShopProductServiceImpl implements ShopProductService{

	private ShopProductDAO shopProductDAO=new ShopProductDAOImpl();

	@Override
	public List<ShopProduct> findAll(String shopName) {
		return shopProductDAO.findAll(shopName);
	}

	@Override
	public boolean add(String shopName,ShopProduct shopProduct) {
		int i = shopProductDAO.insert(shopName,shopProduct);
		return i==1?true:false;			//三元表达式，i==1？ 是返回true，否返回false
	}

	@Override
	public boolean update(String shopName,ShopProduct shopProduct) {
		int i=shopProductDAO.update(shopName,shopProduct);
		return i==1?true:false;
	}

	@Override
	public boolean delete(String shopName,int id) {
		int i=shopProductDAO.delete(shopName,id);
		return i==1?true:false;
	}

	@Override
	public ShopProduct findById(String shopName,int id) {
		return shopProductDAO.findById(shopName,id);
	}

	@Override
	public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int pageNum, int pageSize) {
		int start=(pageNum-1)*pageSize;
		return shopProductDAO.findByShopProductNamePage(shopName,shopProductName,start, pageSize);
	}

	@Override
	public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice, double highPrice) {
		return shopProductDAO.findByShopProductPrice(shopName,lowPrice,highPrice);
	}

	@Override
	public List<ShopProduct> findAllShopProductByPage(String shopName,int pageNum, int pageSize) {
		
		int start=(pageNum-1)*pageSize;		//根据页数计算开始的记录条数是多少
		return shopProductDAO.findAllShopProductByPage(shopName,start, pageSize);
		
	}

	@Override
	public int count(String shopName) {
		return shopProductDAO.count(shopName);
	}

	@Override
	public int countFindByShopProductName(String shopName,String shopProductName) {
		// TODO Auto-generated method stub
		return shopProductDAO.countFindByShopProductName(shopName,shopProductName);
	}

	

	
}
