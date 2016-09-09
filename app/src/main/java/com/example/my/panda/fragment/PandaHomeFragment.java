package com.example.my.panda.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.activity.ArticleActivity;
import com.example.my.panda.activity.VideoPlayerActivity;
import com.example.my.panda.adapter.homeadapter.AdBannerAdapter;
import com.example.my.panda.adapter.homeadapter.BannersPagerAdapter;
import com.example.my.panda.adapter.homeadapter.CCTVRecyclerViewAdapter;
import com.example.my.panda.adapter.homeadapter.PandaeyeRecyclerViewAdapter;
import com.example.my.panda.bean.home.ArticleBean;
import com.example.my.panda.bean.home.CCTVListBean;
import com.example.my.panda.bean.home.HomePageBean;
import com.example.my.panda.bean.home.HomePageCCTVBean;
import com.example.my.panda.bean.home.HomePageDataBean;
import com.example.my.panda.bean.home.HomePagePandaeyeBean;
import com.example.my.panda.bean.home.ObserverBean;
import com.example.my.panda.bean.home.PandaListDataBean;
import com.example.my.panda.bean.home.VideoInfoBean;
import com.example.my.panda.bean.home.WatchChina;
import com.example.my.panda.utils.OkHttpClientHelper;
import com.example.my.panda.utils.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.my.panda.bean.home.HomePageDataBean.*;

/**
 * Created by My on 2016/9/5.
 */
