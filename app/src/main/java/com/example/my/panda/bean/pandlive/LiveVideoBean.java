package com.example.my.panda.bean.pandlive;

import com.google.gson.annotations.SerializedName;

public  class LiveVideoBean {
        @SerializedName("vsid")
        private String vsid;
        @SerializedName("order")
        private String order;
        @SerializedName("vid")
        private String vid;
        @SerializedName("t")
        private String t;
        @SerializedName("url")
        private String url;
        @SerializedName("ptime")
        private String ptime;
        @SerializedName("img")
        private String img;
        @SerializedName("len")
        private String len;
        @SerializedName("em")
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }