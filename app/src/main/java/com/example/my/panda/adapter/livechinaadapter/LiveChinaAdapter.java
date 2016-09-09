package com.example.my.panda.adapter.livechinaadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.livechina.LiveBean;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class LiveChinaAdapter extends BaseAdapter {
    private List<LiveBean> list;
    private Context context;
    private LayoutInflater inflater;

    public LiveChinaAdapter(Context context, List<LiveBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_livechina, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LiveBean liveBean = list.get(position);
        String title = liveBean.getTitle();
        String image = liveBean.getImage();
        if (title != null) {
            holder.textview_item_title.setText(title);
        }
        if (image != null) {
            Glide.with(context).load(image).into(holder.imageview_item_icon);
        }
        return convertView;
    }


    class ViewHolder {
        private ImageView imageview_item_icon;
        private TextView textview_item_title;

        public ViewHolder(View convertView) {
            imageview_item_icon = (ImageView) convertView.findViewById(R.id.imageview_item_icon);
            textview_item_title = (TextView) convertView.findViewById(R.id.textview_item_title);
        }
    }
}
