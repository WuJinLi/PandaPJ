package com.example.my.panda.adapter.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;

import com.example.my.panda.bean.home.CCTVListBean;
import com.example.my.panda.bean.home.HomePageCCTVBean;
import com.example.my.panda.bean.home.WatchChina;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by virgil on 2016/7/29.
 * email 841864388@qq.com
 */
public class CCTVRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context mContext = null;
    private List<WatchChina.ListBean> mList = null;
    private LayoutInflater mInflater = null;
    private OnItemClickedListener mListener = null;
    private Intent mIntent = new Intent();
    private RecyclerView recyclerView = null;

    public CCTVRecyclerViewAdapter(Context context, List<WatchChina.ListBean> list, RecyclerView _recyclerView) {
        this.mContext = context;
        this.mList = list;
        recyclerView = _recyclerView;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public interface OnItemClickedListener {
        void onItemClick(int position);
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
        View view = mInflater.inflate(R.layout.item_homepage_cctvlive, parent, false);
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
            Glide.with(mContext).load(mList.get(position).getImage()).into(((MyViewHolder) holder).image_homepage_cctv);
            ((MyViewHolder) holder).textview_homepage_cctv_videotime.setText(mList.get(position).getVideoLength() + "");
            ((MyViewHolder) holder).textview_homepage_cctv_title.setText(mList.get(position).getTitle() + "");
            ((MyViewHolder) holder).textview_homepage_cctv_updatetime.setText(mList.get(position).getDaytime() + "");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //定义item布局中的控件
        ImageView image_homepage_cctv;
        TextView textview_homepage_cctv_videotime;
        TextView textview_homepage_cctv_title;
        TextView textview_homepage_cctv_updatetime;

        /**
         * 在构造方法中对控件进行初始化
         *
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            image_homepage_cctv = (ImageView) itemView.findViewById(R.id.image_homepage_cctv);
            textview_homepage_cctv_videotime = (TextView) itemView.findViewById(R.id.textview_homepage_cctv_videotime);
            textview_homepage_cctv_title = (TextView) itemView.findViewById(R.id.textview_homepage_cctv_title);
            textview_homepage_cctv_updatetime = (TextView) itemView.findViewById(R.id.textview_homepage_cctv_updatetime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = recyclerView.getChildAdapterPosition(v);
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Gson解析、刷新GridView数据
    ///////////////////////////////////////////////////////////////////////////

    /**
     * @param jsonString
     * @return
     */
    public WatchChina parseJsonToCCTVListBean(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<WatchChina>() {
        }.getType());
    }

    /**
     * 刷新数据
     *
     * @param _list
     * @param isClear
     */
    public void reloadRecyclerView(List<WatchChina.ListBean> _list, boolean isClear) {
        if (isClear) {
            mList.clear();
        }
        mList.addAll(_list);
        notifyDataSetChanged();
    }
}
