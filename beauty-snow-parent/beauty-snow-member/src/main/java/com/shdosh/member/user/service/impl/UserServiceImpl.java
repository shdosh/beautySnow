package com.shdosh.member.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shdosh.member.user.dao.IUserDao;
import com.shdosh.member.user.service.IUserService;
import com.shdosh.user.pojo.User;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    public User getUserById(int userId) {
        

        User user = userDao.selectByPrimaryKey(userId);

        return user;
    }

}
