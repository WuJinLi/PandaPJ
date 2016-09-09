package com.example.my.panda.adapter.pandaliveadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by My on 2016/9/6.
 */
public class PandaLiveAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] tabTitles;

    public PandaLiveAdapter(FragmentManager fm, List<Fragment> list, String[] tabTitles) {
        super(fm);
        this.list = list;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
