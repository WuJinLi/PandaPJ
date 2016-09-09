package com.example.my.panda.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.my.panda.R;
import com.lidroid.xutils.DbUtils;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    public static DbUtils dbUtils;//操作数据库对象的创建
    private Context mContext = this;//上下文对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbUtils = DbUtils.create(mContext, "collect");
        setContentView(R.layout.activity_start);
        //调用初始化控件的方法
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //小勇页面跳转的方法
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        };
        timer.schedule(task, 2000);
    }

}
