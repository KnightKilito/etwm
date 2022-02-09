package com.etcxm.www.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.etcxm.www.dao.ShopCarProductDAO;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.entity.User;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;
import com.etcxm.www.service.impl.UserServiceImpl;
import com.etcxm.www.utils.DBUtil;

public class ShopCarProductDAOImpl implements ShopCarProductDAO {

	// �������ݿ�Ĺ����࣬ʵ����
	private DBUtil dbUtil = new DBUtil(); // Spring���ڿ�ܽ׶��й���Щʵ������

	// ������Ʒ�����ﳵ
	@Override
	public int insert(int userId, String shopName, ShopProduct shopProduct) {
		String sql = "insert into " + shopName
				+ "_shopCar(product_id,product_name,product_price,guest_id) values(?,?,?,?)";
		int i = dbUtil.update(sql, shopProduct.getId(), shopProduct.getProductName(), shopProduct.getProductPrice(),
				userId);
		return i;
	}

	public int insertHistory(int userId, String shopName, List<ShopProduct> list) {
		int i = 0;
		UserService userService = new UserServiceImpl();
		User user = userService.findById(userId);
		for (int j = 0; j < list.size(); j++) {
			String sql = "insert into " + shopName
					+ "_shopCar_history(product_id,product_name,product_price,guest_id,order_id,addressee,phone,address) values(?,?,?,?,?,?,?,?)";
			i = dbUtil.update(sql, list.get(j).getId(), list.get(j).getProductName(), list.get(j).getProductPrice(),
					userId, user.getOrderId(),user.getRealname(),user.getPhone(),user.getAddress());
		}

		return i;
	}

	// ɾ�����ﳵ��Ʒ
	@Override
	public int delete(String shopName, int id) {
		String sql = "delete from " + shopName + "_shopCar where id=?";
		int i = dbUtil.update(sql, id);
		return i;
	}

	public int deleteHistory(String shopName, int id) {
		String sql = "delete from " + shopName + "_shopCar_history where id=?";
		int i = dbUtil.update(sql, id);
		return i;
	}

