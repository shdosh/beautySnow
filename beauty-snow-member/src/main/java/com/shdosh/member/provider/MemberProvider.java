package com.shdosh.member.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberProvider {

    public static void main(String[] args) throws IOException{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext-member-provider.xml","spring-mybatis.xml"});
        
        context.start();
        
        System.in.read(); //保证服务运行
    }
}
