package com.cdtu.myComment.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comments)实体类
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
public class Comments implements Serializable {
    private static final long serialVersionUID = -30369666111615080L;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 商店id
     */
    private Integer shopid;

    private String usercomment;

    private String score;

    private Date createTime;

    private Date updateTime;

    private String reply;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getUsercomment() {
        return usercomment;
    }

    public void setUsercomment(String usercomment) {
        this.usercomment = usercomment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

}

