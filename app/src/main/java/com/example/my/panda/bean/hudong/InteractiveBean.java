package com.example.my.panda.bean.hudong;

import com.google.gson.annotations.SerializedName;

public  class InteractiveBean {
        @SerializedName("image")
        private String image;
        @SerializedName("title")
        private String title;
        @SerializedName("url")
        private String url;
        @SerializedName("order")
        private String order;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }