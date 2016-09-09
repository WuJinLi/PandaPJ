package com.example.my.panda.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.panda.R;
import com.example.my.panda.fragment.PandaChinaLiveFragment;
import com.example.my.panda.fragment.PandaCultureFragment;
import com.example.my.panda.fragment.PandaEyeFragment;
import com.example.my.panda.fragment.PandaHomeFragment;
import com.example.my.panda.fragment.PandaLiveFragment;

public class MainActivity extends AppCompatActivity {
    //声明碎片
    private PandaChinaLiveFragment chinaLiveFragment;
    private PandaHomeFragment homeFragment;
    private PandaCultureFragment cultureFragment;
    private PandaEyeFragment eyeFragment;
    private PandaLiveFragment pandaLiveFragment;
    //声明碎片管理者
    private FragmentManager manager;
    //声明按钮
    private Button button_main_home;
    private Button button_main_panda_eye;
    private Button button_main_panda_culture;
    private Button button_main_panda_live;
    private Button button_main_live_china;
    private Toolbar toolbar_main;
    private TextView textview_mian_title;
    private ImageView imageview_main_hudong;
    private ImageView imageview_main_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        imageview_main_hudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HuDongActivity.class));
            }
        });

        imageview_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PersonalActivity.class));
            }
        });
    }

    private void initView() {
        button_main_home = (Button) findViewById(R.id.button_main_home);
        button_main_panda_eye = (Button) findViewById(R.id.button_main_panda_eye);
        button_main_panda_culture = (Button) findViewById(R.id.button_main_panda_culture);
        button_main_panda_live = (Button) findViewById(R.id.button_main_panda_live);
        button_main_live_china = (Button) findViewById(R.id.button_main_live_china);
        textview_mian_title = (TextView) findViewById(R.id.textview_mian_title);
        toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
        imageview_main_login = (ImageView) findViewById(R.id.imageview_main_login);
        imageview_main_hudong = (ImageView) findViewById(R.id.imageview_main_hudong);
    }

    private void initData() {
        manager = getSupportFragmentManager();
        setSection(0);
        toolbar_main.setTitle("");
        setSupportActionBar(toolbar_main);
        button_main_home.setSelected(true);
        button_main_home.setBackgroundResource(R.color.c11);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_main_home:
                button_main_home.setSelected(true);
                button_main_panda_eye.setSelected(false);
                button_main_panda_culture.setSelected(false);
                button_main_panda_live.setSelected(false);
                button_main_live_china.setSelected(false);

                button_main_home.setBackgroundResource(R.color.c11);
                button_main_panda_eye.setBackgroundResource(R.color.transparent);
                button_main_panda_culture.setBackgroundResource(R.color.transparent);
                button_main_panda_live.setBackgroundResource(R.color.transparent);
                button_main_live_china.setBackgroundResource(R.color.transparent);
                textview_mian_title.setText("");
                setSupportActionBar(toolbar_main);
                imageview_main_hudong.setVisibility(View.VISIBLE);
                setSection(0);
                break;
            case R.id.button_main_panda_eye:
                button_main_home.setSelected(false);
                button_main_panda_eye.setSelected(true);
                button_main_panda_culture.setSelected(false);
                button_main_panda_live.setSelected(false);
                button_main_live_china.setSelected(false);
                button_main_home.setBackgroundResource(R.color.transparent);
                button_main_panda_eye.setBackgroundResource(R.color.c11);
                button_main_panda_culture.setBackgroundResource(R.color.transparent);
                button_main_panda_live.setBackgroundResource(R.color.transparent);
                button_main_live_china.setBackgroundResource(R.color.transparent);
                textview_mian_title.setText("熊猫观察");
                setSupportActionBar(toolbar_main);
                imageview_main_hudong.setVisibility(View.INVISIBLE);
                setSection(1);
                break;
            case R.id.button_main_panda_culture:
                button_main_home.setSelected(false);
                button_main_panda_eye.setSelected(false);
                button_main_panda_culture.setSelected(true);
                button_main_panda_live.setSelected(false);
                button_main_live_china.setSelected(false);

                button_main_home.setBackgroundResource(R.color.transparent);
                button_main_panda_eye.setBackgroundResource(R.color.transparent);
                button_main_panda_culture.setBackgroundResource(R.color.c11);
                button_main_panda_live.setBackgroundResource(R.color.transparent);
                button_main_live_china.setBackgroundResource(R.color.transparent);
                setSection(2);
                imageview_main_hudong.setVisibility(View.INVISIBLE);
                textview_mian_title.setText("熊猫文化");
                setSupportActionBar(toolbar_main);
                break;
            case R.id.button_main_panda_live:
                button_main_home.setSelected(false);
                button_main_panda_eye.setSelected(false);
                button_main_panda_culture.setSelected(false);
                button_main_panda_live.setSelected(true);
                button_main_live_china.setSelected(false);

                button_main_home.setBackgroundResource(R.color.transparent);
                button_main_panda_eye.setBackgroundResource(R.color.transparent);
                button_main_panda_culture.setBackgroundResource(R.color.transparent);
                button_main_panda_live.setBackgroundResource(R.color.c11);
                button_main_live_china.setBackgroundResource(R.color.transparent);
                textview_mian_title.setText("熊猫直播");
                setSupportActionBar(toolbar_main);
                imageview_main_hudong.setVisibility(View.INVISIBLE);
                setSection(3);
                break;


            case R.id.button_main_live_china:
                button_main_home.setSelected(false);
                button_main_panda_eye.setSelected(false);
                button_main_panda_culture.setSelected(false);
                button_main_panda_live.setSelected(false);
                button_main_live_china.setSelected(true);

                button_main_home.setBackgroundResource(R.color.transparent);
                button_main_panda_eye.setBackgroundResource(R.color.transparent);
                button_main_panda_culture.setBackgroundResource(R.color.transparent);
                button_main_panda_live.setBackgroundResource(R.color.transparent);
                button_main_live_china.setBackgroundResource(R.color.c11);
                textview_mian_title.setText("直播中国");
                setSupportActionBar(toolbar_main);
                setSection(4);
                imageview_main_hudong.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void setSection(int tabIndex) {
        FragmentTransaction ft = manager.beginTransaction();
        hindFragment(ft);
        switch (tabIndex) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new PandaHomeFragment();
                    ft.add(R.id.frameLayout_container, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (eyeFragment == null) {
                    eyeFragment = new PandaEyeFragment();
                    ft.add(R.id.frameLayout_container, eyeFragment);
                } else {
                    ft.show(eyeFragment);
                }
                break;
            case 2:
                if (cultureFragment == null) {
                    cultureFragment = new PandaCultureFragment();
                    ft.add(R.id.frameLayout_container, cultureFragment);
                } else {
                    ft.show(cultureFragment);
                }
                break;
            case 3:
                if (pandaLiveFragment == null) {
                    pandaLiveFragment = new PandaLiveFragment();
                    ft.add(R.id.frameLayout_container, pandaLiveFragment);
                } else {
                    ft.show(pandaLiveFragment);
                }
                break;


            case 4:
                if (chinaLiveFragment == null) {
                    chinaLiveFragment = new PandaChinaLiveFragment();
                    ft.add(R.id.frameLayout_container, chinaLiveFragment);
                } else {
                    ft.show(chinaLiveFragment);
                }
                break;
        }
        ft.commit();
    }

    public void hindFragment(FragmentTransaction ft) {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (chinaLiveFragment != null) {
            ft.hide(chinaLiveFragment);
        }
        if (cultureFragment != null) {
            ft.hide(cultureFragment);
        }
        if (eyeFragment != null) {
            ft.hide(eyeFragment);
        }
        if (pandaLiveFragment != null) {
            ft.hide(pandaLiveFragment);
        }
    }
}
