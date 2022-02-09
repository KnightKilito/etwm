package com.etcxm.www.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.www.dao.ShopProductDAO;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.utils.DBUtil;

public class ShopProductDAOImpl implements ShopProductDAO{

	//操作数据库的工具类，实例化
		private DBUtil dbUtil=new DBUtil();			//Spring会在框架阶段托管这些实例的类

		//新增店铺产品
		@Override
		public int insert(String shopName,ShopProduct shopProduct) {
			//System.out.println(shopName);
			String sql="insert into "+shopName+"_product(product_name,product_price,product_introduction,product_pic_file,product_star) values(?,?,?,?,?)";
			int i=dbUtil.update(sql, shopProduct.getProductName(),shopProduct.getProductPrice(),shopProduct.getProductIntroduction(),shopProduct.getProductPicFile(),shopProduct.getProductStar());
			return i;
		}

		//修改店铺产品
		@Override
		public int update(String shopName,ShopProduct shopProduct) {
			String sql="update "+shopName+"_product set product_name=?,product_price=?,product_introduction=?,product_pic_file=?,product_star=? where id=?";
			int i=dbUtil.update(sql, shopProduct.getProductName(),shopProduct.getProductPrice(),shopProduct.getProductIntroduction(),shopProduct.getProductPicFile(),shopProduct.getProductStar(),shopProduct.getId());
			return i;
		}

		//删除店铺产品
		@Override
		public int delete(String shopName,int id) {
			String sql="delete from "+shopName+"_product where id=?";
			int i=dbUtil.update(sql, id);
			return i;
		}

		//查询所有店铺产品
		@Override
		public List<ShopProduct> findAll(String shopName) {
			String sql="select * from "+shopName+"_product";	//准备sql语句
			ResultSet resultSet=dbUtil.query(sql);	//执行查询
			//封装结果到实体列表。
			List<ShopProduct> list=new ArrayList<ShopProduct>();		//实例列表，用来存储Product实体。
			//循环遍历结果集（ResultSet）将实体添加到列表中
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopProductName = resultSet.getString("product_name");
					double shopProductPrice = resultSet.getDouble("product_price");
					String shopProductIntroduction = resultSet.getString("product_introduction");
					String shopProductPicFile=resultSet.getString("product_pic_file");
					double shopProductStar = resultSet.getDouble("product_star");
					ShopProduct shopProduct=new ShopProduct(id, shopProductName, shopProductPrice, shopProductIntroduction, shopProductPicFile,shopProductStar,null,null,null,null,null,null);
					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		//根据id，查找单条产品信息
		@Override
		public ShopProduct findById(String shopName,int id) {
			String sql="select * from "+shopName+"_product where id=?";	//准备sql语句
			ResultSet resultSet=dbUtil.query(sql,id);	//执行查询
			ShopProduct shopProduct=null;
			//循环遍历结果集（ResultSet）将实体添加到列表中
			try {
				while(resultSet.next()){
					String shopProductName = resultSet.getString("product_name");
					double shopProductPrice = resultSet.getDouble("product_price");
					String shopProductIntroduction = resultSet.getString("product_introduction");
					String shopProductPicFile=resultSet.getString("product_pic_file");
					double shopProductStar = resultSet.getDouble("product_star");
					shopProduct=new ShopProduct(id, shopProductName, shopProductPrice, shopProductIntroduction, shopProductPicFile,shopProductStar,null,null,null,null,null,null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return shopProduct;
		}

		//通过名字模糊查询
		@Override
		public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int start, int pageSize) {
			String sql="select * from "+shopName+"_product where product_name like ? order by id limit ?,?";	//准备sql语句
			shopProductName="%"+shopProductName+"%";
			ResultSet resultSet=dbUtil.query(sql,shopProductName,start,pageSize);	//执行查询
			//封装结果到实体列表。
			List<ShopProduct> list=new ArrayList<ShopProduct>();		//实例列表，用来存储Product实体。
			//循环遍历结果集（ResultSet）将实体添加到列表中
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopProductNameEtc = resultSet.getString("product_name");
					double shopProductPrice = resultSet.getDouble("product_price");
					String shopProductIntroduction = resultSet.getString("product_introduction");
					String shopProductPicFile=resultSet.getString("product_pic_file");
					double shopProductStar = resultSet.getDouble("product_star");
					ShopProduct shopProduct=new ShopProduct(id, shopProductNameEtc, shopProductPrice, shopProductIntroduction, shopProductPicFile,shopProductStar,null,null,null,null,null,null);
					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public List<ShopProduct> findByShopProductPrice(String shopName,double lowPrice, double highPrice) {

			String sql="select * from "+shopName+"_product where product_price between ? and ?";
			ResultSet resultSet = dbUtil.query(sql, lowPrice, highPrice);
			List<ShopProduct> list=new ArrayList<ShopProduct>();
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopProductNameEtc = resultSet.getString("product_name");
					double shopProductPrice = resultSet.getDouble("product_price");
					String shopProductIntroduction = resultSet.getString("product_introduction");
					String shopProductPicFile=resultSet.getString("product_pic_file");
					double shopProductStar = resultSet.getDouble("product_star");
					ShopProduct shopProduct=new ShopProduct(id, shopProductNameEtc, shopProductPrice, shopProductIntroduction, shopProductPicFile,shopProductStar,null,null,null,null,null,null);
					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public List<ShopProduct> findAllShopProductByPage(String shopName,int start, int pageSize) {

			String sql="select * from "+shopName+"_product order by id limit ?,?";
			ResultSet resultSet=dbUtil.query(sql, start, pageSize);
			List<ShopProduct> list=new ArrayList<ShopProduct>();
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopProductNameEtc = resultSet.getString("product_name");
					double shopProductPrice = resultSet.getDouble("product_price");
					String shopProductIntroduction = resultSet.getString("product_introduction");
					String shopProductPicFile=resultSet.getString("product_pic_file");
					double shopProductStar = resultSet.getDouble("product_star");
					ShopProduct shopProduct=new ShopProduct(id, shopProductNameEtc, shopProductPrice, shopProductIntroduction, shopProductPicFile,shopProductStar,null,null,null,null,null,null);
					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public int count(String shopName) {
			String sql="select count(*) from "+shopName+"_product";
			System.out.println(sql);
			ResultSet resultSet = dbUtil.query(sql);
			int allCount=0;
			try {
				while(resultSet.next()){
					allCount=resultSet.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return allCount;
		}

		@Override
		public int countFindByShopProductName(String shopName,String shopProductName) {
			String sql="select count(*) from "+shopName+"_product where product_name like ? ";	//准备sql语句
			shopProductName="%"+shopProductName+"%";
			ResultSet resultSet=dbUtil.query(sql,shopName);	//执行查询
			int allCount=0;
			try {
				while(resultSet.next()){
					allCount=resultSet.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return allCount;
		}
		
		
		
}
