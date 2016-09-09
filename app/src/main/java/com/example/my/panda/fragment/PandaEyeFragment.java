package com.example.my.panda.fragment;

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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.activity.WebDetailsActivity;
import com.example.my.panda.adapter.eyeadapter.EyeListViewAdapter;
import com.example.my.panda.bean.VideoUrlBean;
import com.example.my.panda.bean.eye.BigImgBean;
import com.example.my.panda.bean.eye.EyeBean;
import com.example.my.panda.bean.eye.EyeBigImgBean;
import com.example.my.panda.bean.eye.EyeListBean;
import com.example.my.panda.bean.eye.ListBean;
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
 * 熊猫观察的碎片
 */
public class PandaEyeFragment extends Fragment {
    private ImageView imageview_eye_icon;
    private com.example.my.panda.widget.MyListView listview_eye_list;
    private List<BigImgBean> bigImg = new ArrayList<>();
    private List<ListBean> list = new ArrayList<>();
    private String listurl;
    private Context mContext;
    private EyeListViewAdapter eyeListViewAdapter;
    private String videoUrl;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    Glide.with(PandaEyeFragment.this).load(bigImg.get(0).getImage()).into
                            (imageview_eye_icon);
                    //点击图片，进行页面跳转
                    imageview_eye_icon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, WebDetailsActivity.class);
                            String url = bigImg.get(0).getUrl();
                            String image = bigImg.get(0).getImage();
                            String title = bigImg.get(0).getTitle();
                            intent.putExtra("url", url);
                            intent.putExtra("image", image);
                            intent.putExtra("title", title);
                            mContext.startActivity(intent);
                        }
                    });
                    getListFromNet(listurl);
                    break;
                case 2:
                    eyeListViewAdapter = new EyeListViewAdapter(mContext, list);
                    listview_eye_list.setAdapter(eyeListViewAdapter);

                    listview_eye_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            ListBean listBean= (ListBean) eyeListViewAdapter.getItem(position);
                            String guid = listBean.getGuid();
                            getVideoUrl(guid);
                        }
                    });
                    break;
                case 3:
                    Intent intent=new Intent(getActivity(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl",videoUrl);
                    getActivity().startActivity(intent);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eye, container, false);
        imageview_eye_icon = (ImageView) view.findViewById(R.id.imageview_eye_icon);
        listview_eye_list = (MyListView) view.findViewById(R.id.listview_eye_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(URLContract.EYE_URL).build();
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
                EyeBean eyeBean = gson.fromJson(jsonString, new TypeToken<EyeBean>() {
                }.getType());
                EyeBigImgBean data = eyeBean.getData();
                //获取观察顶端图片对象
                bigImg = data.getBigImg();
                //获取观察下端的list集合的网址
                listurl = data.getListurl();
                handler.sendEmptyMessage(1);
            }
        });
    }

    public void getListFromNet(String listurl) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(listurl).build();
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
                EyeListBean eyeListBean = gson.fromJson(jsonString, new TypeToken<EyeListBean>() {
                }.getType());
                list = eyeListBean.getList();
                handler.sendEmptyMessage(2);
            }
        });
    }

    public void getVideoUrl(String url){
        String path="http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+url;
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(path).build();
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
                videoUrl=videoUrlBean.getVideo().getChapters().get(0).getUrl();
                handler.sendEmptyMessage(3);
            }
        });
    }
}
