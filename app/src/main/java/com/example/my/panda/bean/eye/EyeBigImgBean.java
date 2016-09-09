package com.example.my.panda.bean.eye;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class EyeBigImgBean {
        @SerializedName("listurl")
        private String listurl;
        /**
         * image : http://p1.img.cctvpic
         * .com/photoAlbum/page/performance/img/2016/9/5/1473059138112_444.jpg
         * title : 论道G20：习主席的演讲彰显中国对全球治理的领导力
         * url : http://panview.ipanda.com/2016/09/05/ARTINZgCpdcPCLDaBBNLkQsQ160905.shtml
         * id : ARTINZgCpdcPCLDaBBNLkQsQ160905
         * type : 5
         * stype : 
         * pid : 
         * vid : 
         * order : 1
         */

        @SerializedName("bigImg")
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }


    }