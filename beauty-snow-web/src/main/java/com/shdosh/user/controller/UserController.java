package com.shdosh.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shdosh.member.user.service.IUserService;
import com.shdosh.user.pojo.User;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Resource
    private IUserService userService;
    
    @RequestMapping(value = "/showUser")
    public String toIndex(HttpServletRequest request, Model model){

        System.out.println("controller test......");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }
}
