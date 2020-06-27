package com.creativediligence.saloonsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashSet;

public class Activity_SaloonDetails extends AppCompatActivity {
    static final String PREF_NAME = "com.creativediligence.saloonsearch";
    TabLayout saloonDetailsTabs;
    ViewPager saloonDetailsPages;
    TextView saloonName;
    TextView saloonLocation;
    TextView saloonRating;
    TextView addToSaloons;
    SharedPreferences prefs;

    boolean isInSaloonList=false;
    ArrayList<String> saloonList;
    SharedPreferences.Editor editor;
    int saloonListIndex=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__saloon_details);

        prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        saloonList=new ArrayList<>();
        if (prefs.contains("saloon_list")) {
            saloonList= new ArrayList<String>( prefs.getStringSet("saloon_list",null));
            String temp= getIntent().getExtras().getStringArrayList("extras").get(0);
            if(saloonList.indexOf(temp)!=-1){
                saloonListIndex=saloonList.indexOf(temp);
                isInSaloonList=true;
            }
            //Toast.makeText(this, "in list: "+isInSaloonList, Toast.LENGTH_SHORT).show();
        }
        InitializeXMLElements();

        SetupViewPager();
    }

    public void InitializeXMLElements() {
        saloonDetailsTabs = findViewById(R.id.activity_saloon_tab_layout);
        saloonDetailsPages = findViewById(R.id.activity_saloon_view_pager);
        saloonName = findViewById(R.id.saloon_name);
        saloonName.setText(getIntent().getExtras().getStringArrayList("extras").get(0));
        saloonLocation = findViewById(R.id.saloon_location);
        saloonLocation.setText(getIntent().getExtras().getStringArrayList("extras").get(1));
        saloonRating = findViewById(R.id.saloon_rating);
        saloonRating.setText(getIntent().getExtras().getStringArrayList("extras").get(2));


        addToSaloons = findViewById(R.id.activity_saloon_details_add_to_mysaloons);
        if(isInSaloonList){
            addToSaloons.setText("Remove From My Saloons");
        }
        editor = prefs.edit();

        addToSaloons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInSaloonList){
                    saloonList.remove(saloonListIndex);
                    addToSaloons.setText("Add To My Saloons");
                    isInSaloonList=false;
                }else{
                    saloonList.add(saloonName.getText().toString());
                    addToSaloons.setText("Remove From My Saloons");
                    isInSaloonList=true;
                    saloonListIndex=saloonList.indexOf(saloonName.getText().toString());
                }


                editor.putStringSet("saloon_list",new HashSet<String>(saloonList));
                editor.commit();
                Toast.makeText(Activity_SaloonDetails.this, ""+saloonList.size(), Toast.LENGTH_SHORT).show();
                /*SharedPreferences.Editor editor = prefs.edit();
                ArrayList<String> temp=new ArrayList<>();
                if (prefs.contains("saloon_list")) {
                    temp= new ArrayList<String>( prefs.getStringSet("saloon_list",null));

                }
                if(isInSaloonList){
                    for(int i=0;i<temp.size();i++){
                        if(temp.get(i).equals(saloonName.getText().toString())){
                            temp.remove(i);
                            break;
                        }
                    }
                    isInSaloonList=false;
                    saloonName.setText("Add to My Saloons");
                }else {
                    temp.add(saloonName.getText().toString());
                    isInSaloonList=true;
                    saloonName.setText("Remove From My Saloons");
                }*/

                /*editor.putStringSet("saloon_list",new HashSet<String>(temp));
                editor.putBoolean("is_in_saloon_list",isInSaloonList);
                editor.commit();*/
            }
        });
    }

    public void SetupViewPager() {
        FragmentPagerAdapter_SaloonDetails adapterSaloonDetails =
                new FragmentPagerAdapter_SaloonDetails(getSupportFragmentManager(), Helper_TestData.tabtitlesSaloonDetails);

        saloonDetailsPages.setAdapter(adapterSaloonDetails);

        saloonDetailsTabs.setupWithViewPager(saloonDetailsPages);

        for (int i = 0; i < Helper_TestData.tabtitlesSaloonDetails.size(); i++) {
            TabLayout.Tab tab = saloonDetailsTabs.getTabAt(i);
            assert tab != null;
            tab.setText(Helper_TestData.tabtitlesSaloonDetails.get(i));
        }
    }
}
