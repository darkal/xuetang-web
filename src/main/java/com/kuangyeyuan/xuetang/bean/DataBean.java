package com.kuangyeyuan.xuetang.bean;

import java.util.List;

/**
 * Created by darkal on 2017/8/22
 */
public class DataBean {
    /**
     * type : banner
     * templateData : [{"name":"【青云志】至第54集 李易峰、赵丽颖含泪诀别","jumpType":"videoPlayer","subjectId":1401,"picUrl":"http://i3.hunantv.com/p1/20161030/2348011464C.jpg","playUrl":"http://www.mgtv.com/v/2/104817/f/3336767.html","icon":"","tag":"","desc":"","videoId":3336767,"hotDegree":"","hotType":0,"playTimeIconUrl":"","webUrl":"","splitItem":"","canShare":1,"ext":0,"libId":0,"channelId":0,"jumpChannel":0,"osType":"","activityId":0,"cid":104817,"rootId":2,"isFormal":1,"ended":0,"updateList":[{"index":"53","videoId":"3660603"}]},{"name":"【一年级·毕业季】汪峰陈伟霆空降指导","jumpType":"videoPlayer","subjectId":0,"picUrl":"http://i3.hunantv.com/p1/20161029/2335584186C.jpg","playUrl":"http://www.mgtv.com/v/1/295121/f/3664738.html","icon":"","tag":"","desc":"","videoId":3664738,"hotDegree":"","hotType":0,"playTimeIconUrl":"","webUrl":"imgotv://concertPlayer?type=0","splitItem":"","canShare":1,"ext":0,"libId":0,"channelId":0,"jumpChannel":0,"osType":"","activityId":1000020,"cid":295121,"rootId":1,"isFormal":1,"ended":0,"updateList":[]},{"name":"【爸爸去哪儿4·第三期】安吉晋升小爸爸替父带娃","jumpType":"videoPlayer","subjectId":0,"picUrl":"http://i1.hunantv.com/p1/20161028/235103791C.jpg","playUrl":"http://www.mgtv.com/v/1/298442/f/3662018.html","icon":"","tag":"","desc":"考拉受惊吓失声尖叫","videoId":3662018,"hotDegree":"","hotType":0,"playTimeIconUrl":"","webUrl":"","splitItem":"","canShare":1,"ext":0,"libId":0,"channelId":0,"jumpChannel":0,"osType":"","activityId":0,"cid":298442,"rootId":1,"isFormal":1,"ended":0,"updateList":[]},{"name":"【真正男子汉2·第二期】黄子韬怒怼教官血性逆袭","jumpType":"videoPlayer","subjectId":0,"picUrl":"http://i1.hunantv.com/p1/20161028/2135198265C.jpg","playUrl":"http://www.mgtv.com/v/1/298050/f/3663335.html","icon":"","tag":"","desc":"杨幂狂吐黄子韬空中出意外","videoId":3663335,"hotDegree":"","hotType":0,"playTimeIconUrl":"","webUrl":"imgotv://concertPlayer?type=0","splitItem":"","canShare":1,"ext":0,"libId":0,"channelId":0,"jumpChannel":0,"osType":"","activityId":1000020,"cid":298050,"rootId":1,"isFormal":1,"ended":0,"updateList":[]},{"name":"【红星照耀中国】至第19集 黄海冰周海媚再现长征岁月","jumpType":"videoPlayer","subjectId":0,"picUrl":"http://i4.hunantv.com/p1/20161030/2350244175C.jpg","playUrl":"http://www.mgtv.com/v/2/302341/f/3639255.html","icon":"","tag":"","desc":"","videoId":3639255,"hotDegree":"","hotType":0,"playTimeIconUrl":"","webUrl":"","splitItem":"","canShare":1,"ext":0,"libId":0,"channelId":0,"jumpChannel":0,"osType":"","activityId":0,"cid":302341,"rootId":2,"isFormal":1,"ended":0,"updateList":[{"index":"17","videoId":"3667552"},{"index":"18","videoId":"3667598"}]}]
     */

    private DataBeanType type;
    private List<TemplateDataBean> templateData;

    public DataBeanType getType() {
        return type;
    }

    public void setType(DataBeanType type) {
        this.type = type;
    }

    public List<TemplateDataBean> getTemplateData() {
        return templateData;
    }

    public void setTemplateData(List<TemplateDataBean> templateData) {
        this.templateData = templateData;
    }
}
