package com.example.android.tourguideapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FPAdapter extends FragmentPagerAdapter
{
    private final String[] tabTitles = new String[]{"Malls", "Parks", "Restaurants", "Tourist Spot"};
    public FPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i)
        {
            case 1: return new MallsFragment();
            case 2: return new MallsFragment();
            case 3: return new MallsFragment();
            default: return new MallsFragment();
        }
    }

    @Override
    public int getCount() {
        //4 tabs
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
