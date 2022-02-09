package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;

public interface ShopService {
	public List<Shop> findAll();		//��ȡ���е���
	public boolean add(Shop shop);	//��������
	public boolean update(Shop shop);	//���µ���
	public boolean delete(int id);		//ɾ������
	public Shop findById(int id);	//��ѯ��������
	public List<Shop> findByShopNamePage(String shopName,int pageNum, int pageSize);	//ģ����ѯ
	public List<Shop> findByShopPrice(double lowPrice,double highPrice);	//����ƽ�����Ѽ۸�Χ������Ʒ
	public List<Shop> findAllShopByPage(int pageNum,int pageSize);
	public int count();		//ͳ�Ƽ�¼����
	public int countFindByShopName(String shopName);
	public List<Shop> findAllShopByShopkeeper(String shopkeepername, int pageNum, int pageSize);
	public int countFindByUserName(String realname);
}
