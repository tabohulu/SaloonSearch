package com.creativediligence.saloonsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Activity_Homepage extends AppCompatActivity {
    private TabLayout titlesTab;
    private ViewPager titlesContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeXMLElements();

    }

    public void InitializeXMLElements() {
        titlesTab = findViewById(R.id.activity_main_tablayout);
        titlesContent = findViewById(R.id.activity_main_viewpager);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        FragmentPagerAdapter_Homepage pagerAdapter =
                new FragmentPagerAdapter_Homepage(getSupportFragmentManager(),
                        Activity_Homepage.this, Helper_TestData.tabtitlesHomepage,
                        Helper_TestData.tabImagesHomepage);
        titlesContent.setAdapter(pagerAdapter);

        // Give the TabLayout the ViewPager
        titlesTab.setupWithViewPager(titlesContent);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < Helper_TestData.tabtitlesHomepage.size(); i++) {
            TabLayout.Tab tab = titlesTab.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
    }

    public void SwitchPage(int page) {
        titlesContent.setCurrentItem(page);
    }


}
