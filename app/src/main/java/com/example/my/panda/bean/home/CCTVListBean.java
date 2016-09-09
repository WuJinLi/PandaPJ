package com.example.my.panda.bean.home;

import com.google.gson.annotations.SerializedName;

public class CCTVListBean {
        @SerializedName("url")
        private String url;
        @SerializedName("image")
        private String image;
        @SerializedName("title")
        private String title;
        @SerializedName("videoLength")
        private String videoLength;
        @SerializedName("id")
        private String id;
        @SerializedName("daytime")
        private String daytime;
        @SerializedName("type")
        private String type;
        @SerializedName("pid")
        private String pid;
        @SerializedName("vid")
        private String vid;
        @SerializedName("order")
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }