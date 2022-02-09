package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopProductService {
	public List<ShopProduct> findAll(String shopName);		//��ȡ���е��̲�Ʒ
	public boolean add(String shopName,ShopProduct shopProduct);	//�������̲�Ʒ
	public boolean update(String shopName,ShopProduct shopProduct);	//���µ��̲�Ʒ
	public boolean delete(String shopName,int id);		//ɾ������
	public ShopProduct findById(String shopName,int id);	//��ѯ��������
	public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int pageNum, int pageSize);	//ģ����ѯ
	public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice,double highPrice);	//����ƽ�����Ѽ۸�Χ������Ʒ
	public List<ShopProduct> findAllShopProductByPage(String shopName,int pageNum,int pageSize);
	public int count(String shopName);		//ͳ�Ƽ�¼����
	
	public int countFindByShopProductName(String shopName,String shopProductName);
}
