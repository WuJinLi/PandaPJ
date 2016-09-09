package com.example.my.panda.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.panda.R;
import com.example.my.panda.utils.DataCleanManager;

public class SettingActivity extends AppCompatActivity {

    private ImageView imageview_setting_clear;
    private TextView textview_setting_cache;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        try {
            textview_setting_cache.setText(DataCleanManager.getTotalCacheSize(mContext));
        } catch (Exception e) {
            e.printStackTrace();
        }
        imageview_setting_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("确认清除缓存吗？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataCleanManager.clearAllCache(mContext);
                                try {
                                    textview_setting_cache.setText(DataCleanManager
                                                .getTotalCacheSize(mContext));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                builder.show();
            }
        });
    }

    private void initView() {
        imageview_setting_clear = (ImageView) findViewById(R.id.imageview_setting_clear);
        textview_setting_cache = (TextView) findViewById(R.id.textview_setting_cache);
    }
}
