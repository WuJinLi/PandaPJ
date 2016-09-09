package com.example.my.panda.bean.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lee on 2016/9/6.
 */
public class HomePagePandaeyeBean {

    /**
     * url : http://panview.ipanda.com/2016/09/06/VIDEUFahGjUf5sS22HXPVSCG160906.shtml
     * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/6/1473125845271_201.jpg
     * title : 聚焦G20峰会 多国领导人社交网络“晒”照
     * videoLength : 01:30
     * id : TITE1473125846675120
     * daytime : 2016-09-06
     * type : 2
     * pid : 5bd695141eae4a0480d6a35eba8612ff
     * vid :
     * order : 1
     */

    @SerializedName("list")
    private List<PandaListDataBean> list;

    public List<PandaListDataBean> getList() {
        return list;
    }

    public void setList(List<PandaListDataBean> list) {
        this.list = list;
    }

}
