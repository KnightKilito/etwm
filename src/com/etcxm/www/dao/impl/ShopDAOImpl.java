package com.etcxm.www.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.www.dao.ShopDAO;
import com.etcxm.www.entity.Shop;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopServiceImpl;
import com.etcxm.www.utils.DBUtil;

public class ShopDAOImpl implements ShopDAO{

	//�������ݿ�Ĺ����࣬ʵ����
		private DBUtil dbUtil=new DBUtil();			//Spring���ڿ�ܽ׶��й���Щʵ������

		//��������
		@Override
		public int insert(Shop shop) {
			String sql="insert into shop(shop_name,shopkeeper,shop_address,connect_phone,avg_price,shop_pic_file,shop_star) values(?,?,?,?,?,?,?)";
			int i=dbUtil.update(sql, shop.getShopName(),shop.getShopKeeper(),shop.getAddress(),shop.getConnectPhone(),shop.getAvgPrice(),shop.getShopPicFile(),shop.getShopStar());
			if(i==1) {
				String creat_product="CREATE TABLE IF NOT EXISTS `"+shop.getShopName()+"_product`  (\r\n"
						+ "  `id` int(0) NOT NULL AUTO_INCREMENT,\r\n"
						+ "  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,\r\n"
						+ "  `product_price` decimal(10, 2) NOT NULL,\r\n"
						+ "  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\r\n"
						+ "  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,\r\n"
						+ "  `product_star` decimal(10, 2) NULL DEFAULT NULL,\r\n"
						+ "  `shopcar_product_id` int(0) NULL DEFAULT NULL,\r\n"
						+ "  PRIMARY KEY (`id`) USING BTREE,\r\n"
						+ "  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE\r\n"
						+ ") ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;";
				dbUtil.update(creat_product);
				
				String creat_shopcar="CREATE TABLE IF NOT EXISTS `"+shop.getShopName()+"_shopcar`  (\r\n"
						+ "  `id` int(0) NOT NULL AUTO_INCREMENT,\r\n"
						+ "  `product_id` int(0) NOT NULL,\r\n"
						+ "  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,\r\n"
						+ "  `product_price` decimal(10, 2) NOT NULL,\r\n"
						+ "  `guest_id` int(0) NULL DEFAULT NULL,\r\n"
						+ "  PRIMARY KEY (`id`) USING BTREE\r\n"
						+ ") ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;";
				dbUtil.update(creat_shopcar);
				
				String creat_shopcar_history="CREATE TABLE `"+shop.getShopName()+"_shopcar_history`  (\r\n"
						+ "  `id` int(0) NOT NULL AUTO_INCREMENT,\r\n"
						+ "  `product_id` int(0) NOT NULL,\r\n"
						+ "  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,\r\n"
						+ "  `product_price` decimal(10, 2) NOT NULL,\r\n"
						+ "  `guest_id` int(0) NULL DEFAULT NULL,\r\n"
						+ "  `order_id` int(0) NULL DEFAULT NULL,\r\n"
						+ "  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\r\n"
						+ "  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\r\n"
						+ "  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\r\n"
						+ "  PRIMARY KEY (`id`) USING BTREE\r\n"
						+ ") ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;";
				dbUtil.update(creat_shopcar_history);
			}
			return i;
		}

		//�޸ĵ���
		@Override
		public int update(Shop shop) {
			ShopService shopService=new ShopServiceImpl();
			//�ȸ��ݲ���ĵ���id�ļ������ﳵ����Ʒ��������ٸ�shop�����������
			Shop shop2=shopService.findById(shop.getId());
			String sql_product="RENAME TABLE "+shop2.getShopName()+"_product TO "+shop.getShopName()+"_product";
			String sql_shopcar="RENAME TABLE "+shop2.getShopName()+"_shopcar TO "+shop.getShopName()+"_shopcar";
			String sql_shopcar_history="RENAME TABLE "+shop2.getShopName()+"_shopcar_history TO "+shop.getShopName()+"_shopcar_history";
			
			String sql="update shop set shop_name='"+shop.getShopName()
					+ "',shopkeeper='"+shop.getShopKeeper()
					+ "',shop_address='"+shop.getAddress()
					+ "',connect_phone='"+shop.getConnectPhone()
					+ "',avg_price="+shop.getAvgPrice()
					+ ",shop_pic_file='"+shop.getShopPicFile()
					+ "',shop_star="+shop.getShopStar()
					+ " where id="+shop.getId();
//			System.out.println(sql);
//			System.out.println(sql_product);
//			System.out.println(sql_shopcar);
//			System.out.println(sql_shopcar_history);
			dbUtil.update(sql_product);
			dbUtil.update(sql_shopcar);
			dbUtil.update(sql_shopcar_history);
			
			int i=dbUtil.update(sql);
			
			
			
			
			return i;
		}

