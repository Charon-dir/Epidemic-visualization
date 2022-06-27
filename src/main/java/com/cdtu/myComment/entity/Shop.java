package com.cdtu.myComment.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = 345825101699035483L;

    private Integer id;
    /**
     * 商铺名称
     */
    private String name;
    /**
     * 商铺类型的id
     */
    private String typedId;

    private String address;

    private String sold;

    private String openHours;

    private Date createTime;

    private Date updateTime;

    private String introduction;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypedId() {
        return typedId;
    }

    public void setTypedId(String typedId) {
        this.typedId = typedId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getintroduction() {
        return introduction;
    }

    public void setintroduction(String introduction) {
        this.introduction = introduction;
    }

}

