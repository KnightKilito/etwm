package com.etcxm.www.service.impl;

import java.util.List;

import com.etcxm.www.dao.ShopCarProductDAO;
import com.etcxm.www.dao.impl.ShopCarProductDAOImpl;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopCarProductService;

public class ShopCarProductServiceImpl implements ShopCarProductService {

	private ShopCarProductDAO shopCarProductDAO = new ShopCarProductDAOImpl();

	@Override
	public List<ShopProduct> findAll(int userId, String shopName) {
		return shopCarProductDAO.findAll(userId, shopName);
	}

	public List<ShopProduct> findAllHistory(int userId, String shopName) {
		return shopCarProductDAO.findAllHistory(userId, shopName);
	}

	public List<ShopProduct> findAllHistory(String shopName) {
		return shopCarProductDAO.findAllHistory(shopName);
	}

	@Override
	public boolean add(int userId, String shopName, ShopProduct shopProduct) {
		int i = shopCarProductDAO.insert(userId, shopName, shopProduct);
		return i == 1 ? true : false; // 三元表达式，i==1？ 是返回true，否返回false
	}

	public boolean insertHistory(int userId, String shopName, List<ShopProduct> list) {
		int i = shopCarProductDAO.insertHistory(userId, shopName, list);
		return i == 1 ? false : true; // 三元表达式，i==1？ 是返回true，否返回false
	}

	@Override
	public boolean delete(int userId, String shopName, int id) {
		int i = shopCarProductDAO.delete(shopName, id);
		return i == 1 ? true : false;
	}

	public boolean deleteHistory(int userId, String shopName, int id) {
		int i = shopCarProductDAO.deleteHistory(shopName, id);
		return i == 1 ? true : false;
	}

	@Override
	public ShopProduct findById(int userId, String shopName, int id) {
		return shopCarProductDAO.findById(userId, shopName, id);
	}

	@Override
	public int count(int userId, String shopName) {
		return shopCarProductDAO.count(userId, shopName);
	}

	public int countHistory(int userId, String shopName) {
		return shopCarProductDAO.countHistory(userId, shopName);
	}
	public int countHistory(String shopName){
		return shopCarProductDAO.countHistory(shopName);
	}

	@Override
	public double settleShopCar(int userId, String shopName) {
		// TODO Auto-generated method stub
		return shopCarProductDAO.settleShopCar(userId, shopName);
	}

	@Override
	public boolean wipeShopCar(int userId, String shopName) {
		// TODO Auto-generated method stub
		int i = shopCarProductDAO.wipeShopCar(userId, shopName);
		return i == 1 ? true : false;
	}

}
