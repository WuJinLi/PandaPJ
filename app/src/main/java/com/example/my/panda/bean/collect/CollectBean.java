package com.example.my.panda.bean.collect;

/**
 * Created by My on 2016/9/8.
 */
public class CollectBean {
    private int id;
    private String image;
    private String title;
    private String url;

    public CollectBean() {
    }

    public CollectBean(String image, String title, String url) {
        this.image = image;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
