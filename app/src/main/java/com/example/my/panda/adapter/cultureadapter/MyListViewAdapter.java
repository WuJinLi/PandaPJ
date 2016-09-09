package com.example.my.panda.adapter.cultureadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.culture.CultureListBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class MyListViewAdapter extends BaseAdapter{
    private List<CultureListBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyListViewAdapter(Context context, List<CultureListBean> list) {
        this.context = context;
        this.list = list;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view=inflater.inflate(R.layout.item_listview_culture,viewGroup,false);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        CultureListBean cultureListBean = list.get(i);
        Glide.with(context).load(cultureListBean.getImage()).into(holder.imageview_item_icon);
        holder.textview_item_brief.setText(cultureListBean.getBrief());
        holder.textview_item_title.setText(cultureListBean.getTitle());
        return view;
    }

    class ViewHolder{
        public ImageView imageview_item_icon;
        private TextView textview_item_title;
        private TextView textview_item_brief;
        public ViewHolder( View view) {
            textview_item_title= (TextView) view.findViewById(R.id.textview_item_title);
            textview_item_brief= (TextView) view.findViewById(R.id.textview_item_brief);
            imageview_item_icon= (ImageView) view.findViewById(R.id.imageview_item_icon);
        }
    }
}
