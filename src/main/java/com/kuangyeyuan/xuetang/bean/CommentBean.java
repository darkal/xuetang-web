package com.kuangyeyuan.xuetang.bean;

import com.kuangyeyuan.xuetang.entity.UserEntity;

import java.util.List;

/**
 * Created by darkal on 2017/8/28
 */
public class CommentBean {

    private String avatar;
    private String uName;
    private boolean top;
    private boolean money;
    private String time;
    private String content;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMoney() {
        return money;
    }

    public void setMoney(boolean money) {
        this.money = money;
    }
}
