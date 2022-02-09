package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopCarProductService {
	public List<ShopProduct> findAll(int userId,String shopName);		//��ȡ���й��ﳵ��Ʒ
	public List<ShopProduct> findAllHistory(int userId,String shopName);		//��ȡ���й��ﳵ��Ʒ
	public List<ShopProduct> findAllHistory(String shopName);
	public boolean add(int userId,String shopName,ShopProduct shopProduct);	//�������ﳵ��Ʒ
	public boolean insertHistory(int userId, String shopName, List<ShopProduct> list);	//�������ﳵ��Ʒ
	public boolean delete(int userId,String shopName,int id);		//ɾ�����ﳵ��Ʒ
	public boolean deleteHistory(int userId,String shopName,int id);		//ɾ�����ﳵ��Ʒ
	public ShopProduct findById(int userId,String shopName,int id);	//��ѯ�������ﳵ
	public int count(int userId,String shopName);		//ͳ�Ƽ�¼����
	public int countHistory(int userId,String shopName);		//ͳ�Ƽ�¼����
	public int countHistory(String shopName);
	public double settleShopCar(int userId,String shopName);
	public boolean wipeShopCar(int userId,String shopName);
}
