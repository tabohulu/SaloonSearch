package com.creativediligence.saloonsearch;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_MySaloons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_MySaloons extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView addSaloonImage;
    TextView noSaloons;
    RecyclerView saloonsListRecyclerView;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    static final String PREF_NAME = "com.creativediligence.saloonsearch";
    ArrayList<String> saloonList;
    ArrayList<Helper_HitListModel> savedSaloonData;

    public Fragment_MySaloons() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_MySaloons.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_MySaloons newInstance(String param1, String param2) {
        Fragment_MySaloons fragment = new Fragment_MySaloons();
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
        saloonList = new ArrayList<>();
        savedSaloonData = new ArrayList<>();
        prefs = getContext().getSharedPreferences(PREF_NAME, MODE_PRIVATE);

       RetrieveSharedPrefs();

    }

    @Override
    public void onResume() {
        super.onResume();
        RetrieveSharedPrefs();
        LoadRecyclerViewContent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_saloons, container, false);
        addSaloonImage = view.findViewById(R.id.fragment_my_saloons_add_saloon);
        noSaloons = view.findViewById(R.id.fragment_my_saloons_no_saloons);
        saloonsListRecyclerView = view.findViewById(R.id.fragment_my_saloons_saloon_rv);
        saloonsListRecyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        saloonsListRecyclerView.setLayoutManager(layoutManager);
        saloonsListRecyclerView.setItemAnimator(new DefaultItemAnimator());
       LoadRecyclerViewContent();


        addSaloonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getContext() instanceof Activity_Homepage) {
                    ((Activity_Homepage) getContext()).SwitchPage(0);
                }
            }
        });

        return view;
    }

    public void RetrieveSharedPrefs(){
        if (prefs.contains("saloon_list")) {
            saloonList = new ArrayList<String>(prefs.getStringSet("saloon_list", null));
            Toast.makeText(getContext(), "hasSaloonList of size: " + saloonList.size(), Toast.LENGTH_SHORT).show();
            ArrayList<Helper_HitListModel> temp = new ArrayList<>();
            for (String saloon : saloonList) {
                int index = Helper_TestData.dummyDataNames.indexOf(saloon);
                String location = Helper_TestData.dummyDataLocations.get(index);
                String rating = Helper_TestData.dummyDataRatings.get(index);
                temp.add(new Helper_HitListModel(saloon, location, rating));

            }
            savedSaloonData = temp;
        }
    }

    public void LoadRecyclerViewContent(){
        if (saloonList.size() > 0) {
            AdapterRecylerview_MySaloons adapter = new AdapterRecylerview_MySaloons(getContext(), savedSaloonData);
            saloonsListRecyclerView.setAdapter(adapter);
            noSaloons.setVisibility(View.GONE);
        }
    }
}
