package com.example.my.panda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.my.panda.R;
import com.example.my.panda.adapter.hodongadapter.HuDongAdapter;
import com.example.my.panda.bean.hudong.HuDongBean;
import com.example.my.panda.bean.hudong.InteractiveBean;
import com.example.my.panda.utils.URLContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

public class HuDongActivity extends AppCompatActivity implements SwipeBackActivityBase {

    private ImageView imageview_personal_back;
    private com.handmark.pulltorefresh.library.PullToRefreshListView listview_hudong_list;
    private SwipeBackActivityHelper mHelper;//侧滑返回
    private List<InteractiveBean> list = new ArrayList<>();
    private HuDongAdapter huDongAdapter;
    private Context mContext = this;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    huDongAdapter.reLoad(list, true);
                    listview_hudong_list.setAdapter(huDongAdapter);
                    listview_hudong_list.onRefreshComplete();

                    listview_hudong_list.setOnItemClickListener(new AdapterView
                            .OnItemClickListener() {


                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                                long id) {

                            InteractiveBean interactiveBean = (InteractiveBean) huDongAdapter
                                    .getItem(position);
                            String url = interactiveBean.getUrl();
                            String image = interactiveBean.getImage();
                            String title = interactiveBean.getTitle();
                            Intent intent = new Intent(HuDongActivity.this, WebDetailsActivity
                                    .class);
                            intent.putExtra("url", url);
                            intent.putExtra("image", image);
                            intent.putExtra("title", title);
                            startActivity(intent);
                        }
                    });
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong);
        //创建侧滑返回的对象
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        initView();
        initData();
        huDongAdapter = new HuDongAdapter(mContext, list);
        getDataFromNet();
        listview_hudong_list.setOnRefreshListener(new PullToRefreshBase
                .OnRefreshListener2<ListView>() {


            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                getDataFromNet();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            }
        });
    }

    private void getDataFromNet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(URLContract.HUDONG_URL).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String jsonString = response.body().string();
                Gson gson = new Gson();
                HuDongBean huDongBean = gson.fromJson(jsonString, new TypeToken<HuDongBean>() {
                }.getType());
                list = huDongBean.getInteractive();
                handler.sendEmptyMessage(1);
            }
        });
    }

    private void initData() {
        imageview_personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView() {
        imageview_personal_back = (ImageView) findViewById(R.id.imageview_personal_back);
        listview_hudong_list = (PullToRefreshListView) findViewById(R.id.listview_hudong_list);
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
