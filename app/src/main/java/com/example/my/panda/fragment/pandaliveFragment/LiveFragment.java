package com.example.my.panda.fragment.pandaliveFragment;

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
import android.widget.GridView;
import android.widget.ListView;

import com.example.my.panda.R;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.adapter.pandaliveadapter.PandaLiveGridViewAdapter;
import com.example.my.panda.adapter.pandaliveadapter.PandaLiveSplendidAdapter;
import com.example.my.panda.bean.VideoUrlBean;
import com.example.my.panda.bean.pandlive.LiveBean;
import com.example.my.panda.bean.pandlive.LiveListBean;
import com.example.my.panda.bean.pandlive.LiveSplendidBean;
import com.example.my.panda.bean.pandlive.LiveVideoBean;
import com.example.my.panda.utils.URLContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
public class LiveFragment extends Fragment {
    private int tabIndex;
    private PandaLiveGridViewAdapter pandaLiveGridViewAdapter;
    private GridView gridview_pandalive_gridview;
    private List<LiveListBean> list_live = new ArrayList<>();
    private List<LiveVideoBean> list_video = new ArrayList<>();
    private Context mContext;
    private ListView listview_splendid;
    private PandaLiveSplendidAdapter pandaLiveSplendidAdapter;
    private String videoUrl;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    pandaLiveGridViewAdapter = new PandaLiveGridViewAdapter(mContext, list_live);
                    gridview_pandalive_gridview.setAdapter(pandaLiveGridViewAdapter);
                    break;
                case 2:
                    pandaLiveSplendidAdapter = new PandaLiveSplendidAdapter(mContext, list_video);
                    listview_splendid.setAdapter(pandaLiveSplendidAdapter);
                    listview_splendid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                                long id) {

                            LiveVideoBean liveVideoBean = (LiveVideoBean)
                                    pandaLiveSplendidAdapter.getItem(position);
                            String vid = liveVideoBean.getVid();
                            getVideoUrl(vid);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        tabIndex = arguments.getInt("tabIndex");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = null;
        switch (tabIndex) {
            case 0:
                view = inflater.inflate(R.layout.fragment_panda_live_live, container, false);
                gridview_pandalive_gridview = (GridView) view.findViewById(R.id
                        .gridview_pandalive_gridview);

                break;
            case 1:
                view = inflater.inflate(R.layout.fragment_panda_live_splendid, container, false);
                listview_splendid = (ListView) view.findViewById(R.id.listview_splendid);
                break;
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Gson gson = new Gson();
        switch (tabIndex) {
            case 0:
                Request request = new Request.Builder().url(URLContract.LIVE_URL).build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String jsonString = response.body().string();
                        LiveBean liveBean = gson.fromJson(jsonString, new TypeToken<LiveBean>() {
                        }.getType());
                        list_live = liveBean.getList();
                        handler.sendEmptyMessage(1);
                    }
                });
                break;
            case 1:
                Request request1 = new Request.Builder().url(URLContract.SPLENDID_URL).build();
                okHttpClient.newCall(request1).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String jsonString = response.body().string();
                        LiveSplendidBean liveSplendidBean = gson.fromJson(jsonString, new
                                TypeToken<LiveSplendidBean>() {
                                }.getType());
                        list_video = liveSplendidBean.getVideo();
                        handler.sendEmptyMessage(2);
                    }
                });
                break;
        }
    }

    public static LiveFragment newInstance(int tabIndex) {

        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", tabIndex);
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(bundle);
        return fragment;
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
                VideoUrlBean videoUrlBean = gson.fromJson(jsonString, new TypeToken<VideoUrlBean>() {
                }.getType());
                videoUrl = videoUrlBean.getVideo().getChapters().get(0).getUrl();
                handler.sendEmptyMessage(3);
            }
        });
    }
}
