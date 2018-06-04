package com.shdosh.user.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdosh.user.dao.IUserDao;
import com.shdosh.user.pojo.User;
import com.shdosh.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	public User getUserById(int userId) {
		

	    User user = userDao.selectByPrimaryKey(userId);

		return user;
	}

}
