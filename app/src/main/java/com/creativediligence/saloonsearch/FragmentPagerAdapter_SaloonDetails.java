package com.creativediligence.saloonsearch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentPagerAdapter_SaloonDetails extends FragmentPagerAdapter {
    ArrayList<String> mTabTitles;

    public FragmentPagerAdapter_SaloonDetails(@NonNull FragmentManager fm,ArrayList<String > tabTitles) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTabTitles=tabTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_Services();

            case 1:
                return new Fragment_Calendar();

            case 2:
                return new Fragment_Reviews();

            default:
                return new Fragment_Blank();
        }

    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }
}
