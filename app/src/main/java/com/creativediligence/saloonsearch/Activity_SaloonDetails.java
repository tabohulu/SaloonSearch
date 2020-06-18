package com.creativediligence.saloonsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Activity_SaloonDetails extends AppCompatActivity {
TabLayout saloonDetailsTabs;
ViewPager saloonDetailsPages;
TextView saloonName;
TextView saloonLocation;
TextView saloonRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__saloon_details);

        InitializeXMLElements();

        SetupViewPager();
    }

    public void InitializeXMLElements(){
        saloonDetailsTabs=findViewById(R.id.activity_saloon_tab_layout);
        saloonDetailsPages=findViewById(R.id.activity_saloon_view_pager);
        saloonName=findViewById(R.id.saloon_name);
        saloonLocation=findViewById(R.id.saloon_location);
        saloonRating=findViewById(R.id.saloon_rating);
    }

    public void SetupViewPager(){
        FragmentPagerAdapter_SaloonDetails adapterSaloonDetails=
                new FragmentPagerAdapter_SaloonDetails(getSupportFragmentManager(),Helper_TestData.tabtitlesSaloonDetails);

        saloonDetailsPages.setAdapter(adapterSaloonDetails);

        saloonDetailsTabs.setupWithViewPager(saloonDetailsPages);

        for(int i=0;i<Helper_TestData.tabtitlesSaloonDetails.size();i++){
            TabLayout.Tab tab = saloonDetailsTabs.getTabAt(i);
            tab.setText(Helper_TestData.tabtitlesSaloonDetails.get(i));
        }
    }
}
