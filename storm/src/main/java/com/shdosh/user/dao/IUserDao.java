package com.shdosh.user.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shdosh.user.pojo.User;

@Repository
//@Component
public interface IUserDao {

	public User selectByPrimaryKey(int userId);
}
