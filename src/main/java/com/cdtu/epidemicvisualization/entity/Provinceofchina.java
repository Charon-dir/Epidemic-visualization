package com.cdtu.epidemicvisualization.entity;

import java.io.Serializable;

/**
 * (Provinceofchina)实体类
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
public class Provinceofchina implements Serializable {
    private static final long serialVersionUID = 259953254564116033L;

    private Integer id;
    /**
     * 省份
     */
    private String province;
    /**
     * 省份名称
     */
    private String name;
    /**
     * 累计确诊
     */
    private Integer confirm;
    /**
     * 现有确诊
     */
    private Integer nowconfirm;

    private Integer suspect;
    /**
     * 死亡
     */
    private Integer dead;
    /**
     * 治愈
     */
    private Integer heal;
    /**
     * 死亡率
     */
    private Object deadrate;
    /**
     * 治愈率
     */
    private Object healrate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getNowconfirm() {
        return nowconfirm;
    }

    public void setNowconfirm(Integer nowconfirm) {
        this.nowconfirm = nowconfirm;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Object getDeadrate() {
        return deadrate;
    }

    public void setDeadrate(Object deadrate) {
        this.deadrate = deadrate;
    }

    public Object getHealrate() {
        return healrate;
    }

    public void setHealrate(Object healrate) {
        this.healrate = healrate;
    }

}

