package com.example.my.panda.activity;

import android.content.Context;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.home.ArticleBean;
import com.example.my.panda.bean.home.HomePageBean;
import com.example.my.panda.bean.home.HomePageCCTVBean;
import com.example.my.panda.bean.home.HomePagePandaeyeBean;
import com.example.my.panda.utils.OkHttpClientHelper;
import com.example.my.panda.utils.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

public class ArticleActivity extends AppCompatActivity implements SwipeBackActivityBase {
    private TextView mTextview_content;
    private TextView mTextview_article_title;
    private TextView mTextview_article_source;
    private TextView mTextview_article_pubtime;
    private ImageView mImage_article_logo;
    private Handler handler = new Handler();
    private Context mContext = this;
    private SwipeBackActivityHelper mHelper;//侧滑返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        //创建侧滑返回的对象
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        intitView();
        initData();
    }

    private void intitView() {
        mTextview_article_title = (TextView) findViewById(R.id.textview_article_title);
        mTextview_article_source = (TextView) findViewById(R.id.textview_article_source);
        mTextview_article_pubtime = (TextView) findViewById(R.id.textview_article_pubtime);
        mImage_article_logo = (ImageView) findViewById(R.id.image_article_logo);
        mTextview_content = (TextView) findViewById(R.id.textview_content);
    }

    private void initData() {
        //开启子线程网络访问数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //网络访问获取json串
                    String jsonString_Comment = OkHttpClientHelper.getStringFromURL(mContext, UrlConfig.COMMENT, "comment");
                    //Gson解析获取主页实体类对象
                    final ArticleBean articleBean = parseJsonToArticleBean(jsonString_Comment);
                    //刷新数据
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mTextview_article_title.setText(articleBean.getTitle() + "");
                            mTextview_article_source.setText(articleBean.getSource() + "");
                            mTextview_article_pubtime.setText(articleBean.getPubtime() + "");
                            Glide.with(mContext).load(articleBean.getLogo() + "").into(mImage_article_logo);
                            mTextview_content.setText(Html.fromHtml(articleBean.getContent()));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * @param jsonString
     * @return
     */
    public ArticleBean parseJsonToArticleBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<ArticleBean>() {
        }.getType());
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
