package com.etcxm.www.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.etcxm.www.dao.impl.ProductDAOImpl;
import com.etcxm.www.entity.ShopProduct;

public class TestProductDAO {
	
	private ProductDAO productDAO;
	
	@Before		//该注解可以在test测试之前执行
	public void init(){
		productDAO=new ProductDAOImpl();		//鸟=企鹅Oracle 鸟=鸵鸟Mysql--->Spring
	}
	
	@Test	//该注解，声明了该方法是个单元测试用例
	public void testFindAll(){
		List<ShopProduct> list = productDAO.findAll();
		for(ShopProduct product:list){
			System.out.println(product);
		}
	}
	
	//新增产品测试
	@Test
	public void testInsert(){
		//模拟一条新的产品数据
		ShopProduct product=new ShopProduct(null, "Switch", 2400d, 100, "2020-05-31");
		int i=productDAO.insert(product);
		Assert.assertEquals(1, i);
	}
	
	//更新产品测试
	@Test
	public void testUpdate(){
		//读取单条记录
		ShopProduct product=productDAO.findById(2);
		product.setProductPrice(2500d);		//修改该记录的价格
		int i=productDAO.update(product);	//提交更新
		Assert.assertEquals(1, i);		//断言结果为1
	}
	
	//删除产品测试
	@Test
	public void testDelete(){
		int i=productDAO.delete(2);
		Assert.assertEquals(1, i);
	}
	
	//模糊查询测试
	@Test
	public void testFindByProductName(){
		String name="p";
		List<ShopProduct> list = productDAO.findByProductName(name);
		for(ShopProduct product:list){
			System.out.println(product);
		}
	}
	
	@Test
	public void testCount(){
		int i=productDAO.count();
		Assert.assertEquals(i, 9);
	}

}
