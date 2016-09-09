package com.example.my.panda.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.my.panda.R;
import com.example.my.panda.adapter.pandaliveadapter.PandaLiveAdapter;
import com.example.my.panda.fragment.pandaliveFragment.LiveFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 熊猫频道的直播的碎片
 */
public class PandaLiveFragment extends Fragment {
    private TabLayout tablayout_pandalive_tab;
    private ViewPager viewpager_pandalive_viewpager;
    private Context mContext;
    private String[] tabTitles;
    private PandaLiveAdapter pandaLiveAdapter;
    private List<Fragment> listFrfgment = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panda_live, container, false);
        //viewpager的初始化
        viewpager_pandalive_viewpager = (ViewPager) view.findViewById(R.id
                .viewpager_pandalive_viewpager);
        //tablayout的初始化
        tablayout_pandalive_tab = (TabLayout) view.findViewById(R.id.tablayout_pandalive_tab);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化上下文对象
        mContext = getContext();
        //初始化标题的数据源，并且初始化ciewpager的数据源
        tabTitles = getActivity().getResources().getStringArray(R.array.tabTitles);
        for (int i = 0; i < tabTitles.length; i++) {
            LiveFragment liveFragment = LiveFragment.newInstance(i);
            listFrfgment.add(liveFragment);
        }
        //初始化适配器
        pandaLiveAdapter = new PandaLiveAdapter(getActivity().getSupportFragmentManager(),
                listFrfgment, tabTitles);
        //设置适配器
        viewpager_pandalive_viewpager.setAdapter(pandaLiveAdapter);
        //实现viewpager和tablayout之间的联动
        tablayout_pandalive_tab.setupWithViewPager(viewpager_pandalive_viewpager);
    }
}
