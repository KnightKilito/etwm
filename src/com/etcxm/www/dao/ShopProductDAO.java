package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopProductDAO {
	//������Ʒ�ӿ�
		public int insert(String shopName,ShopProduct shopProduct);
		//�޸Ĳ�Ʒ�ӿ�
		public int update(String shopName,ShopProduct shopProduct);
		//ɾ����Ʒ�Ľӿ�
		public int delete(String shopName,int id);
		//��ȡ���в�Ʒ�ӿ�
		public List<ShopProduct> findAll(String shopName);
		//����id��ȡ������Ʒ��Ϣ
		public ShopProduct findById(String shopName,int id);
		
		//���Ը�����Ŀ����Ҫ������µĽӿ�
		//���ݲ�Ʒ�����ƣ�ģ����ѯ
		public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int start, int pageSize);
		//���ݼ۸��ѯ��Ʒ
		public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice, double highPrice);
		
		//��ҳ��ѯ
		public List<ShopProduct> findAllShopProductByPage(String shopName,int start,int pageSize);
		
		//ͳ�����м�¼����
		public int count(String shopName);
		
		//ͳ�Ƹ������ֲ鵽�Ľ������
		public int countFindByShopProductName(String shopName,String shopProductName);
		
		
}
