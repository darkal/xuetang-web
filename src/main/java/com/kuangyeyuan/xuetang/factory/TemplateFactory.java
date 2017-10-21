package com.kuangyeyuan.xuetang.factory;

import com.kuangyeyuan.xuetang.bean.DataBean;
import com.kuangyeyuan.xuetang.bean.DataBeanType;
import com.kuangyeyuan.xuetang.bean.RespBean;
import com.kuangyeyuan.xuetang.bean.TemplateDataBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by darkal on 2017/8/22
 */
public class TemplateFactory {
    public static DataBean getDataBean(DataBeanType type,List<TemplateDataBean> list){
        DataBean dataBean = new DataBean();
        dataBean.setType(type);
        dataBean.setTemplateData(list);
        return dataBean;
    }

    public static RespBean getRespBean(List<DataBean> list){
        RespBean respBean = new RespBean();
        respBean.setCode(200);
        respBean.setData(list);
        return respBean;
    }
}
