package com.etcxm.www.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.www.dao.ShopProductDAO;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.utils.DBUtil;

public class ShopProductDAOImpl implements ShopProductDAO{

	//�������ݿ�Ĺ����࣬ʵ����
		private DBUtil dbUtil=new DBUtil();			//Spring���ڿ�ܽ׶��й���Щʵ������

		//�������̲�Ʒ
		@Override
		public int insert(String shopName,ShopProduct shopProduct) {
			//System.out.println(shopName);
			String sql="insert into "+shopName+"_product(product_name,product_price,product_introduction,product_pic_file,product_star) values(?,?,?,?,?)";
			int i=dbUtil.update(sql, shopProduct.getProductName(),shopProduct.getProductPrice(),shopProduct.getProductIntroduction(),shopProduct.getProductPicFile(),shopProduct.getProductStar());
			return i;
		}

		//�޸ĵ��̲�Ʒ
		@Override
		public int update(String shopName,ShopProduct shopProduct) {
			String sql="update "+shopName+"_product set product_name=?,product_price=?,product_introduction=?,product_pic_file=?,product_star=? where id=?";
			int i=dbUtil.update(sql, shopProduct.getProductName(),shopProduct.getProductPrice(),shopProduct.getProductIntroduction(),shopProduct.getProductPicFile(),shopProduct.getProductStar(),shopProduct.getId());
			return i;
		}

		//ɾ�����̲�Ʒ
		@Override
		public int delete(String shopName,int id) {
			String sql="delete from "+shopName+"_product where id=?";
			int i=dbUtil.update(sql, id);
			return i;
		}

		//��ѯ���е��̲�Ʒ
		@Override
		public List<ShopProduct> findAll(String shopName) {
			String sql="select * from "+shopName+"_product";	//׼��sql���
			ResultSet resultSet=dbUtil.query(sql);	//ִ�в�ѯ
			//��װ�����ʵ���б�
			List<ShopProduct> list=new ArrayList<ShopProduct>();		//ʵ���б������洢Productʵ�塣
			//ѭ�������������ResultSet����ʵ����ӵ��б���
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

		//����id�����ҵ�����Ʒ��Ϣ
		@Override
		public ShopProduct findById(String shopName,int id) {
			String sql="select * from "+shopName+"_product where id=?";	//׼��sql���
			ResultSet resultSet=dbUtil.query(sql,id);	//ִ�в�ѯ
			ShopProduct shopProduct=null;
			//ѭ�������������ResultSet����ʵ����ӵ��б���
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

		//ͨ������ģ����ѯ
		@Override
		public List<ShopProduct> findByShopProductNamePage(String shopName,String shopProductName,int start, int pageSize) {
			String sql="select * from "+shopName+"_product where product_name like ? order by id limit ?,?";	//׼��sql���
			shopProductName="%"+shopProductName+"%";
			ResultSet resultSet=dbUtil.query(sql,shopProductName,start,pageSize);	//ִ�в�ѯ
			//��װ�����ʵ���б�
			List<ShopProduct> list=new ArrayList<ShopProduct>();		//ʵ���б������洢Productʵ�塣
			//ѭ�������������ResultSet����ʵ����ӵ��б���
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
			String sql="select count(*) from "+shopName+"_product where product_name like ? ";	//׼��sql���
			shopProductName="%"+shopProductName+"%";
			ResultSet resultSet=dbUtil.query(sql,shopName);	//ִ�в�ѯ
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
