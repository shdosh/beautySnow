package com.shdosh.user.pojo;

import java.util.Date;

public class User {
    private Integer id;
    
    private String userName;
    
    private Date createTime;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String toString() {
        return "{id : " + id + " , " + "userName : " + userName + " , createTime : " + createTime +"}";
        
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
