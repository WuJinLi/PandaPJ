package com.example.my.panda.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class VideoUrlBean {

    /**
     * play_channel : CCTV-4高清
     * f_pgmtime : 2016-09-06 18:45:45
     * tag :
     * cdn_info : {"cdn_vip":"vod.cntv.lxdns.com","cdn_code":"VOD-MP4-CDN-CNC","cdn_name":"3rd网宿"}
     * editer_name : chenjialei
     * version : 0.2
     * title : 西班牙度假胜地遭遇山火 上千人撤离
     * is_fn_hot : true
     * is_protected : 0
     * hls_url : http://asp.cntv.lxdns
     * .com/asp/hls/main/0303000a/3/default/7e9facbf34e9450ab5560e28aef7aaba/main.m3u8?maxbr=4096
     * hls_cdn_info : {"cdn_vip":"asp.cntv.lxdns.com","cdn_code":"VOD-HLS-CDN-CNC",
     * "cdn_name":"3rd网宿"}
     * client_sid : c6d026b425aa485fa6ed4485ff6529b6
     * is_ipad_support : true
     * video : {"totalLength":"54.00","chapters":[{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h264418000nero_aac32.mp4"}],"validChapterNum":5,
     * "chapters4":[{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h2642000000nero_aac16.mp4"}],
     * "chapters3":[{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h2641200000nero_aac16.mp4"}],
     * "lowChapters":[{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h264200000nero_aac16.mp4"}],
     * "chapters2":[{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h264818000nero_aac32.mp4"}],"url":""}
     * is_invalid_copyright : 0
     * produce_id : wxsb01
     * default_stream : HD
     * ack : yes
     * is_fn_multi_stream : false
     * embed :
     * asp_error_code : 0
     * column : 熊猫观察-全球热点高清精切
     * lc : {"isp_code":"0","city_code":"","provice_code":"BJ","country_code":"CN","ip":"118.187
     * .35.150"}
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
     * totalLength : 54.00
     * chapters : [{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h264418000nero_aac32.mp4"}]
     * validChapterNum : 5
     * chapters4 : [{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h2642000000nero_aac16.mp4"}]
     * chapters3 : [{"duration":"54","image":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv
     * .lxdns.com/flash/mp4video55/TMS/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba_h2641200000nero_aac16.mp4"}]
     * lowChapters : [{"duration":"54","image":"http://p5.img.cctvpic.com/fmspic/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv.lxdns
     * .com/flash/mp4video55/TMS/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba_h264200000nero_aac16
     * .mp4"}]
     * chapters2 : [{"duration":"54","image":"http://p5.img.cctvpic.com/fmspic/2016/09/06
     * /7e9facbf34e9450ab5560e28aef7aaba-37.jpg","url":"http://vod.cntv.lxdns
     * .com/flash/mp4video55/TMS/2016/09/06/7e9facbf34e9450ab5560e28aef7aaba_h264818000nero_aac32
     * .mp4"}]
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






}
