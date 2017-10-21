package com.kuangyeyuan.xuetang.utils;

import com.kuangyeyuan.xuetang.bean.TemplateDataBean;
import com.kuangyeyuan.xuetang.entity.CateEntity;
import com.kuangyeyuan.xuetang.entity.ContentEntity;

/**
 * Created by darkal on 2017/9/5
 */
public class ControllerUtils {
    public static TemplateDataBean getTemplateDataBean(ContentEntity contentEntity){
        TemplateDataBean templateDataBean = new TemplateDataBean();

        String webUrl;

        if(contentEntity.getTargetUrl()!=null && contentEntity.getTargetUrl().length()>0){
            webUrl = contentEntity.getTargetUrl();
        }else if(contentEntity.getType().equals("article")){
            webUrl = "/pages/content/content?id="+contentEntity.getId();
        }else if(contentEntity.getType().equals("list")){
            webUrl = "/pages/list/list?type=list&id="+contentEntity.getExt();
        }else if(contentEntity.getPrice()>0){
            webUrl = "/pages/buy/buy?id="+contentEntity.getId();
        }else{
            webUrl = "/pages/mv/mv?id="+contentEntity.getId();
        }

        templateDataBean.setTag(contentEntity.getPrice()>0?"¥"+contentEntity.getPrice():"免费");
        templateDataBean.setArticle(contentEntity.getType().equals("article"));
        templateDataBean.setPrice(contentEntity.getPrice());
        templateDataBean.setVideoId(contentEntity.getId());
        templateDataBean.setName(contentEntity.getTitle());
        templateDataBean.setPicUrl(contentEntity.getImage());
        templateDataBean.setDesc(contentEntity.getContentDesc());
        templateDataBean.setWebUrl(webUrl);
        templateDataBean.setPicUrl(contentEntity.getImage());
        return templateDataBean;
    }

    public static TemplateDataBean getIconTemplateDataBean(CateEntity cateEntity){
        TemplateDataBean templateDataBean = new TemplateDataBean();

        String webUrl = "/pages/list/list?type=list&id=" + cateEntity.getId();

        templateDataBean.setName(cateEntity.getTitle());
        templateDataBean.setWebUrl(webUrl);
        templateDataBean.setPicUrl(cateEntity.getIconUrl());
        return templateDataBean;
    }
}
