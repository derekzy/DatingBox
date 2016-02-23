package com.derekzy.datingbox.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by derekzy on 2016/2/18.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public List<Fragment> fragmentList;
    private String[] tabList;

    public ViewPagerAdapter(FragmentManager fm, List fragmentList, String[] tabList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabList = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList[position];
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
