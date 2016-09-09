package com.example.my.panda.utils;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;


/**
 * Created by virgil on 16/8/4.
 */
public class MyApplication extends Application {

    private static final String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();
        //调用初始化OkHttp框架的方法
        initOkHttp();
    }

    /**
     * 初始化OKHttp框架
     */
    private void initOkHttp() {
        //单例获取OkHttpClient对象
        OkHttpClient okHttpClient = OkHttpClientHelper.getOkHttpSingletonInstance();
    }

}
