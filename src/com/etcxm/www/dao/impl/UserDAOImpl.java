package com.etcxm.www.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.etcxm.www.dao.UserDAO;
import com.etcxm.www.entity.User;
import com.etcxm.www.utils.DBUtil;

public class UserDAOImpl implements UserDAO{
	
	private DBUtil dbUtil=new DBUtil();

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findById(int id) {
		String sql="select * from user where id=?";
		ResultSet resultSet = dbUtil.query(sql, id);
		User ruser=null;
		try {
			while(resultSet.next()){
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				String realname=resultSet.getString("realname");
				String phone=resultSet.getString("phone");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				String orderId=resultSet.getString("order_id");
				int iorderId=Integer.parseInt(orderId);
				String PicFile=resultSet.getString("pic_file");
				ruser=new User();
				ruser.setId(id);
				ruser.setUsername(username);
				ruser.setPassword(password);
				ruser.setRealname(realname);
				ruser.setPhone(phone);
				ruser.setType(type);
				ruser.setAddress(address);
				ruser.setOrderId(iorderId);
				ruser.setPicFile(PicFile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			dbUtil.close();
		}
		return ruser;
	}
	
	
	
	@Override
	public User findByUsernameAndPassword(User user) {
		String sql="select * from user where username=? and password=? and type=?";
		ResultSet resultSet = dbUtil.query(sql, user.getUsername(),user.getPassword(),user.getType());
		User ruser=null;
		try {
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String username=resultSet.getString("username");
				String realname=resultSet.getString("realname");
				String phone=resultSet.getString("phone");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				String orderId=resultSet.getString("order_id");
				int iorderId=Integer.parseInt(orderId);
				String PicFile=resultSet.getString("pic_file");
				ruser=new User();
				ruser.setId(id);
				ruser.setUsername(username);
				ruser.setRealname(realname);
				ruser.setPhone(phone);
				ruser.setType(type);
				ruser.setAddress(address);
				ruser.setOrderId(iorderId);
				ruser.setPicFile(PicFile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			dbUtil.close();
		}
		return ruser;
	}
	public int insert(User user){
		String sql = "insert into user(username,password,realname,phone,type,address,order_id,pic_file) values(?,?,?,?,?,?,?,?)";
		int i = dbUtil.update(sql, user.getUsername(),user.getPassword(),user.getRealname(),user.getPhone(),user.getType(),user.getAddress(),1,user.getPicFile());
		return i;
	}
	public int authUsername(String username,String type) {
		int r=0;
		String sql="select count(*) from user where username=? and type=?";
		ResultSet resultSet = dbUtil.query(sql, username,type);
		try {
			while(resultSet.next()){
				r=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			dbUtil.close();
		}
		return r;
	}
	public int authUsername(String username) {
		int r=0;
		String sql="select count(*) from user where username=? ";
		ResultSet resultSet = dbUtil.query(sql, username);
		try {
			while(resultSet.next()){
				r=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			dbUtil.close();
		}
		return r;
	}

	public void updateOrderId(int id) {
		String sql="update user set order_id=order_id+1 where id=?";
		dbUtil.update(sql, id);
	}

	
	@Override
	public int update(User user) {
		String sql="update user set username=?,password=?,realname=?,phone=?,address=?,pic_file=? where id=?";
		int i=dbUtil.update(sql, user.getUsername(),user.getPassword(),user.getRealname(),user.getPhone(),user.getAddress(),user.getPicFile(),user.getId());
		return i;
	}
}
