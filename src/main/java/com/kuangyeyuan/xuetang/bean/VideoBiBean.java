package com.kuangyeyuan.xuetang.bean;

import java.util.List;

/**
 * Created by darkal on 2017/8/28
 */
public class VideoBiBean {

    /**
     * mvs : [{"id":5586980,"cover":"http://p3.music.126.net/xWrgvENCAaEORqmPhurBmw==/18715886929986172.jpg","name":"如果我爱你","playCount":2422380,"briefDesc":"《春风十里，不如你》片头曲","desc":null,"artistName":"周冬雨","artistId":11995107,"duration":180000,"mark":0,"artists":[{"id":11995107,"name":"周冬雨","alias":[],"transNames":null},{"id":1049983,"name":"张一山","alias":[],"transNames":null}],"alg":"itembased"},{"id":5490019,"cover":"http://p4.music.126.net/Fk2fx7b4gV9gG8o0_Bs0KQ==/18685100604299746.jpg","name":"傲娇与偏见 (对唱版)","playCount":1446440,"briefDesc":"迪丽热巴&张云龙上演浪漫又爆笑的爱情故事","desc":null,"artistName":"迪丽热巴","artistId":12108770,"duration":208000,"mark":0,"artists":[{"id":12108770,"name":"迪丽热巴","alias":[],"transNames":null},{"id":12108767,"name":"张云龙","alias":["演员张云龙"],"transNames":null}],"alg":"itembased"},{"id":5479022,"cover":"http://p4.music.126.net/KI9LP6He7WzkmbVxUzwNNA==/18796151278696623.jpg","name":"我喜欢上你时的内心活动","playCount":2571136,"briefDesc":"陈绮贞&韩寒首度联手吃定你 ","desc":null,"artistName":"陈绮贞","artistId":7217,"duration":212000,"mark":0,"artists":[{"id":7217,"name":"陈绮贞","alias":["Cheer","Cheer Chen"],"transNames":null}],"alg":"itembased"},{"id":5531018,"cover":"http://p3.music.126.net/ckaQygaXvywkAHykVzVHmQ==/19087521858322819.jpg","name":"一人饮酒醉 (电影《父子雄兵》宣传曲)","playCount":2162768,"briefDesc":"大鹏携手MC天佑演唱《一人饮酒醉》","desc":null,"artistName":"大鹏","artistId":188681,"duration":209000,"mark":0,"artists":[{"id":188681,"name":"大鹏","alias":["董成鹏"],"transNames":null},{"id":1047007,"name":"MC天佑","alias":["天佑"],"transNames":null}],"alg":"itembased"},{"id":5521455,"cover":"http://p3.music.126.net/1JKRGjiG39e1DrEfdPpnZg==/18583945534594754.jpg","name":"我们","playCount":1582040,"briefDesc":"欢乐颂\u201c五美\u201d献唱《我们》，温暖的\u201c一家人\u201d","desc":null,"artistName":"刘涛","artistId":704004,"duration":233000,"mark":0,"artists":[{"id":704004,"name":"刘涛","alias":[],"transNames":null},{"id":12043068,"name":"蒋欣","alias":[],"transNames":null},{"id":12042058,"name":"王子文","alias":[],"transNames":null},{"id":10368,"name":"杨紫","alias":[],"transNames":null},{"id":12042059,"name":"乔欣","alias":[],"transNames":null}],"alg":"itembased"}]
     * code : 200
     */

    private int code;
    private List<MvsBean> mvs;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<MvsBean> getMvs() {
        return mvs;
    }

    public void setMvs(List<MvsBean> mvs) {
        this.mvs = mvs;
    }

    public static class MvsBean {
        /**
         * id : 5586980
         * cover : http://p3.music.126.net/xWrgvENCAaEORqmPhurBmw==/18715886929986172.jpg
         * name : 如果我爱你
         * playCount : 2422380
         * briefDesc : 《春风十里，不如你》片头曲
         * desc : null
         * artistName : 周冬雨
         * artistId : 11995107
         * duration : 180000
         * mark : 0
         * artists : [{"id":11995107,"name":"周冬雨","alias":[],"transNames":null},{"id":1049983,"name":"张一山","alias":[],"transNames":null}]
         * alg : itembased
         */

        private int id;
        private String cover;
        private String name;
        private long playCount;
        private String briefDesc;
        private String desc;
        private String artistName;
        private int artistId;
        private int duration;
        private int mark;
        private String alg;
        private List<ArtistsBean> artists;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public static class ArtistsBean {
            /**
             * id : 11995107
             * name : 周冬雨
             * alias : []
             * transNames : null
             */

            private int id;
            private String name;
            private Object transNames;
            private List<?> alias;

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

            public Object getTransNames() {
                return transNames;
            }

            public void setTransNames(Object transNames) {
                this.transNames = transNames;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
