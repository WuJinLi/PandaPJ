package com.example.my.panda.bean.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lee on 2016/9/6.
 */
public class VideoInfoBean {

    /**
     * play_channel : 音像资料
     * f_pgmtime : 2016-09-05 11:01:14
     * tag : 喵呀咪呀第二十五集不是不抱时候未到
     * cdn_info : {"cdn_vip":"vod.cntv.lxdns.com","cdn_code":"VOD-MP4-CDN-CNC","cdn_name":"3rd网宿"}
     * editer_name : xutingting
     * version : 0.2
     * title : 《喵呀咪呀》 20160905 第二十五集：不是不抱 时候未到
     * is_fn_hot : true
     * is_protected : 0
     * hls_url : http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/12a05aea98c54e74a0ea7459142ec236/main.m3u8?maxbr=4096
     * hls_cdn_info : {"cdn_vip":"asp.cntv.lxdns.com","cdn_code":"VOD-HLS-CDN-CNC","cdn_name":"3rd网宿"}
     * client_sid : 1b1d6efaa7514e698ca14829b19a4d53
     * is_ipad_support : true
     * video : {"totalLength":"91.00","chapters":[{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264418000nero_aac32.mp4"}],"validChapterNum":5,"chapters4":[{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2642000000nero_aac16.mp4"}],"chapters3":[{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2641200000nero_aac16.mp4"}],"lowChapters":[{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264200000nero_aac16.mp4"}],"chapters2":[{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264818000nero_aac32.mp4"}],"url":""}
     * is_invalid_copyright : 0
     * produce_id : wxsb01
     * default_stream : HD
     * ack : yes
     * is_fn_multi_stream : false
     * embed :
     * asp_error_code : 0
     * column : 熊猫频道喵呀咪呀高清
     * lc : {"isp_code":"0","city_code":"","provice_code":"BJ","country_code":"CN","ip":"118.187.35.150"}
     * public : 1
     * is_p2p_use : false
     * produce :
     */

    @SerializedName("play_channel")
    private String playChannel;
    @SerializedName("f_pgmtime")
    private String fPgmtime;
    @SerializedName("tag")
    private String tag;
    /**
     * cdn_vip : vod.cntv.lxdns.com
     * cdn_code : VOD-MP4-CDN-CNC
     * cdn_name : 3rd网宿
     */

    @SerializedName("cdn_info")
    private CdnInfoBean cdnInfo;
    @SerializedName("editer_name")
    private String editerName;
    @SerializedName("version")
    private String version;
    @SerializedName("title")
    private String title;
    @SerializedName("is_fn_hot")
    private String isFnHot;
    @SerializedName("is_protected")
    private String isProtected;
    @SerializedName("hls_url")
    private String hlsUrl;
    /**
     * cdn_vip : asp.cntv.lxdns.com
     * cdn_code : VOD-HLS-CDN-CNC
     * cdn_name : 3rd网宿
     */

    @SerializedName("hls_cdn_info")
    private HlsCdnInfoBean hlsCdnInfo;
    @SerializedName("client_sid")
    private String clientSid;
    @SerializedName("is_ipad_support")
    private String isIpadSupport;
    /**
     * totalLength : 91.00
     * chapters : [{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264418000nero_aac32.mp4"}]
     * validChapterNum : 5
     * chapters4 : [{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2642000000nero_aac16.mp4"}]
     * chapters3 : [{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2641200000nero_aac16.mp4"}]
     * lowChapters : [{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264200000nero_aac16.mp4"}]
     * chapters2 : [{"duration":"91","image":"http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264818000nero_aac32.mp4"}]
     * url :
     */

