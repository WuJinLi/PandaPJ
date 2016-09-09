package com.example.my.panda.bean.eye;

import com.google.gson.annotations.SerializedName;

public  class ListBean {
        @SerializedName("num")
        private int num;
        @SerializedName("datatype")
        private String datatype;
        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("videolength")
        private String videolength;
        @SerializedName("guid")
        private String guid;
        @SerializedName("picurl")
        private String picurl;
        @SerializedName("picurl2")
        private String picurl2;
        @SerializedName("picurl3")
        private String picurl3;
        @SerializedName("url")
        private String url;
        @SerializedName("focus_date")
        private long focusDate;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getDatatype() {
            return datatype;
        }

        public void setDatatype(String datatype) {
            this.datatype = datatype;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideolength() {
            return videolength;
        }

        public void setVideolength(String videolength) {
            this.videolength = videolength;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getPicurl2() {
            return picurl2;
        }

        public void setPicurl2(String picurl2) {
            this.picurl2 = picurl2;
        }

        public String getPicurl3() {
            return picurl3;
        }

        public void setPicurl3(String picurl3) {
            this.picurl3 = picurl3;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getFocusDate() {
            return focusDate;
        }

        public void setFocusDate(long focusDate) {
            this.focusDate = focusDate;
        }
    }