package com.example.my.panda.bean.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lee on 2016/9/6.
 */
public class HomePageCCTVBean {

    /**
     * url : http://panview.ipanda.com/2016/09/03/VIDEvQuJHx3gSRiUwy6HfdLY160903.shtml
     * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/4/1472969592669_907.jpg
     * title : 《今日关注》创新 开放 联动 包容 B20详解“中国药房”
     * videoLength : 25:29
     * id : TITE1472367534738169
     * daytime : 20160903
     * type : 2
     * pid :
     * vid : C10447
     * order : 1
     */

    @SerializedName("list")
    private List<CCTVListBean> list;

    public List<CCTVListBean> getList() {
        return list;
    }

    public void setList(List<CCTVListBean> list) {
        this.list = list;
    }

}
