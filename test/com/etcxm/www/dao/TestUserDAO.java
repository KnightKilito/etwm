package com.etcxm.www.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.etcxm.www.dao.impl.UserDAOImpl;
import com.etcxm.www.entity.User;

public class TestUserDAO {
	
	private UserDAO userDAO;
	
	@Before
	public void init(){
		userDAO=new UserDAOImpl();
	}
	
	@Test
	public void testFindByUsernameAndPassword(){
		User user=new User();
		user.setUsername("zs");
		user.setPassword("123456");
		System.out.println(userDAO);
		User user2 = userDAO.findByUsernameAndPassword(user);
		Assert.assertNotNull(user2);
		
	}

}
