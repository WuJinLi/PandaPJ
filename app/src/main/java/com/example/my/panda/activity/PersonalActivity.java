package com.example.my.panda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.my.panda.R;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

public class PersonalActivity extends AppCompatActivity implements SwipeBackActivityBase {

    private ImageView imageview_personal_back;
    private RelativeLayout touch_login;
    private RelativeLayout touch_collect;
    private RelativeLayout touch_setting;
    private SwipeBackActivityHelper mHelper;//侧滑返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        //创建侧滑返回的对象
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        initView();
        initData();
    }

    private void initData() {
        //顶部返回点击事件
        imageview_personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //登陆页面跳转
        touch_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalActivity.this, LoginActivity.class));
            }
        });




        //收藏页面跳转
        touch_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalActivity.this, CollectActivity.class));
            }
        });


        //设置页面跳转
        touch_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalActivity.this, SettingActivity.class));
            }
        });

    }

    private void initView() {
        touch_login = (RelativeLayout) findViewById(R.id.touch_login);
        touch_setting = (RelativeLayout) findViewById(R.id.touch_setting);
        touch_collect = (RelativeLayout) findViewById(R.id.touch_collect);
        imageview_personal_back = (ImageView) findViewById(R.id.imageview_personal_back);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    ///////////////////////////////////////////////////////////////////////////
    // SwipeBackActivityBase中的抽象方法
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
