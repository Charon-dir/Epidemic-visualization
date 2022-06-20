package com.cdtu.epidemicvisualization.entity;

import java.io.Serializable;

/**
 * (Visit)实体类
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
public class Visit implements Serializable {
    private static final long serialVersionUID = 248134162008282729L;

    private Integer id;

    private Integer count;

    private String ip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}

