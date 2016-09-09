package com.example.my.panda.bean.culture;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Culture {

    /**
     * url : http://culture.ipanda.com/2016/09/05/ARTImsQoVkJGXVxl7n6XVIVA160905.shtml
     * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/5/1473065830591_716.jpg
     * title : 天高云淡季 去些冷门的地方玩玩吧
     * id : ARTImsQoVkJGXVxl7n6XVIVA160905
     * type : 5
     * stype :
     * pid :
     * vid :
     * order : 1
     */

    @SerializedName("bigImg")
    private List<CultureBigImgBean> bigImg;
    /**
     * url : http://tv.cctv.com/2016/09/02/VIDEaEw61V4eBtRi9akAT1PA160902.shtml
     * image : http://p3.img.cctvpic.com/fmspic/2016/09/02/456b0d718c5d4f9fa258485ecf988007-430.jpg
     * title : 普陀山：海上丝绸之路的历史见证
     * brief : 普陀山是舟山群岛1390个岛屿中的一座，也是当地最负盛名的海岛。短姑码头是进入普陀山海天佛国的通道。
     * type : 1
     * videoLength : 14:13
     * id : 456b0d718c5d4f9fa258485ecf988007
     * order : 1
     */

    @SerializedName("list")
    private List<CultureListBean> list;

    public List<CultureBigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<CultureBigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<CultureListBean> getList() {
        return list;
    }

    public void setList(List<CultureListBean> list) {
        this.list = list;
    }




}
