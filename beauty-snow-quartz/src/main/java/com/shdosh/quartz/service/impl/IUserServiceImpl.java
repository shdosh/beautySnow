package com.shdosh.quartz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdosh.quartz.dao.IUserDao;
import com.shdosh.quartz.entity.User;
import com.shdosh.quartz.service.IUserService;


@Service("userService")
public class IUserServiceImpl  implements IUserService{

	@Autowired
	public IUserDao udao;
	
	@Override
	public User getUserById(int id) {
		return udao.selectByPrimaryKey(id);
	}

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return udao.findUser(u);
	}

}
