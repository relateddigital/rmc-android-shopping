package com.relateddigital.shoppingdemo.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.relateddigital.shoppingdemo.tabs.BasketFragment;
import com.relateddigital.shoppingdemo.main.MainFragment;
import com.relateddigital.shoppingdemo.tabs.HomeFragment;
import com.relateddigital.shoppingdemo.fragments.ProfileFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    int totalTabs;

    public TabAdapter(int behavior,  FragmentManager fm, int totalTabs) {
        super(fm, behavior);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainFragment();
            case 1:
                return new BasketFragment();
            case 2:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}