package com.example.my.panda.fragment.livechinafragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.my.panda.R;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.adapter.livechinaadapter.LiveChinaAdapter;
import com.example.my.panda.bean.livechina.DetailsBean;
import com.example.my.panda.bean.livechina.LiveChinaBean;
import com.example.my.panda.bean.livechina.TablistBean;
import com.example.my.panda.bean.pandlive.LiveBean;
import com.example.my.panda.utils.URLContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by My on 2016/9/6.
 */
public class LiveChinaFragment extends Fragment {
    private int tabIndex;
    private Context mContext;
    private TextView textview;
    private List<TablistBean> tabList = new ArrayList<>();
    private List<com.example.my.panda.bean.livechina.LiveBean> live = new ArrayList<>();
    private com.handmark.pulltorefresh.library.PullToRefreshListView listviewpull;
    private LiveChinaAdapter liveChinaAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    switch (tabIndex) {
                        case 0:
                            getListFromNet(tabList.get(tabIndex).getUrl());
                            break;
                        case 1:
                            getListFromNet(tabList.get(tabIndex).getUrl());
                            break;
                        case 2:
                            getListFromNet(tabList.get(tabIndex).getUrl());
                            break;
                        case 3:
                            getListFromNet(tabList.get(tabIndex).getUrl());
                            break;
                    }
                    break;

                case 2:
                    switch (tabIndex) {
                        case 0:
                            initListView(live);
                            break;
                        case 1:
                            initListView(live);
                            break;
                        case 2:
                            initListView(live);
                            break;
                        case 3:
                            initListView(live);
                            break;
                    }
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabIndex = getArguments().getInt("tabIndex");
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_livechina, container, false);
        //textview = (TextView) view.findViewById(R.id.textview);
        listviewpull = (PullToRefreshListView) view.findViewById(R.id.listview_livechina);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLiveChinaFromNet(URLContract.LIVECHINA_URL);
    }

    public static LiveChinaFragment newInstance(int tabIndex) {

        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", tabIndex);
        LiveChinaFragment fragment = new LiveChinaFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    //获取网络数据
    public void getLiveChinaFromNet(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
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
                LiveChinaBean liveChinaBean = gson.fromJson(jsonString, new
                        TypeToken<LiveChinaBean>() {
                        }.getType());
                ;
                tabList = liveChinaBean.getTablist();
                handler.sendEmptyMessage(1);
            }
        });
    }


    public void getListFromNet(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
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
                DetailsBean detailsBean = gson.fromJson(jsonString, new
                        TypeToken<DetailsBean>() {
                        }.getType());
                live = detailsBean.getLive();
                handler.sendEmptyMessage(2);
            }
        });
    }

    public void initListView(List<com.example.my.panda.bean.livechina.LiveBean> live) {
        liveChinaAdapter = new LiveChinaAdapter(mContext, live);
        listviewpull.setAdapter(liveChinaAdapter);
    }

}
