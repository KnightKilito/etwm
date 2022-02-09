package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopProductDAO {
	//新增产品接口
		public int insert(String shopName,ShopProduct shopProduct);
		//修改产品接口
		public int update(String shopName,ShopProduct shopProduct);
		//删除产品的接口
		public int delete(String shopName,int id);
		//读取所有产品接口
		public List<ShopProduct> findAll(String shopName);
		//根据id读取单条产品信息
		public ShopProduct findById(String shopName,int id);
		
		//可以根据项目的需要，添加新的接口
		//根据产品你名称，模糊查询
		public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int start, int pageSize);
		//根据价格查询产品
		public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice, double highPrice);
		
		//分页查询
		public List<ShopProduct> findAllShopProductByPage(String shopName,int start,int pageSize);
		
		//统计所有记录条数
		public int count(String shopName);
		
		//统计根据名字查到的结果条数
		public int countFindByShopProductName(String shopName,String shopProductName);
		
		
}
