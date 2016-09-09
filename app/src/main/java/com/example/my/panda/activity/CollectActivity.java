package com.example.my.panda.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.panda.R;
import com.example.my.panda.adapter.collect.CollectAdapter;
import com.example.my.panda.bean.collect.CollectBean;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {

    private ListView listview_colect;
    private CollectAdapter collectAdapter;
    public List<CollectBean> list = new ArrayList<>();
    private Context mContext = this;
    private ImageView image_collect_nodata;
    private ImageView imageview_personal_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();

        try {
            list = StartActivity.dbUtils.findAll(CollectBean.class);
        } catch (DbException e) {
            e.printStackTrace();
        }

        imageview_personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView() {
        image_collect_nodata= (ImageView) findViewById(R.id.image_collect_nodata);
        listview_colect = (ListView) findViewById(R.id.listview_colect);
        imageview_personal_back= (ImageView) findViewById(R.id.imageview_personal_back);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (list != null) {
            collectAdapter = new CollectAdapter(mContext, list);
            listview_colect.setAdapter(collectAdapter);
            listview_colect.setEmptyView(image_collect_nodata);
        } else {
            Toast.makeText(mContext, "没有收藏", Toast.LENGTH_SHORT).show();
        }


        listview_colect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CollectBean item = (CollectBean) collectAdapter.getItem(position);
                String url = item.getUrl();
                String image = item.getImage();
                String title = item.getTitle();
                Intent intent = new Intent(CollectActivity.this, WebDetailsActivity
                        .class);
                intent.putExtra("url", url);
                intent.putExtra("image", image);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        listview_colect.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long id) {
                //获取item对应的对象，获取对象的属性值
                CollectBean bean = (CollectBean) collectAdapter.getItem(position);
                final int id1 = bean.getId();
                //自定义对话框，对对话框的属性进行设置
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                //设置标题
                builder.setTitle("确认删除收藏？");
                //设置取消按钮
                builder.setNegativeButton("取消", null);
                //设置确定按钮
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            //根据所选的item进行数据的删除
                            StartActivity.dbUtils.deleteById(CollectBean.class, id1);
                            //重新加载数据
                            list = StartActivity.dbUtils.findAll(CollectBean.class);
                            //刷新数据
                            collectAdapter.reLoad(list, true);
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //对话框的显示
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
