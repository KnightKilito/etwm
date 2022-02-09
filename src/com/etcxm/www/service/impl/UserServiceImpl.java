package com.etcxm.www.service.impl;

import com.etcxm.www.dao.UserDAO;
import com.etcxm.www.dao.impl.UserDAOImpl;
import com.etcxm.www.entity.User;
import com.etcxm.www.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO=new UserDAOImpl();
	public User findById(int iuserId) {
		return userDAO.findById(iuserId);
	}
	@Override
	public User findByUsernameAndPassword(User user) {
		return userDAO.findByUsernameAndPassword(user);
	}
	public boolean save(User user){
		int i = userDAO.insert(user);
		return i==1?true:false;
		}
	public int authUsername(String username,String type) {
		return userDAO.authUsername(username,type);
	}
	public int authUsername(String username) {
		return userDAO.authUsername(username);
	}
	public void updateOrderId(int id) {
		userDAO.updateOrderId(id);
	}
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		int i = userDAO.update(user);
		return i==1?true:false;
	}
}
