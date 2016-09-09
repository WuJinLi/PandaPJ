package com.example.my.panda.bean.pandlive;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class LiveBean {

    /**
     * url :
     * image : http://p1.img.cctvpic
     * .com/photoAlbum/page/performance/img/2016/1/18/1453101776719_268.jpg
     * title : 成都基地高清精切线路
     * videoLength :
     * id : ipanda
     * daytime :
     * type : 1
     * pid :
     * vid :
     * order : 1
     */

    @SerializedName("list")
    private List<LiveListBean> list;

    public List<LiveListBean> getList() {
        return list;
    }

    public void setList(List<LiveListBean> list) {
        this.list = list;
    }


}
