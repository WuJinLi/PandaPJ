package com.example.my.panda.bean.hudong;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/8.
 */
public class HuDongBean {

    /**
     * image : http://p1.img.cctvpic
     * .com/photoAlbum/page/performance/img/2016/9/7/1473237454065_992.jpg
     * title : 白露到，一言不合就感冒
     * url : http://webapp.cctv.com/h5/www_ipanda/U709L35YY3.html
     * order : 1
     */

    @SerializedName("interactive")
    private List<InteractiveBean> interactive;

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }


}
