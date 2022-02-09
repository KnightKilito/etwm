package com.etcxm.www.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.etcxm.www.entity.User;
import com.etcxm.www.service.impl.UserServiceImpl;


public class TestUserService {
	
	private UserService userService;
	
	@Before
	public void init(){
		userService=new UserServiceImpl();
	}
	
	@Test
	public void testFindByUsernameAndPassword(){
		
		User user=new User();
		user.setUsername("zs");
		user.setPassword("123456");
		User user2 = userService.findByUsernameAndPassword(user);
		Assert.assertNotNull(user2);
		
	}

}
