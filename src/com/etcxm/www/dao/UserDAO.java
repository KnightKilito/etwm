package com.etcxm.www.dao;

import java.util.List;

import com.etcxm.www.entity.User;

public interface UserDAO {
	
	public User findById(int id);
	public List<User> findAll();
	public int insert(User user);
	public int authUsername(String username,String type);
	public int authUsername(String username);
	//������
	
	//ͨ���û����������ѯ�û�
	public User findByUsernameAndPassword(User ruser);
	public void updateOrderId(int id);
	public int update(User user);
}
