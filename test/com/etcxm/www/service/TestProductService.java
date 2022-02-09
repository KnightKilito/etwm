package com.etcxm.www.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.impl.ProductServiceImpl;



public class TestProductService {
	
	private ProductService productService;
	
	@Before
	public void init(){
		productService=new ProductServiceImpl();
	}
	
	//1. 必须是public
	//2. 不传参数
	@Test
	public void testSave(){
		
		ShopProduct product=new ShopProduct(null, "switch", 2500d,50, "2021-06-04");
		boolean isok = productService.save(product);
		Assert.assertTrue(isok);
		
	}
	
	@Test
	public void testFindAll(){
		
		List<ShopProduct> list = productService.findAll();
		for(ShopProduct product:list){
			System.out.println(product);
		}
		
	}
	
	@Test
	public void testUpdate(){
		System.out.println(productService);
		ShopProduct product = productService.findById(6);
		System.out.println(product);
		product.setProductPdate("2021-05-01");
		product.setProductPrice(2600d);
		product.setProductStore(49);
		
		boolean isok = productService.update(product);
		Assert.assertTrue(isok);
		
	}
	
	@Test
	public void testFindByName(){
		
		String name="ch";
		List<ShopProduct> list = productService.findByProductName(name);
		for(ShopProduct product:list){
			System.out.println(product);
		}
		
	}
	
	@Test
	public void testDelete(){
		
		boolean isok = productService.delete(3);
		Assert.assertTrue(isok);
		
	}
	
	@Test
	public void testFindByProductPrice(){
		
		List<ShopProduct> list = productService.findByProductPrice(1000, 1500);	//包含1000和1500
		for(ShopProduct product:list){
			System.out.println(product);
		}
		
	}
	
	
	

}
