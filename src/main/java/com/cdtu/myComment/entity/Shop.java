package com.cdtu.myComment.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2022-06-27 21:38:45
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = 560197291859584441L;

    private Integer id;
    /**
     * 商铺名称
     */
    private String name;
    /**
     * 商铺类型的id
     */
    private String typedId;
    /**
     * 地址
     */
    private String address;
    /**
     * 销售量
     */
    private String sold;
    /**
     * 开启时间
     */
    private String openHours;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    private String introduction;

    private String img;


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

    public String get

    introduction() {
        return introduction;
    }

    public void set

    introduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

