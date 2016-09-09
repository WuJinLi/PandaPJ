package com.example.my.panda.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.my.panda.R;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.adapter.cultureadapter.CultureViewPagerAdapter;
import com.example.my.panda.adapter.cultureadapter.MyListViewAdapter;
import com.example.my.panda.bean.VideoUrlBean;
import com.example.my.panda.bean.culture.Culture;
import com.example.my.panda.bean.culture.CultureBigImgBean;
import com.example.my.panda.bean.culture.CultureListBean;

import com.example.my.panda.utils.URLContract;
import com.example.my.panda.widget.MyListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 熊猫文化碎片
 */
public class PandaCultureFragment extends Fragment {
    private List<CultureBigImgBean> listBigImg = new ArrayList<>();
    private List<CultureListBean> list = new ArrayList<>();
    private MyListViewAdapter myListViewAdapter;
    private CultureViewPagerAdapter cultureViewPagerAdapter;
    private ViewPager viewpager_culture;
    private com.example.my.panda.widget.MyListView listView_culture_list;
    private Context mContext;
    private String videoUrl;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    cultureViewPagerAdapter = new CultureViewPagerAdapter(mContext, listBigImg);
                    viewpager_culture.setAdapter(cultureViewPagerAdapter);
                    viewpager_culture.setOffscreenPageLimit(2);

                    myListViewAdapter = new MyListViewAdapter(mContext, list);
                    listView_culture_list.setAdapter(myListViewAdapter);
                    listView_culture_list.setOnItemClickListener(new AdapterView
                            .OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                                long id) {

                            CultureListBean item = (CultureListBean) myListViewAdapter.getItem
                                    (position);
                            String id1 = item.getId();
                            getVideoUrl(id1);
                        }
                    });
                    break;
                case 3:
                    Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    getActivity().startActivity(intent);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_culture, container, false);
        viewpager_culture = (ViewPager) view.findViewById(R.id.viewpager_culture);
        listView_culture_list = (MyListView) view.findViewById(R.id.listView_culture_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(URLContract.CULTURE_URL).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody body = response.body();
                String jsonString = body.string();
                Gson gson = new Gson();
                Culture culture = gson.fromJson(jsonString, new TypeToken<Culture>() {
                }.getType());
                listBigImg = culture.getBigImg();
                list = culture.getList();
                handler.sendEmptyMessage(1);
            }
        });
    }


    public void getVideoUrl(String url) {
        String path = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=" + url;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
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
                VideoUrlBean videoUrlBean = gson.fromJson(jsonString, new TypeToken<VideoUrlBean>
                        () {
                }.getType());
                videoUrl = videoUrlBean.getVideo().getChapters().get(0).getUrl();
                if (videoUrl != null) {
                    handler.sendEmptyMessage(3);
                }
            }
        });
    }

}
