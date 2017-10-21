package com.kuangyeyuan.xuetang.bean;

import java.util.List;

/**
 * Created by darkal on 2017/8/28
 */
public class VideoBean {

    /**
     * loadingPic :
     * bufferPic :
     * loadingPicFS :
     * bufferPicFS :
     * subed : false
     * data : {"id":5500158,"name":"春风十里不如你","artistId":3695,"artistName":"李健","content":"李健献唱周冬雨&张一山新剧","desc":"\u201c音乐诗人\u201d李健受\u201c文艺诗人\u201d冯唐力邀，亲自操刀为大型青春纯爱电视剧《春风十里，不如你》创作同名主题曲。两大文艺男神的远方终于交集在一起，为该剧的高品质再添重磅。","cover":"http://p4.music.126.net/7ZwbNnTyMkNs3hHTpS_6Rg==/19088621369916382.jpg","coverId":19088621369916382,"playCount":2519900,"subCount":27420,"shareCount":6601,"likeCount":0,"commentCount":4445,"duration":256000,"nType":0,"publishTime":"2017-04-27","brs":{"480":"http://v4.music.126.net/20170820120556/e39d1ed3367710fa37534869510173d6/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/0b67caff31fa08ff3c6339d1c390e14f.mp4","240":"http://v4.music.126.net/20170820120556/76a558afd13ad8004af3f5080e194c0a/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/e0977cfb6d4a3eaf1942b9356a490f1f.mp4","720":"http://v4.music.126.net/20170820120556/a68222d4a0de028dffe1447cfc5a0caa/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/c6a7dda44432f98cce08f15ca40a9131.mp4","1080":"http://v4.music.126.net/20170820120556/4b1c9e560f141ccb71dc9f98ed7ecfdd/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/8d818d1de046aaf204c8c016abc45d6c.mp4"},"artists":[{"id":3695,"name":"李健"}],"isReward":false,"commentThreadId":"R_MV_5_5500158"}
     * code : 200
     */

    private String loadingPic;
    private String bufferPic;
    private String loadingPicFS;
    private String bufferPicFS;
    private boolean subed;
    private DataBean data;
    private int code;
    private Boolean isPay=false;
    private int start = 0;
    private String tips;

    public Boolean getPay() {
        return isPay;
    }

    public void setPay(Boolean pay) {
        isPay = pay;
    }

    public String getLoadingPic() {
        return loadingPic;
    }

    public void setLoadingPic(String loadingPic) {
        this.loadingPic = loadingPic;
    }

    public String getBufferPic() {
        return bufferPic;
    }

    public void setBufferPic(String bufferPic) {
        this.bufferPic = bufferPic;
    }

    public String getLoadingPicFS() {
        return loadingPicFS;
    }

    public void setLoadingPicFS(String loadingPicFS) {
        this.loadingPicFS = loadingPicFS;
    }

    public String getBufferPicFS() {
        return bufferPicFS;
    }

    public void setBufferPicFS(String bufferPicFS) {
        this.bufferPicFS = bufferPicFS;
    }

    public boolean isSubed() {
        return subed;
    }

    public void setSubed(boolean subed) {
        this.subed = subed;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public static class DataBean {
        /**
         * id : 5500158
         * name : 春风十里不如你
         * artistId : 3695
         * artistName : 李健
         * content : 李健献唱周冬雨&张一山新剧
         * desc : “音乐诗人”李健受“文艺诗人”冯唐力邀，亲自操刀为大型青春纯爱电视剧《春风十里，不如你》创作同名主题曲。两大文艺男神的远方终于交集在一起，为该剧的高品质再添重磅。
         * cover : http://p4.music.126.net/7ZwbNnTyMkNs3hHTpS_6Rg==/19088621369916382.jpg
         * coverId : 19088621369916382
         * playCount : 2519900
         * subCount : 27420
         * shareCount : 6601
         * likeCount : 0
         * commentCount : 4445
         * duration : 256000
         * nType : 0
         * publishTime : 2017-04-27
         * brs : {"480":"http://v4.music.126.net/20170820120556/e39d1ed3367710fa37534869510173d6/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/0b67caff31fa08ff3c6339d1c390e14f.mp4","240":"http://v4.music.126.net/20170820120556/76a558afd13ad8004af3f5080e194c0a/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/e0977cfb6d4a3eaf1942b9356a490f1f.mp4","720":"http://v4.music.126.net/20170820120556/a68222d4a0de028dffe1447cfc5a0caa/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/c6a7dda44432f98cce08f15ca40a9131.mp4","1080":"http://v4.music.126.net/20170820120556/4b1c9e560f141ccb71dc9f98ed7ecfdd/web/cloudmusic/MiEgIDAkZDAgIiAkIDEhIQ==/mv/5500158/8d818d1de046aaf204c8c016abc45d6c.mp4"}
         * artists : [{"id":3695,"name":"李健"}]
         * isReward : false
         * commentThreadId : R_MV_5_5500158
         */

        private int id;
        private String name;
        private int artistId;
        private String artistName;
        private String content;
        private String desc;
        private String cover;
        private long coverId;
        private long playCount;
        private int subCount;
        private int shareCount;
        private int likeCount;
        private int commentCount;
        private int duration;
        private int nType;
        private String publishTime;
        private boolean isReward;
        private String commentThreadId;
        private List<ArtistsBean> artists;
        private String videoURL;
        private double price;
        private int payNum;

        public int getPayNum() {
            return payNum;
        }

        public void setPayNum(int payNum) {
            this.payNum = payNum;
        }

        public int getnType() {
            return nType;
        }

        public void setnType(int nType) {
            this.nType = nType;
        }

        public boolean isReward() {
            return isReward;
        }

        public void setReward(boolean reward) {
            isReward = reward;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getVideoURL() {
            return videoURL;
        }

        public void setVideoURL(String videoURL) {
            this.videoURL = videoURL;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public long getCoverId() {
            return coverId;
        }

        public void setCoverId(long coverId) {
            this.coverId = coverId;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public int getSubCount() {
            return subCount;
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getNType() {
            return nType;
        }

        public void setNType(int nType) {
            this.nType = nType;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public boolean isIsReward() {
            return isReward;
        }

        public void setIsReward(boolean isReward) {
            this.isReward = isReward;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public static class ArtistsBean {
            /**
             * id : 3695
             * name : 李健
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
