package com.example.my.panda.bean.eye;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class EyeListBean {

    /**
     * total : 8356
     * list : [{"num":1,"datatype":"video","id":"VIDEi01SvSp5yHAauwCq5AV4160906",
     * "title":"全球媒体高度关注G20杭州峰会","videolength":"00:02:44",
     * "guid":"db3c834af1fa40bfab4db58618a33724","picurl":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-93.jpg","picurl2":"http://p5.img
     * .cctvpic.com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-164.jpg",
     * "picurl3":"http://p5.img.cctvpic.com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-93
     * .jpg","url":"http://panview.ipanda.com/2016/09/06/VIDEi01SvSp5yHAauwCq5AV4160906.shtml",
     * "focus_date":1473108036000},{"num":2,"datatype":"video",
     * "id":"VIDE60TyFX417te2aqA3P162160906","title":"习近平会见德国总理","videolength":"00:02:04",
     * "guid":"59809bb561b44b41a88a12f18bc4a6bf","picurl":"http://p1.img.cctvpic
     * .com/fmspic/2016/09/06/59809bb561b44b41a88a12f18bc4a6bf-72.jpg","picurl2":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/59809bb561b44b41a88a12f18bc4a6bf-72.jpg",
     * "picurl3":"http://p3.img.cctvpic.com/fmspic/2016/09/06/59809bb561b44b41a88a12f18bc4a6bf-20
     * .jpg","url":"http://panview.ipanda.com/2016/09/06/VIDE60TyFX417te2aqA3P162160906.shtml",
     * "focus_date":1473107973000},{"num":3,"datatype":"video",
     * "id":"VIDEXJOoTVOPOZY9Q1DbHrZX160906","title":"习近平会见日本首相","videolength":"00:02:34",
     * "guid":"03661b10843c4940b3c44dd56db09f57","picurl":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/03661b10843c4940b3c44dd56db09f57-87.jpg","picurl2":"http://p5.img
     * .cctvpic.com/fmspic/2016/09/06/03661b10843c4940b3c44dd56db09f57-87.jpg",
     * "picurl3":"http://p4.img.cctvpic.com/fmspic/2016/09/06/03661b10843c4940b3c44dd56db09f57-20
     * .jpg","url":"http://panview.ipanda.com/2016/09/06/VIDEXJOoTVOPOZY9Q1DbHrZX160906.shtml",
     * "focus_date":1473107973000},{"num":4,"datatype":"video",
     * "id":"VIDEp3tI7mZyEebUiVfad7iv160906","title":"习近平会见英国首相","videolength":"00:02:15",
     * "guid":"05b3a552d0964ca6aac90d664c954b3b","picurl":"http://p4.img.cctvpic
     * .com/fmspic/2016/09/06/05b3a552d0964ca6aac90d664c954b3b-79.jpg","picurl2":"http://p4.img
     * .cctvpic.com/fmspic/2016/09/06/05b3a552d0964ca6aac90d664c954b3b-20.jpg",
     * "picurl3":"http://p4.img.cctvpic
     * .com/fmspic/2016/09/06/05b3a552d0964ca6aac90d664c954b3b-136.jpg","url":"http://panview
     * .ipanda.com/2016/09/06/VIDEp3tI7mZyEebUiVfad7iv160906.shtml","focus_date":1473107973000},
     * {"num":5,"datatype":"video","id":"VIDER5aHJ98ka6FnK6h49TkU160906","title":"习近平会见法国总统",
     * "videolength":"00:01:40","guid":"b68bcc7ef4704f778d6556af48b875c3","picurl":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/b68bcc7ef4704f778d6556af48b875c3-50.jpg",
     * "picurl2":"http://p1.img.cctvpic
     * .com/fmspic/2016/09/06/b68bcc7ef4704f778d6556af48b875c3-100.jpg","picurl3":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/b68bcc7ef4704f778d6556af48b875c3-50.jpg",
     * "url":"http://panview.ipanda.com/2016/09/06/VIDER5aHJ98ka6FnK6h49TkU160906.shtml",
     * "focus_date":1473107913000},{"num":6,"datatype":"video",
     * "id":"VIDEoPKgF5lSSq2oUAsyHC4t160906","title":"《今日关注》 20160905 \u201c杭州共识\u201d为世界经济指明方向
     * 中国主场外交收获满满","videolength":"00:26:20","guid":"25322092b2b74eac93e69657f63c2c4a",
     * "picurl":"http://p3.img.cctvpic.com/fmspic/2016/09/06/25322092b2b74eac93e69657f63c2c4a-790
     * .jpg","picurl2":"http://p3.img.cctvpic
     * .com/fmspic/2016/09/06/25322092b2b74eac93e69657f63c2c4a-1583.jpg","picurl3":"http://p3.img
     * .cctvpic.com/fmspic/2016/09/06/25322092b2b74eac93e69657f63c2c4a-790.jpg",
     * "url":"http://panview.ipanda.com/2016/09/06/VIDEoPKgF5lSSq2oUAsyHC4t160906.shtml",
     * "focus_date":1473096395000},{"num":7,"datatype":"video",
     * "id":"VIDEqgfI2ikIZ9h2ZiBJ3Z6K160906","title":"G20杭州峰会继续举行 习近平主持会议并致闭幕辞",
     * "videolength":"00:04:53","guid":"dfa7452f040b41268ed52dc7c7caac2e","picurl":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/dfa7452f040b41268ed52dc7c7caac2e-130.jpg",
     * "picurl2":"http://p1.img.cctvpic
     * .com/fmspic/2016/09/06/dfa7452f040b41268ed52dc7c7caac2e-293.jpg","picurl3":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/dfa7452f040b41268ed52dc7c7caac2e-130.jpg",
     * "url":"http://panview.ipanda.com/2016/09/06/VIDEqgfI2ikIZ9h2ZiBJ3Z6K160906.shtml",
     * "focus_date":1473095855000},{"num":8,"datatype":"video",
     * "id":"VIDEke32VkA2LvSxxNwjlVJI160906","title":"寨卡疫情扩散至新加坡马来西亚","videolength":"00:02:49",
     * "guid":"00bcb0eb5a7341198f3b0761b021c5a6","picurl":"http://p3.img.cctvpic
     * .com/fmspic/2016/09/06/00bcb0eb5a7341198f3b0761b021c5a6-95.jpg","picurl2":"http://p3.img
     * .cctvpic.com/fmspic/2016/09/06/00bcb0eb5a7341198f3b0761b021c5a6-169.jpg",
     * "picurl3":"http://p3.img.cctvpic.com/fmspic/2016/09/06/00bcb0eb5a7341198f3b0761b021c5a6-95
     * .jpg","url":"http://panview.ipanda.com/2016/09/06/VIDEke32VkA2LvSxxNwjlVJI160906.shtml",
     * "focus_date":1473095854000},{"num":9,"datatype":"video",
     * "id":"VIDEBLtRdRAwUVidJ3QXGkql160906","title":"台湾\u201c民怨燎原\u201d当局面临\u201c多事之秋\u201d",
     * "videolength":"00:02:07","guid":"73a43add1af447809c72bb67132cb44b","picurl":"http://p5.img
     * .cctvpic.com/fmspic/2016/09/06/73a43add1af447809c72bb67132cb44b-73.jpg",
     * "picurl2":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/73a43add1af447809c72bb67132cb44b-127.jpg","picurl3":"http://p5.img
     * .cctvpic.com/fmspic/2016/09/06/73a43add1af447809c72bb67132cb44b-73.jpg",
     * "url":"http://panview.ipanda.com/2016/09/06/VIDEBLtRdRAwUVidJ3QXGkql160906.shtml",
     * "focus_date":1473095853000},{"num":10,"datatype":"video",
     * "id":"VIDESmsAg392TguYnSeAs8FT160906","title":"习近平会见中外记者","videolength":"00:05:16",
     * "guid":"1c6c4ee4200a4876a54675456062ad42","picurl":"http://p1.img.cctvpic
     * .com/fmspic/2016/09/06/1c6c4ee4200a4876a54675456062ad42-130.jpg","picurl2":"http://p1.img
     * .cctvpic.com/fmspic/2016/09/06/1c6c4ee4200a4876a54675456062ad42-318.jpg",
     * "picurl3":"http://p1.img.cctvpic
     * .com/fmspic/2016/09/06/1c6c4ee4200a4876a54675456062ad42-130.jpg","url":"http://panview
     * .ipanda.com/2016/09/06/VIDESmsAg392TguYnSeAs8FT160906.shtml","focus_date":1473095853000},
     * {"num":11,"datatype":"video","id":"VIDEU8G0hPa3kgP16x7ugvGh160906",
     * "title":"国务院港澳办发言人就香港特区第六届立法会选举发表谈话","videolength":"00:01:06",
     * "guid":"5b156db62f5e44b391f6701481084a27","picurl":"http://p5.img.cctvpic
     * .com/fmspic/2016/09/06/5b156db62f5e44b391f6701481084a27-43.jpg","picurl2":"http://p5.img
     * .cctvpic.com/fmspic/2016/09/06/5b156db62f5e44b391f6701481084a27-66.jpg",
     * "picurl3":"http://p5.img.cctvpic.com/fmspic/2016/09/06/5b156db62f5e44b391f6701481084a27-43
     * .jpg","url":"http://panview.ipanda.com/2016/09/06/VIDEU8G0hPa3kgP16x7ugvGh160906.shtml",
     * "focus_date":1473095793000},{"num":12,"datatype":"video",
     * "id":"VIDEUFahGjUf5sS22HXPVSCG160906","title":"聚焦G20峰会 多国领导人社交网络\u201c晒\u201d照",
     * "videolength":"00:01:30","guid":"5bd695141eae4a0480d6a35eba8612ff","picurl":"http://p3.img
     * .cctvpic.com/fmspic/2016/09/06/5bd695141eae4a0480d6a35eba8612ff-50.jpg",
     * "picurl2":"http://p3.img.cctvpic.com/fmspic/2016/09/06/5bd695141eae4a0480d6a35eba8612ff-90
     * .jpg","picurl3":"http://p3.img.cctvpic
     * .com/fmspic/2016/09/06/5bd695141eae4a0480d6a35eba8612ff-50.jpg","url":"http://panview
     * .ipanda.com/2016/09/06/VIDEUFahGjUf5sS22HXPVSCG160906.shtml","focus_date":1473095793000}]
     */

    @SerializedName("total")
    private int total;
    /**
     * num : 1
     * datatype : video
     * id : VIDEi01SvSp5yHAauwCq5AV4160906
     * title : 全球媒体高度关注G20杭州峰会
     * videolength : 00:02:44
     * guid : db3c834af1fa40bfab4db58618a33724
     * picurl : http://p5.img.cctvpic.com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-93.jpg
     * picurl2 : http://p5.img.cctvpic.com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-164
     * .jpg
     * picurl3 : http://p5.img.cctvpic.com/fmspic/2016/09/06/db3c834af1fa40bfab4db58618a33724-93.jpg
     * url : http://panview.ipanda.com/2016/09/06/VIDEi01SvSp5yHAauwCq5AV4160906.shtml
     * focus_date : 1473108036000
     */

    @SerializedName("list")
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }


}
