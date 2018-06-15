package com.shdosh.user.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * Author: shdosh
 * Description: 用户实体类
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6706928575899398832L;

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
