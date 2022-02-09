package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.ShopProduct;

public interface ShopCarProductDAO {
		//新增产品接口
		public int insert(int userId,String shopName,ShopProduct shopProduct);
		public int insertHistory(int userId, String shopName, List<ShopProduct> list);
		
		//删除产品的接口
		public int delete(String shopName,int id);
		public int deleteHistory(String shopName,int id);
		//读取所有产品接口
		public List<ShopProduct> findAll(int userId,String shopName);
		public List<ShopProduct> findAllHistory(int userId,String shopName);
		public List<ShopProduct> findAllHistory(String shopName);
		//根据id读取单条产品信息
		public ShopProduct findById(int userId,String shopName,int id);
		
		//可以根据项目的需要，添加新的接口
		//根据产品你名称，模糊查询
		//根据价格查询产品
		
		//分页查询
		
		//统计所有记录条数
		public int count(int userId,String shopName);
		public int countHistory(int userId,String shopName);
		public int countHistory(String shopName);
		//结算购物车
		public double settleShopCar(int userId,String shopName);
		
		public int wipeShopCar(int userId, String shopName);
}
