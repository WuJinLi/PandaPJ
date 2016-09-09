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

import com.example.my.panda.bean.home.HomePagePandaeyeBean;
import com.example.my.panda.bean.home.PandaListDataBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by virgil on 2016/7/29.
 * email 841864388@qq.com
 */
public class PandaeyeRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context mContext = null;
    private List<PandaListDataBean> mList = null;
    private LayoutInflater mInflater = null;
    private OnItemClickedListener mListener = null;
    private Intent mIntent = new Intent();
    private ImageView mImage_homepage_molihua;
    private TextView mTextview_homepage_molihuatitle;
    private TextView mTextview_homepage_molihuatime;
    private TextView mTextview_homepage_pandaeyelist_videolength;
    private RecyclerView recyclerView = null;

    public PandaeyeRecyclerViewAdapter(Context context, List<PandaListDataBean> list,RecyclerView _recyclerView) {
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
        View view = mInflater.inflate(R.layout.item_homepage_pandaeyelist, parent, false);
        mImage_homepage_molihua = (ImageView) view.findViewById(R.id.image_homepage_molihua);
        mTextview_homepage_molihuatitle = (TextView) view.findViewById(R.id.textview_homepage_molihuatitle);
        mTextview_homepage_molihuatime = (TextView) view.findViewById(R.id.textview_homepage_molihuatime);
        mTextview_homepage_pandaeyelist_videolength = (TextView) view.findViewById(R.id.textview_homepage_pandaeyelist_videolength);
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
            Glide.with(mContext).load(mList.get(position).getImage()).into(mImage_homepage_molihua);
            mTextview_homepage_molihuatitle.setText(mList.get(position).getTitle() + "");
            mTextview_homepage_molihuatime.setText(mList.get(position).getDaytime() + "");
            mTextview_homepage_pandaeyelist_videolength.setText(mList.get(position).getVideoLength() + "");
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
    public HomePagePandaeyeBean parseJsonToPandaeyelist(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<HomePagePandaeyeBean>() {
        }.getType());
    }

    /**
     * 刷新数据
     *
     * @param _list
     * @param isClear
     */
    public void reloadRecyclerView(List<PandaListDataBean> _list, boolean isClear) {
        if (isClear) {
            mList.clear();
        }
        mList.addAll(_list);
        notifyDataSetChanged();
    }
}
