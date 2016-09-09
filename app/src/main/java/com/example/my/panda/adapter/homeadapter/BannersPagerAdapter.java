package com.example.my.panda.adapter.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;

import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.bean.home.HomePageBean;
import com.example.my.panda.bean.home.HomePageCCTVBean;
import com.example.my.panda.bean.home.HomePageDataBean;
import com.example.my.panda.bean.home.HomePagePandaeyeBean;
import com.example.my.panda.bean.home.VideoInfoBean;
import com.example.my.panda.utils.OkHttpClientHelper;
import com.example.my.panda.utils.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by virgil on 2016/7/22.
 */
public class BannersPagerAdapter extends PagerAdapter {
    private ImageView mImage_homepage_banner;
    private Context mContext = null;
    private List<HomePageDataBean.BigImgBean> mList = new ArrayList<>();
    private LayoutInflater mInflater = null;
    private Intent mIntent = new Intent();
    private Handler handler = new Handler();
    private String videoUrl = "";

    public BannersPagerAdapter(Context context, List<HomePageDataBean.BigImgBean> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * isViewFromObject是在infoForChild里被调用的，
     * 而且在该方法内会被调用mItems.size()次，mItems.size()是 ViewPager 里面图片的个数
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.item_homepage_banners, container, false);
        //初始化填充的布局上的UI控件
        mImage_homepage_banner = (ImageView) view.findViewById(R.id.image_homepage_banner);
        //加载网络图片,显示到控件上
        //Log.i("地址", "------>>>" + mList.get(position).getImage() + "");
        Glide.with(mContext).load(mList.get(position).getImage()).into(mImage_homepage_banner);
        container.addView(view);

        //点击播放视频
        mImage_homepage_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取数据网址
                //String url = UrlConfig.BANNER_LIVE + mList.get(position).getPid();
                //网络访问获取视频播放的网址
                //loadVideoPlayUrlData(url);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
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
    public void reloadPagerView(List<HomePageDataBean.BigImgBean> _list, boolean isClear) {
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
