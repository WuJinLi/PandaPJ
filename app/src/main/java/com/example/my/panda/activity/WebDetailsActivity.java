package com.example.my.panda.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.my.panda.R;
import com.example.my.panda.bean.collect.CollectBean;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class WebDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar_webDetails;
    private ImageView collect;
    private ImageView share;
    private WebView webDetails_webDetails;
    private String url;
    private String image;
    private String title;
    private Context mContext;
    private boolean isCollect=false;
    public static List<CollectBean> list_collect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_details);
        mContext = this;
        ShareSDK.initSDK(mContext, "sharesdk的appkey");
        initView();
        initData();
        createMore();
        //点击按钮进行分享
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
        //点击收藏
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectBean collectBean = new CollectBean(image, title, url);
                try {
                    list_collect = StartActivity.dbUtils.findAll(CollectBean.class);
                    if (list_collect != null) {
                        Log.i("msg", "!null ");
                        //与数据库中的每一个元素比对，是否重复
                        for (int i = 0; i < list_collect.size(); i++) {
                            if (title.equals(list_collect.get(i).getTitle())) {
                                isCollect=true;
                                break;
                            }
                        }
                        //如果重复，给予用户提示
                        if(isCollect){
                            Toast.makeText(mContext, "请勿重复收藏", Toast.LENGTH_LONG).show();
                        }else{
                            //利用框架向数据库存储数据
                            StartActivity.dbUtils.save(collectBean);
                            //向list总添加数据
                            list_collect.add(collectBean);
                            //用户提示，添加成功
                            Toast.makeText(mContext, "收藏成功", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        StartActivity.dbUtils.save(collectBean);
                        Toast.makeText(mContext, "收藏成功", Toast.LENGTH_LONG).show();
                    }
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData() {
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        image = getIntent().getStringExtra("image");
        toolbar_webDetails.setTitle("");
        setSupportActionBar(toolbar_webDetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        toolbar_webDetails = (Toolbar) findViewById(R.id.toolbar_webDetails);
        collect = (ImageView) findViewById(R.id.collect);
        share = (ImageView) findViewById(R.id.share);
        webDetails_webDetails = (WebView) findViewById(R.id.webDetails_webDetails);
    }

    private void createMore() {
        //让webView_more代替系统浏览器
        webDetails_webDetails.setWebViewClient(new WebViewClient());
        //让WebView支持alert这些特殊的javascript语句
        webDetails_webDetails.setWebChromeClient(new WebChromeClient());
        //让WebView支持普通的JavaScript语句
        webDetails_webDetails.getSettings().setJavaScriptEnabled(true);
        webDetails_webDetails.getSettings().setUseWideViewPort(true);//web1就是你自己定义的窗口对象。
        webDetails_webDetails.getSettings().setLoadWithOverviewMode(true);
        //为webView_more设置加载网址
        webDetails_webDetails.loadUrl(url);
    }


    //点击toolbar返回上一级
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    //三方分享的方法
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

}
