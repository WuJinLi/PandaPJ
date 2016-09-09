package com.example.my.panda.adapter.hodongadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.hudong.HuDongBean;
import com.example.my.panda.bean.hudong.InteractiveBean;

import java.util.List;

/**
 * Created by My on 2016/9/8.
 */
public class HuDongAdapter extends BaseAdapter {
    private Context context;
    private List<InteractiveBean> list;
    private LayoutInflater inflater;

    public HuDongAdapter(Context context, List<InteractiveBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_hudong, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        InteractiveBean interactiveBean = list.get(position);
        String title = interactiveBean.getTitle();
        String image = interactiveBean.getImage();
        if (title != null) {
            holder.textview_hudong_title.setText(title);
        }
        if (image != null) {
            Glide.with(context).load(image).into(holder.imageview_hudong_icon);
        }
        return convertView;
    }

    class ViewHolder {
        public TextView textview_hudong_title;
        private ImageView imageview_hudong_icon;

        public ViewHolder(View convertView) {
            imageview_hudong_icon = (ImageView) convertView.findViewById(R.id
                    .imageview_hudong_icon);
            textview_hudong_title = (TextView) convertView.findViewById(R.id.textview_hudong_title);
        }
    }

    public void reLoad(List<InteractiveBean> _list,boolean isClear){
        if (isClear){
            list.clear();
        }
        list.addAll(_list);
        notifyDataSetChanged();
    }
}
