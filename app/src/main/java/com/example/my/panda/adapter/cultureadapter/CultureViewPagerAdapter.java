package com.example.my.panda.adapter.cultureadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.my.panda.R;
import com.example.my.panda.activity.WebDetailsActivity;
import com.example.my.panda.bean.culture.CultureBigImgBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class CultureViewPagerAdapter extends PagerAdapter {
    private List<CultureBigImgBean> list;
    private Context context;
    private LayoutInflater inflater;

    public CultureViewPagerAdapter(Context context, List<CultureBigImgBean> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);
        ImageView imageview_item_icon = (ImageView) view.findViewById(R.id.imageview_item_icon);
        Glide.with(context).load(list.get(position).getImage()).into(imageview_item_icon);

        imageview_item_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebDetailsActivity.class);
                String url = list.get(position).getUrl();
                String image = list.get(position).getImage();
                String title = list.get(position).getTitle();

                intent.putExtra("url", url);
                intent.putExtra("image", image);
                intent.putExtra("title", title);
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
