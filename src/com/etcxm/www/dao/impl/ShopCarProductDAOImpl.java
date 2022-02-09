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

	// 操作数据库的工具类，实例化
	private DBUtil dbUtil = new DBUtil(); // Spring会在框架阶段托管这些实例的类

	// 新增产品到购物车
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

	// 删除购物车产品
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

	// 查询所有购物车产品
	@Override
	public List<ShopProduct> findAll(int userId, String shopName) {
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // 实例列表，用来存储Product实体。
		if (shopName == null || shopName == "") {// 如果传进来的shopName为空则把所有该用户在所有店铺的订单展示出来
			String sqlsearchshop = "select * from shop";
			try {
				ResultSet shopNameResultSet = dbUtil.query(sqlsearchshop); // 执行查询
				while (shopNameResultSet.next()) {
					shopName = shopNameResultSet.getString("shop_name");
					String sql = "select * from " + shopName + "_shopCar where guest_id=" + userId; // 准备sql语句
					ResultSet resultSet = dbUtil.query(sql); // 执行查询
					// 封装结果到实体列表。

					// 循环遍历结果集（ResultSet）将实体添加到列表中

					while (resultSet.next()) {

						int productId = resultSet.getInt("product_id");
						ShopProductService shopProductService = new ShopProductServiceImpl();
						ShopProduct shopProduct = shopProductService.findById(shopName, productId);// 根据储存的商品id查找对应的信息存入shopproduct对象，主要是懒得再新建一个专门的shopcarproduct对象
						int id = resultSet.getInt("id");// 获取购物车中存储的改产品在购物车中的序号
						shopProduct.setShopCarProductId(id);// 给这个shopproduct对象赋值购物车中的序号

						list.add(shopProduct);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtil.close();
			}
		} else {

			String sql = "select * from " + shopName + "_shopCar where guest_id=" + userId; // 准备sql语句
			ResultSet resultSet = dbUtil.query(sql); // 执行查询
			// 封装结果到实体列表。

			// 循环遍历结果集（ResultSet）将实体添加到列表中
			try {
				while (resultSet.next()) {
					int productId = resultSet.getInt("product_id");
					ShopProductService shopProductService = new ShopProductServiceImpl();
					ShopProduct shopProduct = shopProductService.findById(shopName, productId);
					int id = resultSet.getInt("id");
					shopProduct.setShopCarProductId(id);// 该商品在购物车中的位置id，留着delete用

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
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // 实例列表，用来存储Product实体。
		if (shopName == null || shopName == "") {// 如果传进来的shopName为空则把所有该用户在所有店铺的订单展示出来
			String sqlsearchshop = "select * from shop";
			try {
				ResultSet shopNameResultSet = dbUtil.query(sqlsearchshop); // 执行查询
				while (shopNameResultSet.next()) {
					shopName = shopNameResultSet.getString("shop_name");
					String sql = "select * from " + shopName + "_shopCar_history where guest_id=" + userId; // 准备sql语句
					ResultSet resultSet = dbUtil.query(sql); // 执行查询
					// 封装结果到实体列表。

					// 循环遍历结果集（ResultSet）将实体添加到列表中

					while (resultSet.next()) {
						int productId = resultSet.getInt("product_id");
						ShopProductService shopProductService = new ShopProductServiceImpl();
						ShopProduct shopProduct = shopProductService.findById(shopName, productId);// 根据储存的商品id查找对应的信息存入shopproduct对象，主要是懒得再新建一个专门的shopcarproduct对象
						int id = resultSet.getInt("id");// 获取购物车中存储的改产品在购物车中的序号
						shopProduct.setShopCarProductId(id);// 给这个shopproduct对象赋值购物车中的序号
						int orderId = resultSet.getInt("order_id");// 存入他所属的订单编号
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

			String sql = "select * from " + shopName + "_shopCar_history where guest_id=" + userId; // 准备sql语句
			ResultSet resultSet = dbUtil.query(sql); // 执行查询
			// 封装结果到实体列表。

			// 循环遍历结果集（ResultSet）将实体添加到列表中
			try {
				while (resultSet.next()) {
					int productId = resultSet.getInt("product_id");
					ShopProductService shopProductService = new ShopProductServiceImpl();
					ShopProduct shopProduct = shopProductService.findById(shopName, productId);// 根据储存的商品id查找对应的信息存入shopproduct对象，主要是懒得再新建一个专门的shopcarproduct对象
					int id = resultSet.getInt("id");// 获取购物车中存储的改产品在购物车中的序号
					shopProduct.setShopCarProductId(id);// 给这个shopproduct对象赋值购物车中的序号
					int orderId = resultSet.getInt("order_id");// 存入他所属的订单编号
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

	public List<ShopProduct> findAllHistory(String shopName) {//参数只有一个shopName，专门给商家用的
		List<ShopProduct> list = new ArrayList<ShopProduct>(); // 实例列表，用来存储Product实体。

		try {

			String sql = "select * from " + shopName + "_shopCar_history GROUP BY id, order_id"; // 准备sql语句
			ResultSet resultSet = dbUtil.query(sql); // 执行查询
			// 封装结果到实体列表。

			// 循环遍历结果集（ResultSet）将实体添加到列表中

			while (resultSet.next()) {

				int productId = resultSet.getInt("product_id");
				ShopProductService shopProductService = new ShopProductServiceImpl();
				ShopProduct shopProduct = shopProductService.findById(shopName, productId);// 根据储存的商品id查找对应的信息存入shopproduct对象，主要是懒得再新建一个专门的shopcarproduct对象
				int id = resultSet.getInt("id");// 获取购物车中存储的改产品在购物车中的序号
				shopProduct.setShopCarProductId(id);// 给这个shopproduct对象赋值购物车中的序号
				int orderId = resultSet.getInt("order_id");// 存入他所属的订单编号
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

	// 根据id，查找单条产品信息
	@Override
	public ShopProduct findById(int userId, String shopName, int id) {
		String sql = "select * from " + shopName + "_shopCar where id=? and guest_id=" + userId; // 准备sql语句
		ResultSet resultSet = dbUtil.query(sql, id); // 执行查询
		ShopProduct shopProduct = null;
		// 循环遍历结果集（ResultSet）将实体添加到列表中
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
		String sql = "select sum(product_price) as totalprice from " + shopName + "_shopCar where guest_id=" + userId; // 准备sql语句
		ResultSet resultSet = dbUtil.query(sql); // 执行查询
		// 循环遍历结果集（ResultSet）将实体添加到列表中
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
		String sql = "delete from " + shopName + "_shopCar where guest_id=" + userId; // 准备sql语句
		int i = dbUtil.update(sql);
		return i;
	}

}
