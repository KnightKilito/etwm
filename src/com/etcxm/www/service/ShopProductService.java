package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;

public interface ShopProductService {
	public List<ShopProduct> findAll(String shopName);		//读取所有店铺产品
	public boolean add(String shopName,ShopProduct shopProduct);	//新增店铺产品
	public boolean update(String shopName,ShopProduct shopProduct);	//更新店铺产品
	public boolean delete(String shopName,int id);		//删除店铺
	public ShopProduct findById(String shopName,int id);	//查询单条店铺
	public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int pageNum, int pageSize);	//模糊查询
	public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice,double highPrice);	//根据平均消费价格范围搜索产品
	public List<ShopProduct> findAllShopProductByPage(String shopName,int pageNum,int pageSize);
	public int count(String shopName);		//统计记录个数
	
	public int countFindByShopProductName(String shopName,String shopProductName);
}
