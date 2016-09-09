package com.example.my.panda.adapter.pandaliveadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.pandlive.LiveVideoBean;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class PandaLiveSplendidAdapter extends BaseAdapter {
    private Context context;
    private List<LiveVideoBean> list;
    private LayoutInflater inflater;

    public PandaLiveSplendidAdapter(Context context, List<LiveVideoBean> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview_eye, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        LiveVideoBean liveVideoBean = list.get(position);
        String img = liveVideoBean.getImg();
        String t = liveVideoBean.getT();
        String ptime = liveVideoBean.getPtime();
        if (img != null) {
            Glide.with(context).load(img).into(holder.imageview_item_icon);
        }
        if (t != null) {
            holder.textview_item_title.setText(t);
        }
        if (ptime != null) {
            holder.textview_item_time.setText(ptime);
        }
        return convertView;
    }

    class ViewHolder {
        private ImageView imageview_item_icon;
        private TextView textview_item_title;
        private TextView textview_item_time;

        public ViewHolder(View convertView) {
            textview_item_time = (TextView) convertView.findViewById(R.id.textview_item_time);
            textview_item_title = (TextView) convertView.findViewById(R.id.textview_item_title);
            imageview_item_icon = (ImageView) convertView.findViewById(R.id.imageview_item_icon);
        }
    }
}
