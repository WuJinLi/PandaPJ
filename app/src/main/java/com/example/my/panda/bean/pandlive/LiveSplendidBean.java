package com.example.my.panda.bean.pandlive;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class LiveSplendidBean {

    /**
     * 0 : {"vsid":"VSET100167216881","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic
     * .com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv
     * .cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"",
     * "yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他",
     * "desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
     * count : 2821
     */


    /**
     * vsid : VSET100167216881
     * order : 2823
     * vid : 676a9d45b4e441ad8fb00494288a9737
     * t : 《精彩一刻》 20160906  吃了芝麻糊还没有擦嘴呢
     * url : http://tv.cntv.cn/video/VSET100167216881/676a9d45b4e441ad8fb00494288a9737
     * ptime : 2016-09-06 10:04:53
     * img : http://p3.img.cctvpic.com/fmspic/2016/09/06/676a9d45b4e441ad8fb00494288a9737-25.jpg
     * len : 00:00:29
     * em : CM01
     */

    @SerializedName("video")
    private List<LiveVideoBean> video;

    public List<LiveVideoBean> getVideo() {
        return video;
    }
    public void setVideo(List<LiveVideoBean> video) {
        this.video = video;
    }


}
