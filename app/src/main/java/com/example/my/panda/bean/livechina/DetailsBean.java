package com.example.my.panda.bean.livechina;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class DetailsBean {

    /**
     * title : 八达岭南四楼
     * brief :
     * 八达岭长城位于北京市西北六十公里处，被评为中国旅游胜地四十家之首和北京旅游“世界之最”。因其机构严谨科学，虽经历五百多年的历史风烟，至今仍巍然屹立，足以说明古代汉族劳动人民在建筑科学和艺术上的卓越才能。
     * image : http://p1.img.cctvpic
     * .com/photoAlbum/page/performance/img/2015/12/28/1451290603994_440.jpg
     * id : bgws4
     * order : 1
     */

    @SerializedName("live")
    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }


}
