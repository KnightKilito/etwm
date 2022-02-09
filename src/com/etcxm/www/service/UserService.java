package com.etcxm.www.service;

import com.etcxm.www.entity.User;

public interface UserService {

	public User findByUsernameAndPassword(User user);
	public boolean save(User user);
	public User findById(int iuserId);
	public int authUsername(String username);
	public int authUsername(String username,String type);
	public void updateOrderId(int id);
	public boolean update(User user);
}
