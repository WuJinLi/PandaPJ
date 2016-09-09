package com.example.my.panda.adapter.eyeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.bean.eye.ListBean;
import com.example.my.panda.utils.DataFormat;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class EyeListViewAdapter extends BaseAdapter {

    private List<ListBean> list;
    private Context context;
    private LayoutInflater inflater;

    public EyeListViewAdapter(Context context, List<ListBean> list) {
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
        ListBean listBean = list.get(position);
        String title = listBean.getTitle();
        String url = listBean.getPicurl();
        long focusDate = listBean.getFocusDate();
        if (title != null) {
            holder.textview_item_title.setText(title);
        }
        if (focusDate != 0) {
            holder.textview_item_time.setText(DataFormat.dataFormat(focusDate + ""));
        }
        if (url != null) {
            Glide.with(context).load(url).into(holder.imageview_item_icon);
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