    @SerializedName("video")
    private VideoBean video;
    @SerializedName("is_invalid_copyright")
    private String isInvalidCopyright;
    @SerializedName("produce_id")
    private String produceId;
    @SerializedName("default_stream")
    private String defaultStream;
    @SerializedName("ack")
    private String ack;
    @SerializedName("is_fn_multi_stream")
    private boolean isFnMultiStream;
    @SerializedName("embed")
    private String embed;
    @SerializedName("asp_error_code")
    private int aspErrorCode;
    @SerializedName("column")
    private String column;
    /**
     * isp_code : 0
     * city_code :
     * provice_code : BJ
     * country_code : CN
     * ip : 118.187.35.150
     */

    @SerializedName("lc")
    private LcBean lc;
    @SerializedName("public")
    private String publicX;
    @SerializedName("is_p2p_use")
    private boolean isP2pUse;
    @SerializedName("produce")
    private String produce;

    public String getPlayChannel() {
        return playChannel;
    }

    public void setPlayChannel(String playChannel) {
        this.playChannel = playChannel;
    }

    public String getFPgmtime() {
        return fPgmtime;
    }

    public void setFPgmtime(String fPgmtime) {
        this.fPgmtime = fPgmtime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public CdnInfoBean getCdnInfo() {
        return cdnInfo;
    }

    public void setCdnInfo(CdnInfoBean cdnInfo) {
        this.cdnInfo = cdnInfo;
    }

    public String getEditerName() {
        return editerName;
    }

    public void setEditerName(String editerName) {
        this.editerName = editerName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsFnHot() {
        return isFnHot;
    }

    public void setIsFnHot(String isFnHot) {
        this.isFnHot = isFnHot;
    }

    public String getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public String getHlsUrl() {
        return hlsUrl;
    }

    public void setHlsUrl(String hlsUrl) {
        this.hlsUrl = hlsUrl;
    }

    public HlsCdnInfoBean getHlsCdnInfo() {
        return hlsCdnInfo;
    }

    public void setHlsCdnInfo(HlsCdnInfoBean hlsCdnInfo) {
        this.hlsCdnInfo = hlsCdnInfo;
    }

    public String getClientSid() {
        return clientSid;
    }

    public void setClientSid(String clientSid) {
        this.clientSid = clientSid;
    }

    public String getIsIpadSupport() {
        return isIpadSupport;
    }

    public void setIsIpadSupport(String isIpadSupport) {
        this.isIpadSupport = isIpadSupport;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public String getIsInvalidCopyright() {
        return isInvalidCopyright;
    }

    public void setIsInvalidCopyright(String isInvalidCopyright) {
        this.isInvalidCopyright = isInvalidCopyright;
    }

    public String getProduceId() {
        return produceId;
    }

    public void setProduceId(String produceId) {
        this.produceId = produceId;
    }

    public String getDefaultStream() {
        return defaultStream;
    }

    public void setDefaultStream(String defaultStream) {
        this.defaultStream = defaultStream;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public boolean isIsFnMultiStream() {
        return isFnMultiStream;
    }

    public void setIsFnMultiStream(boolean isFnMultiStream) {
        this.isFnMultiStream = isFnMultiStream;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public int getAspErrorCode() {
        return aspErrorCode;
    }

    public void setAspErrorCode(int aspErrorCode) {
        this.aspErrorCode = aspErrorCode;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public boolean isIsP2pUse() {
        return isP2pUse;
    }

    public void setIsP2pUse(boolean isP2pUse) {
        this.isP2pUse = isP2pUse;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public static class CdnInfoBean {
        @SerializedName("cdn_vip")
        private String cdnVip;
        @SerializedName("cdn_code")
        private String cdnCode;
        @SerializedName("cdn_name")
        private String cdnName;

        public String getCdnVip() {
            return cdnVip;
        }

        public void setCdnVip(String cdnVip) {
            this.cdnVip = cdnVip;
        }

        public String getCdnCode() {
            return cdnCode;
        }

        public void setCdnCode(String cdnCode) {
            this.cdnCode = cdnCode;
        }

        public String getCdnName() {
            return cdnName;
        }

        public void setCdnName(String cdnName) {
            this.cdnName = cdnName;
        }
    }

    public static class HlsCdnInfoBean {
        @SerializedName("cdn_vip")
        private String cdnVip;
        @SerializedName("cdn_code")
        private String cdnCode;
        @SerializedName("cdn_name")
        private String cdnName;

        public String getCdnVip() {
            return cdnVip;
        }

        public void setCdnVip(String cdnVip) {
            this.cdnVip = cdnVip;
        }

        public String getCdnCode() {
            return cdnCode;
        }

        public void setCdnCode(String cdnCode) {
            this.cdnCode = cdnCode;
        }

        public String getCdnName() {
            return cdnName;
        }

        public void setCdnName(String cdnName) {
            this.cdnName = cdnName;
        }
    }

    public static class VideoBean {
        @SerializedName("totalLength")
        private String totalLength;
        @SerializedName("validChapterNum")
        private int validChapterNum;
        @SerializedName("url")
        private String url;
        /**
         * duration : 91
         * image : http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg
         * url : http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264418000nero_aac32.mp4
         */

        @SerializedName("chapters")
        private List<ChaptersBean> chapters;
        /**
         * duration : 91
         * image : http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg
         * url : http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2642000000nero_aac16.mp4
         */

        @SerializedName("chapters4")
        private List<Chapters4Bean> chapters4;
        /**
         * duration : 91
         * image : http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg
         * url : http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h2641200000nero_aac16.mp4
         */

        @SerializedName("chapters3")
        private List<Chapters3Bean> chapters3;
        /**
         * duration : 91
         * image : http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg
         * url : http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264200000nero_aac16.mp4
         */

        @SerializedName("lowChapters")
        private List<LowChaptersBean> lowChapters;
        /**
         * duration : 91
         * image : http://p3.img.cctvpic.com/fmspic/2016/09/05/12a05aea98c54e74a0ea7459142ec236-50.jpg
         * url : http://vod.cntv.lxdns.com/flash/mp4video55/TMS/2016/09/05/12a05aea98c54e74a0ea7459142ec236_h264818000nero_aac32.mp4
         */

        @SerializedName("chapters2")
        private List<Chapters2Bean> chapters2;

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

        public int getValidChapterNum() {
            return validChapterNum;
        }

        public void setValidChapterNum(int validChapterNum) {
            this.validChapterNum = validChapterNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ChaptersBean> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChaptersBean> chapters) {
            this.chapters = chapters;
        }

        public List<Chapters4Bean> getChapters4() {
            return chapters4;
        }

        public void setChapters4(List<Chapters4Bean> chapters4) {
            this.chapters4 = chapters4;
        }

        public List<Chapters3Bean> getChapters3() {
            return chapters3;
        }

        public void setChapters3(List<Chapters3Bean> chapters3) {
            this.chapters3 = chapters3;
        }

        public List<LowChaptersBean> getLowChapters() {
            return lowChapters;
        }

        public void setLowChapters(List<LowChaptersBean> lowChapters) {
            this.lowChapters = lowChapters;
        }

        public List<Chapters2Bean> getChapters2() {
            return chapters2;
        }

        public void setChapters2(List<Chapters2Bean> chapters2) {
            this.chapters2 = chapters2;
        }

        public static class ChaptersBean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters4Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters3Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowChaptersBean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters2Bean {
            @SerializedName("duration")
            private String duration;
            @SerializedName("image")
            private String image;
            @SerializedName("url")
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LcBean {
        @SerializedName("isp_code")
        private String ispCode;
        @SerializedName("city_code")
        private String cityCode;
        @SerializedName("provice_code")
        private String proviceCode;
        @SerializedName("country_code")
        private String countryCode;
        @SerializedName("ip")
        private String ip;

        public String getIspCode() {
            return ispCode;
        }

        public void setIspCode(String ispCode) {
            this.ispCode = ispCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getProviceCode() {
            return proviceCode;
        }

        public void setProviceCode(String proviceCode) {
            this.proviceCode = proviceCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}
