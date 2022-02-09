package com.etcxm.www.service;

import java.util.List;

import com.etcxm.www.entity.Shop;

public interface ShopService {
	public List<Shop> findAll();		//读取所有店铺
	public boolean add(Shop shop);	//新增店铺
	public boolean update(Shop shop);	//更新店铺
	public boolean delete(int id);		//删除店铺
	public Shop findById(int id);	//查询单条店铺
	public List<Shop> findByShopNamePage(String shopName,int pageNum, int pageSize);	//模糊查询
	public List<Shop> findByShopPrice(double lowPrice,double highPrice);	//根据平均消费价格范围搜索产品
	public List<Shop> findAllShopByPage(int pageNum,int pageSize);
	public int count();		//统计记录个数
	public int countFindByShopName(String shopName);
	public List<Shop> findAllShopByShopkeeper(String shopkeepername, int pageNum, int pageSize);
	public int countFindByUserName(String realname);
}
