package com.kuangyeyuan.xuetang;

/**
 * Created by darkal on 2017/8/31
 */
public class PeopleBean {
    private String name="";
    private String title1="";
    private String title2="";
    private String title3="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    @Override
    public String toString() {
        return "name "+getName() + " title1 " + getTitle1() + " title2 " + getTitle2() + " title3 " + getTitle3();
    }
}
