package com.kuangyeyuan.xuetang.entity;

import org.springframework.web.util.HtmlUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by darkal on 2017/8/27
 */
@Entity
public class ContentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title = "";
    private String image = "";
    private String contentDesc = "";
    private long viewCount = 0;
    private String author = "";
    private Boolean isLargeView = false;
    private String targetUrl = "";
    private long createTime = 0;
    private String type = "";
    private String content = "";
    private String tag = "";
    private String videoUrl = "";
    private int sequence = 0;
    private int cateId = 0;
    private int contentCateId = 0;
    private double price=0.00;
    private String ext = "";
    private int start = 0;
    private String tips = "";
    private Boolean deleted = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getLargeView() {
        return isLargeView;
    }

    public void setLargeView(Boolean largeView) {
        isLargeView = largeView;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return HtmlUtils.htmlEscape(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getContentCateId() {
        return contentCateId;
    }

    public void setContentCateId(int contentCateId) {
        this.contentCateId = contentCateId;
    }

    public int getStart() {
        if(videoUrl != null) {
            return videoUrl.contains("m3u8") ? start : 1;
        }
        return 1;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTips() {
        if(tips!=null && tips.length()>0){
            return tips;
        }
        return "直播尚未开始，请耐心等待～";
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
