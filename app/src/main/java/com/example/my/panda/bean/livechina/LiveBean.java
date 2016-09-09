package com.example.my.panda.bean.livechina;

import com.google.gson.annotations.SerializedName;

public  class LiveBean {
        @SerializedName("title")
        private String title;
        @SerializedName("brief")
        private String brief;
        @SerializedName("image")
        private String image;
        @SerializedName("id")
        private String id;
        @SerializedName("order")
        private String order;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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