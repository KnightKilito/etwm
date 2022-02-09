package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.ShopProduct;

public interface ShopCarProductDAO {
		//������Ʒ�ӿ�
		public int insert(int userId,String shopName,ShopProduct shopProduct);
		public int insertHistory(int userId, String shopName, List<ShopProduct> list);
		
		//ɾ����Ʒ�Ľӿ�
		public int delete(String shopName,int id);
		public int deleteHistory(String shopName,int id);
		//��ȡ���в�Ʒ�ӿ�
		public List<ShopProduct> findAll(int userId,String shopName);
		public List<ShopProduct> findAllHistory(int userId,String shopName);
		public List<ShopProduct> findAllHistory(String shopName);
		//����id��ȡ������Ʒ��Ϣ
		public ShopProduct findById(int userId,String shopName,int id);
		
		//���Ը�����Ŀ����Ҫ������µĽӿ�
		//���ݲ�Ʒ�����ƣ�ģ����ѯ
		//���ݼ۸��ѯ��Ʒ
		
		//��ҳ��ѯ
		
		//ͳ�����м�¼����
		public int count(int userId,String shopName);
		public int countHistory(int userId,String shopName);
		public int countHistory(String shopName);
		//���㹺�ﳵ
		public double settleShopCar(int userId,String shopName);
		
		public int wipeShopCar(int userId, String shopName);
}
