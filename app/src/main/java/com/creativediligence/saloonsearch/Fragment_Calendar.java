package com.creativediligence.saloonsearch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.YEAR;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Calendar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Spinner mSpinner;
    ImageView mLeft;
    ImageView mRight;
    TabLayout mDaysTabs;
    ViewPager mViewPager;
    ArrayList<String> dayOfWeek;
    ArrayList<String> dayOfMonth;
    private final static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    public Fragment_Calendar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Calendar.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Calendar newInstance(String param1, String param2) {
        Fragment_Calendar fragment = new Fragment_Calendar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        final Calendar calendar = Calendar.getInstance();
        int monthIndex = calendar.get(MONTH);
        Toast.makeText(getContext(), "" + monthIndex, Toast.LENGTH_SHORT).show();
        mSpinner = view.findViewById(R.id.fragment_calendar_spinner);
        mSpinner.setSelection(monthIndex);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dayOfMonth=new ArrayList<>();
                dayOfWeek=new ArrayList<>();
                Calendar start = Calendar.getInstance();
                start.set(MONTH, position);  // month is 0 based on calendar
                start.set(YEAR, calendar.get(YEAR));
                start.set(DAY_OF_MONTH, 1);
                //Date dt=start.getTime();   // to avoid problems getTime make set changes apply
                int curMoon=start.get(MONTH);
                //Calendar temp=start.add(DATE,ii);
                while (start.get(MONTH)==curMoon){

                    Date dtt = start.getTime();
                    String dow = (String) DateFormat.format("EE", dtt);
                    String dom = (String) DateFormat.format("dd", dtt);
                    Log.d("testing",dow + "//" + dom + "//" + (start.get(MONTH))+"//"+position);

                    dayOfWeek.add(dow);
                    dayOfMonth.add(dom);
                    start.add(DATE, 1);


                }

                FragmentPagerAdapter_Calendar adapter_calendar = new FragmentPagerAdapter_Calendar(getChildFragmentManager(), getContext()
                        , dayOfWeek, dayOfMonth);

                mViewPager.setAdapter(adapter_calendar);

                mDaysTabs.setupWithViewPager(mViewPager);

                for (int i = 0; i < dayOfWeek.size(); i++) {
                    TabLayout.Tab tab = mDaysTabs.getTabAt(i);
                    tab.setCustomView(adapter_calendar.getTabView(i));
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mLeft = view.findViewById(R.id.fragment_calendar_leftshift);
        mRight = view.findViewById(R.id.fragment_calendar_rightshift);
        mDaysTabs = view.findViewById(R.id.fragment_calendar_daytabs);
        mViewPager = view.findViewById(R.id.fragment_calendar_viewpager);

        FragmentPagerAdapter_Calendar adapter_calendar = new FragmentPagerAdapter_Calendar(getChildFragmentManager(), getContext(), Helper_TestData.daysWeek,
                Helper_TestData.daysMonth);

        mViewPager.setAdapter(adapter_calendar);

        mDaysTabs.setupWithViewPager(mViewPager);

        for (int i = 0; i < Helper_TestData.daysWeek.size(); i++) {
            TabLayout.Tab tab = mDaysTabs.getTabAt(i);
            tab.setCustomView(adapter_calendar.getTabView(i));
        }

        return view;
    }


    private static String printCalendar(Calendar c) {
        return df.format(c.getTime());
    }
}