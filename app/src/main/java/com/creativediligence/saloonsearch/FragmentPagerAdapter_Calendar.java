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

public class FragmentPagerAdapter_Calendar extends FragmentPagerAdapter{
    ArrayList<String> mTabTitles;
    ArrayList<String> mTabTitles2;
    Context mContext;
    public FragmentPagerAdapter_Calendar(@NonNull FragmentManager fm, Context context,ArrayList<String> tabTitles,ArrayList<String> dayOfMoon) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTabTitles=tabTitles;
        mContext=context;
        mTabTitles2=dayOfMoon;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new Fragment_CalendarChild();
    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.custom_tablayout_calendar, null);
        TextView dayOfWeek = tab.findViewById(R.id.custom_tablayout_calendar_dow);
        TextView dayOfMonth = tab.findViewById(R.id.custom_tablayout_calendar_dom);
        dayOfWeek.setText(mTabTitles.get(position));
        dayOfMonth.setText(mTabTitles2.get(position));;
        return tab;
    }
}