public class PandaHomeFragment extends Fragment {
    private ViewPager mViewPager_homepage;
    private RecyclerView mRecyclerview_homepage_recommend;
    private Context mContext;
    private BannersPagerAdapter mBannersPagerAdapter;
    private PandaeyeRecyclerViewAdapter mPandaeyeRecyclerViewAdapter;
    private AdBannerAdapter mAdBannerAdapter;
    private List<BigImgBean> mList_Banner = new ArrayList<>();
    private List<AreaBean.ListscrollBean> mList_AreaBean = new ArrayList<>();
    private List<PandaeyeBean.ItemsBean> mList_Pandaeye = new ArrayList<>();
    private List<PandaListDataBean> mList_Pandaeyelist = new ArrayList<>();
    private ObserverBean mList_Observer;
    private Handler handler = new Handler();
    private TextView mTextview_homepage_comment_titlel;
    private TextView mTextview_homepage_hot_title;
    private ImageView mImage_homepage_observe;
    private RecyclerView mRecyclerview_homepage_pandaeyelist;
    private RecyclerView mRecyclerview_homepage_cctv;
    private CCTVRecyclerViewAdapter mCCTVRecyclerViewAdapter;
    private List<WatchChina.ListBean> mList_WatchChina = new ArrayList<>();
    private Intent mIntent = new Intent();
    private String videoUrl = "";
    private String videoUrl_WatchChina = "";
    private PullToRefreshScrollView mPulltorefreshscrollview_homepage;
    private int flag = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager_homepage = (ViewPager) view.findViewById(R.id.viewPager_homepage);
        mRecyclerview_homepage_recommend = (RecyclerView) view.findViewById(R.id.recyclerview_homepage_recommend);
        mTextview_homepage_comment_titlel = (TextView) view.findViewById(R.id.textview_homepage_comment_title);
        mTextview_homepage_hot_title = (TextView) view.findViewById(R.id.textview_homepage_hot_title);
        mImage_homepage_observe = (ImageView) view.findViewById(R.id.image_homepage_observe);
        mRecyclerview_homepage_pandaeyelist = (RecyclerView) view.findViewById(R.id.recyclerview_homepage_pandaeyelist);
        mRecyclerview_homepage_cctv = (RecyclerView) view.findViewById(R.id.recyclerview_homepage_cctv);
        mPulltorefreshscrollview_homepage = (PullToRefreshScrollView) view.findViewById(R.id.pulltorefreshscrollview_homepage);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        //时评点击事件
        mTextview_homepage_comment_titlel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent.setClass(mContext, ArticleActivity.class);
                mContext.startActivity(mIntent);
            }
        });
        //热门点击事件
        mTextview_homepage_hot_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoUrl = mList_Observer.getVideo().getChapters().get(0).getUrl();
                mIntent.setClass(mContext, VideoPlayerActivity.class);
                mIntent.putExtra("videoUrl", videoUrl);
                mContext.startActivity(mIntent);
            }
        });

        //熊猫直播两个视频的点击事件
        mPandaeyeRecyclerViewAdapter.setOnItemClickedListener(new PandaeyeRecyclerViewAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {
                String url = UrlConfig.BANNER_LIVE + mList_Pandaeyelist.get(position).getPid();
                loadObserverData(url);
            }
        });

        //G20看中国
        mCCTVRecyclerViewAdapter.setOnItemClickedListener(new CCTVRecyclerViewAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                String url = UrlConfig.G20VIDEO + mList_WatchChina.get(position).getPid();
                loadWatchChinaData(url);
            }
        });

        mPulltorefreshscrollview_homepage.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                flag = 1;
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {

            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // 自定义方法集
    ///////////////////////////////////////////////////////////////////////////

    private void initData() {
        //开启子线程网络访问数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //网络访问获取json串
                    String jsonString_HomePage = OkHttpClientHelper.getStringFromURL(mContext, UrlConfig.HOMEPAGE, "homepage");
                    String jsonString_HomePage_pandaeyelist = OkHttpClientHelper.getStringFromURL(mContext, UrlConfig.HOMEPAGE_PANDAEYELIST, "homepage_pandaeyelist");
                    String jsonString_HomePage_WatchChina = OkHttpClientHelper.getStringFromURL(mContext, UrlConfig.G20, "homepage_watch");
                    //熊猫观察视频
                    String jsonString_HomePage_observer = OkHttpClientHelper.getStringFromURL(mContext, UrlConfig.OBSERVER, "observer");
                    //Gson解析获取主页实体类对象
                    final HomePageBean homePageBean = mBannersPagerAdapter.parseJsonToAdBean(jsonString_HomePage);
                    final HomePagePandaeyeBean pandaeyeBean = mPandaeyeRecyclerViewAdapter.parseJsonToPandaeyelist(jsonString_HomePage_pandaeyelist);
                    WatchChina watchChina = mCCTVRecyclerViewAdapter.parseJsonToCCTVListBean(jsonString_HomePage_WatchChina);
                    //熊猫观察
                    mList_Observer = parseJsonToObserverBean(jsonString_HomePage_observer);
                    //通过实体对象获取横幅的集合
                    mList_Banner = homePageBean.getData().getBigImg();
                    mList_AreaBean = homePageBean.getData().getArea().getListscroll();
                    mList_Pandaeye = homePageBean.getData().getPandaeye().getItems();
                    mList_Pandaeyelist = pandaeyeBean.getList();
                    //cctv
                    mList_WatchChina = watchChina.getList();

                    //刷新数据
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //横幅
                            mBannersPagerAdapter.reloadPagerView(mList_Banner, false);
                            //广告
                            mAdBannerAdapter.reloadRecyclerView(mList_AreaBean, false);
                            mPandaeyeRecyclerViewAdapter.reloadRecyclerView(mList_Pandaeyelist, false);
                            //熊猫观察
                            Glide.with(mContext).load(homePageBean.getData().getPandaeye().getPandaeyelogo()).into(mImage_homepage_observe);
                            mTextview_homepage_comment_titlel.setText(mList_Pandaeye.get(0).getTitle());
                            mTextview_homepage_hot_title.setText(mList_Pandaeye.get(1).getTitle());
                            //cctv
                            mCCTVRecyclerViewAdapter.reloadRecyclerView(mList_WatchChina, false);
                            mPulltorefreshscrollview_homepage.onRefreshComplete();
                            if (flag == 1) {
                                Toast.makeText(mContext, "更新完成", Toast.LENGTH_SHORT).show();
                                flag = 0;
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //Banner
        mBannersPagerAdapter = new BannersPagerAdapter(mContext, mList_Banner);
        mViewPager_homepage.setAdapter(mBannersPagerAdapter);
        //广告栏
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.HORIZONTAL);
        mRecyclerview_homepage_recommend.setLayoutManager(layoutManager);
        mRecyclerview_homepage_recommend.setHasFixedSize(true);
        mAdBannerAdapter = new AdBannerAdapter(mContext, mList_AreaBean);
        mRecyclerview_homepage_recommend.setAdapter(mAdBannerAdapter);
        //熊猫观察
        LinearLayoutManager layoutmanager = new LinearLayoutManager(mContext);
        mRecyclerview_homepage_pandaeyelist.setLayoutManager(layoutmanager);
        mPandaeyeRecyclerViewAdapter = new PandaeyeRecyclerViewAdapter(mContext, mList_Pandaeyelist, mRecyclerview_homepage_pandaeyelist);
        mRecyclerview_homepage_pandaeyelist.setAdapter(mPandaeyeRecyclerViewAdapter);
        //CCTV
        GridLayoutManager gridLayoutmanager = new GridLayoutManager(mContext, 2);
        mRecyclerview_homepage_cctv.setLayoutManager(gridLayoutmanager);
        mRecyclerview_homepage_cctv.setHasFixedSize(true);
        mCCTVRecyclerViewAdapter = new CCTVRecyclerViewAdapter(mContext, mList_WatchChina, mRecyclerview_homepage_cctv);
        mRecyclerview_homepage_cctv.setAdapter(mCCTVRecyclerViewAdapter);
    }

    /**
     * 获取熊猫观察视频播放的地址
     *
     * @param url
     */
    private void loadObserverData(final String url) {
        //开启子线程网络访问数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //网络访问获取json串
                    String jsonString_Observer = OkHttpClientHelper.getStringFromURL(mContext, url, "observer");
                    //Gson解析获取主页实体类对象
                    ObserverBean observerBean = parseJsonToObserverBean(jsonString_Observer);
                    videoUrl = observerBean.getVideo().getChapters().get(0).getUrl();
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

    /**
     * 获取G20看中国视频播放的地址
     *
     * @param url
     */
    private void loadWatchChinaData(final String url) {
        //开启子线程网络访问数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //网络访问获取json串
                    String jsonString_WatchChina = OkHttpClientHelper.getStringFromURL(mContext, url, "watchchina");
                    //Gson解析获取主页实体类对象
                    VideoInfoBean videoInfoBean = parseJsonToWatchChinaBean(jsonString_WatchChina);
                    videoUrl_WatchChina = videoInfoBean.getVideo().getChapters().get(0).getUrl();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mIntent.setClass(mContext, VideoPlayerActivity.class);
                            mIntent.putExtra("videoUrl", videoUrl_WatchChina);
                            mContext.startActivity(mIntent);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Gson解析：熊猫观察
     *
     * @param jsonString
     * @return
     */
    public ObserverBean parseJsonToObserverBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<ObserverBean>() {
        }.getType());
    }

    /**
     * Gson解析：G20看中国
     *
     * @param jsonString
     * @return
     */
    public VideoInfoBean parseJsonToWatchChinaBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<VideoInfoBean>() {
        }.getType());
    }
}