	// ��ѯ���й��ﳵ��Ʒ
	@Override
	public List<ShopProduct> findAll(int userId, String shopName) {
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // ʵ���б������洢Productʵ�塣
		if (shopName == null || shopName == "") {// �����������shopNameΪ��������и��û������е��̵Ķ���չʾ����
			String sqlsearchshop = "select * from shop";
			try {
				ResultSet shopNameResultSet = dbUtil.query(sqlsearchshop); // ִ�в�ѯ
				while (shopNameResultSet.next()) {
					shopName = shopNameResultSet.getString("shop_name");
					String sql = "select * from " + shopName + "_shopCar where guest_id=" + userId; // ׼��sql���
					ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
					// ��װ�����ʵ���б�

					// ѭ�������������ResultSet����ʵ����ӵ��б���

					while (resultSet.next()) {

						int productId = resultSet.getInt("product_id");
						ShopProductService shopProductService = new ShopProductServiceImpl();
						ShopProduct shopProduct = shopProductService.findById(shopName, productId);// ���ݴ������Ʒid���Ҷ�Ӧ����Ϣ����shopproduct������Ҫ���������½�һ��ר�ŵ�shopcarproduct����
						int id = resultSet.getInt("id");// ��ȡ���ﳵ�д洢�ĸĲ�Ʒ�ڹ��ﳵ�е����
						shopProduct.setShopCarProductId(id);// �����shopproduct����ֵ���ﳵ�е����

						list.add(shopProduct);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
		} else {

			String sql = "select * from " + shopName + "_shopCar where guest_id=" + userId; // ׼��sql���
			ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
			// ��װ�����ʵ���б�

			// ѭ�������������ResultSet����ʵ����ӵ��б���
			try {
				while (resultSet.next()) {
					int productId = resultSet.getInt("product_id");
					ShopProductService shopProductService = new ShopProductServiceImpl();
					ShopProduct shopProduct = shopProductService.findById(shopName, productId);
					int id = resultSet.getInt("id");
					shopProduct.setShopCarProductId(id);// ����Ʒ�ڹ��ﳵ�е�λ��id������delete��

					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
		}
		return list;
	}

	public List<ShopProduct> findAllHistory(int userId, String shopName) {
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // ʵ���б������洢Productʵ�塣
		if (shopName == null || shopName == "") {// �����������shopNameΪ��������и��û������е��̵Ķ���չʾ����
			String sqlsearchshop = "select * from shop";
			try {
				ResultSet shopNameResultSet = dbUtil.query(sqlsearchshop); // ִ�в�ѯ
				while (shopNameResultSet.next()) {
					shopName = shopNameResultSet.getString("shop_name");
					String sql = "select * from " + shopName + "_shopCar_history where guest_id=" + userId; // ׼��sql���
					ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
					// ��װ�����ʵ���б�

					// ѭ�������������ResultSet����ʵ����ӵ��б���

					while (resultSet.next()) {
						int productId = resultSet.getInt("product_id");
						ShopProductService shopProductService = new ShopProductServiceImpl();
						ShopProduct shopProduct = shopProductService.findById(shopName, productId);// ���ݴ������Ʒid���Ҷ�Ӧ����Ϣ����shopproduct������Ҫ���������½�һ��ר�ŵ�shopcarproduct����
						int id = resultSet.getInt("id");// ��ȡ���ﳵ�д洢�ĸĲ�Ʒ�ڹ��ﳵ�е����
						shopProduct.setShopCarProductId(id);// �����shopproduct����ֵ���ﳵ�е����
						int orderId = resultSet.getInt("order_id");// �����������Ķ������
						shopProduct.setShopCarOrderId(orderId);
						String addressee=resultSet.getString("addressee");
						String phone=resultSet.getString("phone");
						String address=resultSet.getString("address");
						int guestId=resultSet.getInt("guest_id");
						shopProduct.setAddressee(addressee);
						shopProduct.setPhone(phone);
						shopProduct.setAddress(address);
						shopProduct.setGuestId(guestId);
						
						list.add(shopProduct);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
		} else {

			String sql = "select * from " + shopName + "_shopCar_history where guest_id=" + userId; // ׼��sql���
			ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
			// ��װ�����ʵ���б�

			// ѭ�������������ResultSet����ʵ����ӵ��б���
			try {
				while (resultSet.next()) {
					int productId = resultSet.getInt("product_id");
					ShopProductService shopProductService = new ShopProductServiceImpl();
					ShopProduct shopProduct = shopProductService.findById(shopName, productId);// ���ݴ������Ʒid���Ҷ�Ӧ����Ϣ����shopproduct������Ҫ���������½�һ��ר�ŵ�shopcarproduct����
					int id = resultSet.getInt("id");// ��ȡ���ﳵ�д洢�ĸĲ�Ʒ�ڹ��ﳵ�е����
					shopProduct.setShopCarProductId(id);// �����shopproduct����ֵ���ﳵ�е����
					int orderId = resultSet.getInt("order_id");// �����������Ķ������
					shopProduct.setShopCarOrderId(orderId);
					String addressee=resultSet.getString("addressee");
					String phone=resultSet.getString("phone");
					String address=resultSet.getString("address");
					int guestId=resultSet.getInt("guest_id");
					shopProduct.setAddressee(addressee);
					shopProduct.setPhone(phone);
					shopProduct.setAddress(address);
					shopProduct.setGuestId(guestId);
					
					list.add(shopProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
		}
		return list;
	}

	public List<ShopProduct> findAllHistory(String shopName) {//����ֻ��һ��shopName��ר�Ÿ��̼��õ�
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // ʵ���б������洢Productʵ�塣

		try {

			String sql = "select * from " + shopName + "_shopCar_history GROUP BY id, order_id"; // ׼��sql���
			ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
			// ��װ�����ʵ���б�

			// ѭ�������������ResultSet����ʵ����ӵ��б���

			while (resultSet.next()) {

				int productId = resultSet.getInt("product_id");
				ShopProductService shopProductService = new ShopProductServiceImpl();
				ShopProduct shopProduct = shopProductService.findById(shopName, productId);// ���ݴ������Ʒid���Ҷ�Ӧ����Ϣ����shopproduct������Ҫ���������½�һ��ר�ŵ�shopcarproduct����
				int id = resultSet.getInt("id");// ��ȡ���ﳵ�д洢�ĸĲ�Ʒ�ڹ��ﳵ�е����
				shopProduct.setShopCarProductId(id);// �����shopproduct����ֵ���ﳵ�е����
				int orderId = resultSet.getInt("order_id");// �����������Ķ������
				shopProduct.setShopCarOrderId(orderId);
				String addressee=resultSet.getString("addressee");
				String phone=resultSet.getString("phone");
				String address=resultSet.getString("address");
				int guestId=resultSet.getInt("guest_id");
				shopProduct.setAddressee(addressee);
				shopProduct.setPhone(phone);
				shopProduct.setAddress(address);
				shopProduct.setGuestId(guestId);
				
				list.add(shopProduct);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}

		return list;
	}

	// ����id�����ҵ�����Ʒ��Ϣ
	@Override
	public ShopProduct findById(int userId, String shopName, int id) {
		String sql = "select * from " + shopName + "_shopCar where id=? and guest_id=" + userId; // ׼��sql���
		ResultSet resultSet = dbUtil.query(sql, id); // ִ�в�ѯ
		ShopProduct shopProduct = null;
		// ѭ�������������ResultSet����ʵ����ӵ��б���
		try {
			while (resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				ShopProductService shopProductService = new ShopProductServiceImpl();
				shopProduct = shopProductService.findById(shopName, productId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return shopProduct;
	}

	@Override
	public int count(int userId, String shopName) {
		String sql = "select count(*) from " + shopName + "_shopCar where guest_id=" + userId;
		ResultSet resultSet = dbUtil.query(sql);
		int allCount = 0;
		try {
			while (resultSet.next()) {
				allCount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return allCount;
	}

	public int countHistory(int userId, String shopName) {
		String sql = "select count(*) from " + shopName + "_shopCar_history where guest_id=" + userId;
		ResultSet resultSet = dbUtil.query(sql);
		int allCount = 0;
		try {
			while (resultSet.next()) {
				allCount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return allCount;
	}
	public int countHistory(String shopName) {
		String sql = "select count(*) from " + shopName + "_shopCar_history";
		ResultSet resultSet = dbUtil.query(sql);
		int allCount = 0;
		try {
			while (resultSet.next()) {
				allCount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return allCount;
	}

	@Override
	public double settleShopCar(int userId, String shopName) {
		double totalPrice = 0;
		String sql = "select sum(product_price) as totalprice from " + shopName + "_shopCar where guest_id=" + userId; // ׼��sql���
		ResultSet resultSet = dbUtil.query(sql); // ִ�в�ѯ
		// ѭ�������������ResultSet����ʵ����ӵ��б���
		try {
			while (resultSet.next()) {
				totalPrice = resultSet.getDouble("totalprice");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
		}
		return totalPrice;
	}

	@Override
	public int wipeShopCar(int userId, String shopName) {
		// TODO Auto-generated method stub
		String sql = "delete from " + shopName + "_shopCar where guest_id=" + userId; // ׼��sql���
		int i = dbUtil.update(sql);
		return i;
	}

}
