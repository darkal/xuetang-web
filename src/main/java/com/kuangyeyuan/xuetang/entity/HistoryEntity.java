package com.kuangyeyuan.xuetang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 后期这里改成Redis实现
 * Created by darkal on 2017/9/5
 */

@Entity
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String openid;
    private String historyIds="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHistoryIds() {
        return historyIds;
    }

    public void setHistoryIds(String historyIds) {
        this.historyIds = historyIds;
    }
}
