package com.example.android.tourguideapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideapp.fragment.ActivityFragment;
import com.example.android.tourguideapp.fragment.FoodFragment;
import com.example.android.tourguideapp.fragment.MallsFragment;
import com.example.android.tourguideapp.fragment.ParksFragment;

public class FPAdapter extends FragmentPagerAdapter
{
    private final String[] tabTitles = new String[]{"Malls", "Parks", "Food", "Activity"};
    public FPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i)
        {
            case 0: return new MallsFragment();
            case 1: return new ParksFragment();
            case 2: return new FoodFragment();
            default: return new ActivityFragment();
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
