package com.kuangyeyuan.xuetang.bean;

import java.util.List;

/**
 * Created by darkal on 2017/8/22
 */
public class TemplateDataBean {
    /**
     * name : 【青云志】至第54集 李易峰、赵丽颖含泪诀别
     * jumpType : videoPlayer
     * subjectId : 1401
     * picUrl : http://i3.hunantv.com/p1/20161030/2348011464C.jpg
     * playUrl : http://www.mgtv.com/v/2/104817/f/3336767.html
     * icon :
     * tag :
     * desc :
     * videoId : 3336767
     * hotDegree :
     * hotType : 0
     * playTimeIconUrl :
     * webUrl :
     * content :
     * canShare : 1
     * ext : 0
     * libId : 0
     * channelId : 0
     * jumpChannel : 0
     * osType :
     * activityId : 0
     * cid : 104817
     * rootId : 2
     * isFormal : 1
     * ended : 0
     * updateList : [{"index":"53","videoId":"3660603"}]
     */

    private String name;
    private String jumpType;
    private int subjectId;
    private String picUrl;
    private String playUrl;
    private String icon;
    private String tag;
    private String desc;
    private int videoId;
    private String hotDegree;
    private int hotType;
    private String playTimeIconUrl;
    private String webUrl;
    private String content;
    private int canShare;
    private int ext;
    private int libId;
    private int channelId;
    private int jumpChannel;
    private String osType;
    private int activityId;
    private int cid;
    private int rootId;
    private int isFormal;
    private Boolean isArticle;
    private int ended;
    private double price;
    private List<UpdateListBean> updateList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJumpType() {
        return jumpType;
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getHotDegree() {
        return hotDegree;
    }

    public void setHotDegree(String hotDegree) {
        this.hotDegree = hotDegree;
    }

    public int getHotType() {
        return hotType;
    }

    public void setHotType(int hotType) {
        this.hotType = hotType;
    }

    public String getPlayTimeIconUrl() {
        return playTimeIconUrl;
    }

    public void setPlayTimeIconUrl(String playTimeIconUrl) {
        this.playTimeIconUrl = playTimeIconUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCanShare() {
        return canShare;
    }

    public void setCanShare(int canShare) {
        this.canShare = canShare;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }

    public int getLibId() {
        return libId;
    }

    public void setLibId(int libId) {
        this.libId = libId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getJumpChannel() {
        return jumpChannel;
    }

    public void setJumpChannel(int jumpChannel) {
        this.jumpChannel = jumpChannel;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public int getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(int isFormal) {
        this.isFormal = isFormal;
    }

    public int getEnded() {
        return ended;
    }

    public void setEnded(int ended) {
        this.ended = ended;
    }

    public Boolean getArticle() {
        return isArticle;
    }

    public void setArticle(Boolean article) {
        isArticle = article;
    }

    public List<UpdateListBean> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<UpdateListBean> updateList) {
        this.updateList = updateList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static class UpdateListBean {
        /**
         * index : 53
         * videoId : 3660603
         */

        private String index;
        private String videoId;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }
    }
}
