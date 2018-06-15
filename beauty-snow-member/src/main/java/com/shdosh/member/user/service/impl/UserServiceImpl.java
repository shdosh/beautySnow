package com.shdosh.member.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shdosh.member.user.dao.IUserDao;
import com.shdosh.property.ConfigProperties;
import com.shdosh.user.pojo.User;
import com.shdosh.user.service.IUserService;

/**
 * Author: shdosh
 * Description: 用户服务实现
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    public User getUserById(int userId) {
        
        User user = userDao.selectByPrimaryKey(userId);

        return user;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
       /* ConfigProperties properties = new ConfigProperties();
        ClassLoader classLoader = UserServiceImpl.class.getClassLoader();
        URL url = classLoader.getResource("log-kafka.properties");
        properties.createProperty(new File(url.getFile()));
        System.out.println(properties);*/
    }
}
