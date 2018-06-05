package com.shdosh.user.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shdosh.user.pojo.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	//@Resource
	private IUserService userService = null;
	
	//@Test
	public void test() {
		System.out.println("test");
		User user = userService.getUserById(1);
		System.out.println(user);
	}
}
