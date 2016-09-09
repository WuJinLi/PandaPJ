package com.example.my.panda.adapter.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.bean.home.HomePageBean;
import com.example.my.panda.bean.home.HomePageDataBean;
import com.example.my.panda.bean.home.VideoInfoBean;
import com.example.my.panda.utils.OkHttpClientHelper;
import com.example.my.panda.utils.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

/**
 * Created by virgil on 2016/7/29.
 * email 841864388@qq.com
 */
public class AdBannerAdapter extends RecyclerView.Adapter {
    private Context mContext = null;
    private List<HomePageDataBean.AreaBean.ListscrollBean> mList = null;
    private LayoutInflater mInflater = null;
    private OnItemClickedListener mListener = null;
    private Intent mIntent = new Intent();
    private Handler handler = new Handler();
    private String videoUrl = "";

    public AdBannerAdapter(Context context, List<HomePageDataBean.AreaBean.ListscrollBean> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public interface OnItemClickedListener {
        void onItemClick(int position);

        boolean onItemLongClick(int position);
    }

    public void setOnItemClickedListener(OnItemClickedListener _listener) {
        mListener = _listener;
    }

    /**
     * 通过打气筒获取view对象
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview_ad, parent, false);
        return new MyViewHolder(view);
    }

    /**
     * 给控件设置数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyViewHolder) {
            Glide.with(mContext).load(mList.get(position).getImage()).into(((MyViewHolder) holder).image_homepage_ad);
            ((MyViewHolder) holder).textview_homepage_adtitle.setText(mList.get(position).getTitle() + "");

        //点击播放视频
            ((MyViewHolder) holder).image_homepage_ad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取数据网址
                    String url = UrlConfig.RECOMMEND_LIVE + mList.get(position).getPid();
                    //网络访问获取视频播放的网址
                    loadVideoPlayUrlData(url);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //定义item布局中的控件
        ImageView image_homepage_ad;
        TextView textview_homepage_adtitle;

        /**
         * 在构造方法中对控件进行初始化
         *
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            image_homepage_ad = (ImageView) itemView.findViewById(R.id.image_homepage_ad);
            textview_homepage_adtitle = (TextView) itemView.findViewById(R.id.textview_homepage_adtitle);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Gson解析、刷新GridView数据
    ///////////////////////////////////////////////////////////////////////////

    /**
     * @param jsonString
     * @return
     */
    public HomePageBean parseJsonToAdBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<HomePageBean>() {
        }.getType());
    }

    /**
     * 解析视频播放地址数据
     *
     * @param jsonString
     * @return
     */
    public VideoInfoBean parseJsonToVideoPlayBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<VideoInfoBean>() {
        }.getType());
    }

    /**
     * 刷新数据
     *
     * @param _list
     * @param isClear
     */
    public void reloadRecyclerView(List<HomePageDataBean.AreaBean.ListscrollBean> _list, boolean isClear) {
        if (isClear) {
            mList.clear();
        }
        mList.addAll(_list);
        notifyDataSetChanged();
    }

    /**
     * 获取视频播放的地址
     *
     * @param url
     */
    public void loadVideoPlayUrlData(final String url) {
        //开启子线程网络访问数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //网络访问获取json串
                    String jsonString_video = OkHttpClientHelper.getStringFromURL(mContext, url, "video");
                    //Gson解析获取实体类对象
                    VideoInfoBean videoInfoBean = parseJsonToVideoPlayBean(jsonString_video);
                    //通过实体对象获取横幅的集合
                    videoUrl = videoInfoBean.getVideo().getChapters().get(0).getUrl();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mIntent.setClass(mContext, VideoPlayerActivity.class);
                            mIntent.putExtra("videoUrl", videoUrl);
                            mContext.startActivity(mIntent);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
