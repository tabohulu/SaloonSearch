package com.creativediligence.saloonsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

class FragmentPagerAdapter_Homepage extends FragmentPagerAdapter {
    Context mContext;
    ArrayList<String> mTabTitles;
    ArrayList<Integer> mDrawables;
    public FragmentPagerAdapter_Homepage(@NonNull FragmentManager fm, Context context, ArrayList<String> tabTitles, ArrayList<Integer> drawables) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext=context;
        mTabTitles=tabTitles;
        mDrawables=drawables;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_Discover();
            case 1:
                return new Fragment_Appointment();
            case 2:
                return new Fragment_MySaloons();
            default:
                return new Fragment_Blank();
        }

    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.custom_tablayout_homepage, null);
        TextView tv = tab.findViewById(R.id.custom_tablayout_tabtitle);
        ImageView iv=tab.findViewById(R.id.custom_tablayout_tabimage);
        tv.setText(mTabTitles.get(position));
        iv.setImageDrawable(mContext.getResources().getDrawable(mDrawables.get(position)));
        return tab;
    }
}