		//ɾ������
		@Override
		public int delete(int id) {
			
			ShopService shopService=new ShopServiceImpl();
			Shop shop=shopService.findById(id);
			String delet_product="DROP TABLE "+shop.getShopName()+"_product";
			dbUtil.update(delet_product);
			String delet_shopcar="DROP TABLE "+shop.getShopName()+"_shopcar";
			dbUtil.update(delet_shopcar);
			String delet_shopcar_history="DROP TABLE "+shop.getShopName()+"_shopcar_history";
			dbUtil.update(delet_shopcar_history);
			String sql="delete from shop where id=?";
			int i=dbUtil.update(sql, id);
			return i;
		}

		//��ѯ���е���
		@Override
		public List<Shop> findAll() {
			String sql="select * from shop";	//׼��sql���
			ResultSet resultSet=dbUtil.query(sql);	//ִ�в�ѯ
			//��װ�����ʵ���б�
			List<Shop> list=new ArrayList<Shop>();		//ʵ���б������洢Productʵ�塣
			//ѭ�������������ResultSet����ʵ����ӵ��б���
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopName = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					Shop shop=new Shop(id, shopName, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}
		
		
		

		//����id�����ҵ���������Ϣ
		@Override
		public Shop findById(int id) {
			String sql="select * from shop where id=?";	//׼��sql���
			ResultSet resultSet=dbUtil.query(sql,id);	//ִ�в�ѯ
			Shop shop=null;
			//ѭ�������������ResultSet����ʵ����ӵ��б���
			try {
				while(resultSet.next()){
					String shopName = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					shop=new Shop(id, shopName, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return shop;
		}

		//ͨ������ģ����ѯ
		@Override
		public List<Shop> findByShopNamePage(String shopName,int start, int pageSize) {
			String sql="select * from shop where shop_name like ? order by id limit ?,?";	//׼��sql���
			shopName="%"+shopName+"%";
			ResultSet resultSet=dbUtil.query(sql,shopName,start,pageSize);	//ִ�в�ѯ
			//��װ�����ʵ���б�
			List<Shop> list=new ArrayList<Shop>();		//ʵ���б������洢Productʵ�塣
			//ѭ�������������ResultSet����ʵ����ӵ��б���
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopNameEtc = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					Shop shop=new Shop(id, shopNameEtc, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public List<Shop> findByShopPrice(double lowPrice, double highPrice) {

			String sql="select * from shop where avg_price between ? and ?";
			ResultSet resultSet = dbUtil.query(sql, lowPrice, highPrice);
			List<Shop> list=new ArrayList<Shop>();
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopNameEtc = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					Shop shop=new Shop(id, shopNameEtc, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public List<Shop> findAllShopByPage(int start, int pageSize) {

			String sql="select * from shop order by id limit ?,?";
			ResultSet resultSet=dbUtil.query(sql, start, pageSize);
			List<Shop> list=new ArrayList<Shop>();
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopNameEtc = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					Shop shop=new Shop(id, shopNameEtc, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}

		@Override
		public int count() {
			String sql="select count(*) from shop";
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
		public int countFindByShopName(String shopName) {
			String sql="select count(*) from shop where shop_name like ? ";	//׼��sql���
			shopName="%"+shopName+"%";
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
		
		@Override
		public int countFindByUserName(String realname) {
			String sql="select count(*) from shop where shopkeeper = '"+realname+"'";	//׼��sql���
			//realname="'"+realname+"'";
			ResultSet resultSet=dbUtil.query(sql);	//ִ�в�ѯ
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
		public List<Shop> findAllShopByShopkeeper(String shopkeepername,int start, int pageSize) {

			String sql="select * from shop where shopkeeper='"+shopkeepername+"' order by id limit ?,?";
//			System.out.println(shopkeepername);
//			shopkeepername="'"+shopkeepername+"'";
//			System.out.println(shopkeepername);
			ResultSet resultSet=dbUtil.query(sql, start, pageSize);
			List<Shop> list=new ArrayList<Shop>();
			try {
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					String shopNameEtc = resultSet.getString("shop_name");
					String shopkeeper = resultSet.getString("shopkeeper");
					String shopAddress = resultSet.getString("shop_address");
					String connectPhone = resultSet.getString("connect_phone");
					double avgPrice = resultSet.getDouble("avg_price");
					String shopPicFile=resultSet.getString("shop_pic_file");
					double shopStar = resultSet.getDouble("shop_star");
					Shop shop=new Shop(id, shopNameEtc, shopkeeper, shopAddress, connectPhone,avgPrice,shopPicFile,shopStar);
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				dbUtil.close();
			}
			return list;
		}
		
		
		
		
		
}
