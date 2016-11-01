package com.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;

/**
 * Created by alexsandercaproni on 03/05/2016.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_TABS = 2;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return Fragment1.newInstance();
            default:
                return Fragment2.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0){

            return "Porta";
        }

        else
            return "Sistema";
    }

    

}
