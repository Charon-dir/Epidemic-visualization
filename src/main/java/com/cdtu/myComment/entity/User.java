package com.cdtu.myComment.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
public class User implements Serializable {
    private static final long serialVersionUID = 197019833709237228L;

    private Integer id;

    private String username;

    private String password;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 账号类型
     */
    private String usertype;

    private Integer shopid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getintroduction() {
        return introduction;
    }

    public void setintroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

}

