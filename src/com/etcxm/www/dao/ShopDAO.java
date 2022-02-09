package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.Shop;

public interface ShopDAO {
	//������Ʒ�ӿ�
		public int insert(Shop product);
		//�޸Ĳ�Ʒ�ӿ�
		public int update(Shop product);
		//ɾ����Ʒ�Ľӿ�
		public int delete(int id);
		//��ȡ���в�Ʒ�ӿ�
		public List<Shop> findAll();
		//����id��ȡ������Ʒ��Ϣ
		public Shop findById(int id);
		
		//���Ը�����Ŀ����Ҫ������µĽӿ�
		//���ݲ�Ʒ�����ƣ�ģ����ѯ
		public List<Shop> findByShopNamePage(String shopName,int start, int pageSize);
		//���ݼ۸��ѯ��Ʒ
		public List<Shop> findByShopPrice(double lowPrice, double highPrice);
		
		//��ҳ��ѯ
		public List<Shop> findAllShopByPage(int start,int pageSize);
		
		//ͳ�����м�¼����
		public int count();
		
		//ͳ�Ƹ������ֲ鵽�Ľ������
		public int countFindByShopName(String shopName);
		public int countFindByUserName(String realname);
		public List<Shop> findAllShopByShopkeeper(String shopkeepername, int start, int pageSize);
}
