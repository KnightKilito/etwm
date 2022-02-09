package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.Shop;

public interface ShopDAO {
	//新增产品接口
		public int insert(Shop product);
		//修改产品接口
		public int update(Shop product);
		//删除产品的接口
		public int delete(int id);
		//读取所有产品接口
		public List<Shop> findAll();
		//根据id读取单条产品信息
		public Shop findById(int id);
		
		//可以根据项目的需要，添加新的接口
		//根据产品你名称，模糊查询
		public List<Shop> findByShopNamePage(String shopName,int start, int pageSize);
		//根据价格查询产品
		public List<Shop> findByShopPrice(double lowPrice, double highPrice);
		
		//分页查询
		public List<Shop> findAllShopByPage(int start,int pageSize);
		
		//统计所有记录条数
		public int count();
		
		//统计根据名字查到的结果条数
		public int countFindByShopName(String shopName);
		public int countFindByUserName(String realname);
		public List<Shop> findAllShopByShopkeeper(String shopkeepername, int start, int pageSize);
}
