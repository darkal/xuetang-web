package com.kuangyeyuan.xuetang.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by darkal on 2017/8/29
 */
@Entity
public class SessionEntity {

    @Id
    private String openid;
    private String session_key;
    private String session;

    private long timestamp;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
