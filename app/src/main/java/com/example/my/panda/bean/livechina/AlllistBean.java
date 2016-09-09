package com.example.my.panda.bean.livechina;

import com.google.gson.annotations.SerializedName;

public class AlllistBean {
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("type")
    private String type;
    @SerializedName("order")
    private String order;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}