package com.example.my.panda.bean.culture;

import com.google.gson.annotations.SerializedName;

public  class CultureListBean {
        @SerializedName("url")
        private String url;
        @SerializedName("image")
        private String image;
        @SerializedName("title")
        private String title;
        @SerializedName("brief")
        private String brief;
        @SerializedName("type")
        private String type;
        @SerializedName("videoLength")
        private String videoLength;
        @SerializedName("id")
        private String id;
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

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }