package com.kuangyeyuan.xuetang.bean;

import java.util.List;

/**
 * Created by darkal on 2017/8/22
 */
public class ChoiceBean {

    /**
     * title : 66666
     * banner : url
     * templateData : [{}]
     */

    private String title;
    private String banner;
    private List<TemplateDataBean> templateData;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<TemplateDataBean> getTemplateData() {
        return templateData;
    }

    public void setTemplateData(List<TemplateDataBean> templateData) {
        this.templateData = templateData;
    }
}
