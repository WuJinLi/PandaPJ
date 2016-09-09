package com.example.my.panda.bean.eye;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My on 2016/9/6.
 */
public class EyeBean {
    /**
     * bigImg : [{"image":"http://p1.img.cctvpic
     * .com/photoAlbum/page/performance/img/2016/9/5/1473059138112_444.jpg",
     * "title":"论道G20：习主席的演讲彰显中国对全球治理的领导力","url":"http://panview.ipanda
     * .com/2016/09/05/ARTINZgCpdcPCLDaBBNLkQsQ160905.shtml",
     * "id":"ARTINZgCpdcPCLDaBBNLkQsQ160905","type":"5","stype":"","pid":"","vid":"","order":"1"}]
     * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general
     * /getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,
     * PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,
     * PAGE1451473628934144&serviceId=panda
     */
    @SerializedName("data")
    private EyeBigImgBean data;

    public EyeBigImgBean getData() {
        return data;
    }

    public void setData(EyeBigImgBean data) {
        this.data = data;
    }

}
