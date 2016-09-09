package com.example.my.panda.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my.panda.R;
import com.example.my.panda.adapter.livechinaadapter.LiveChinaViewPagerAdapter;
import com.example.my.panda.fragment.livechinafragment.LiveChinaFragment;

import java.util.ArrayList;
import java.util.List;


/**
 */
public class PandaChinaLiveFragment extends Fragment {
    private TabLayout tablayout_china;
    private ViewPager viewpager_china;
    private String[] tabTitlesChina;
    private List<Fragment> list_fragment = new ArrayList<>();
    private LiveChinaViewPagerAdapter liveChinaViewPagerAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_china_live, container, false);
        tablayout_china = (TabLayout) view.findViewById(R.id.tablayout_china);
        viewpager_china = (ViewPager) view.findViewById(R.id.viewpager_china);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化标题数据
        tabTitlesChina = getActivity().getResources().getStringArray(R.array.tabTitlesChina);
        //初始化viewpager的数据源
        for (int i = 0; i < tabTitlesChina.length; i++) {
            LiveChinaFragment liveChinaFragment = LiveChinaFragment.newInstance(i);
            list_fragment.add(liveChinaFragment);
        }
        //初始化适配器
        liveChinaViewPagerAdapter = new LiveChinaViewPagerAdapter(getActivity()
                .getSupportFragmentManager(), list_fragment, tabTitlesChina);
        //设置适配器
        viewpager_china.setAdapter(liveChinaViewPagerAdapter);
        tablayout_china.setupWithViewPager(viewpager_china);
    }
}
