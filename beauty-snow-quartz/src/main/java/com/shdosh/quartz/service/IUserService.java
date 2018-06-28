package com.shdosh.quartz.service;

import com.shdosh.quartz.entity.User;



public interface IUserService {

	public User getUserById(int id);
	
	public User getUser(User u);
}

