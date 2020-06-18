package com.creativediligence.saloonsearch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Discover#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Discover extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Spinner hairstylesSpinner;
    Spinner locationSpinner;

    RecyclerView hitlistRecylerview;
    ImageView searchImage;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Discover() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Discover.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Discover newInstance(String param1, String param2) {
        Fragment_Discover fragment = new Fragment_Discover();
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
        View fragView=inflater.inflate(R.layout.helper_layout_discover, container, false);
        hairstylesSpinner=fragView.findViewById(R.id.hairstyes_spinner);
        locationSpinner=fragView.findViewById(R.id.locations_spinner);
        searchImage=fragView.findViewById(R.id.search_image);
        hitlistRecylerview=fragView.findViewById(R.id.hitlist_recyclerview);
        hitlistRecylerview.hasFixedSize();

        LinearLayoutManager ll = new LinearLayoutManager(getContext());
        hitlistRecylerview.setLayoutManager(ll);
        hitlistRecylerview.setItemAnimator(new DefaultItemAnimator());
        final ArrayList<Helper_HitListModel> hitListData = new ArrayList<>();

        for(int i=0;i<Helper_TestData.dummyDataLocations.size();i++){
            hitListData.add(new Helper_HitListModel(Helper_TestData.dummyDataNames.get(i),
                    Helper_TestData.dummyDataLocations.get(i),
                    Helper_TestData.dummyDataRatings.get(i)));
        }

        AdapterRecylerview_Homepage adapter=new AdapterRecylerview_Homepage(getContext(),hitListData);
        hitlistRecylerview.setAdapter(adapter);

        ArrayAdapter<String> adapterHairstyles = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Helper_TestData.hairStyles );
        adapterHairstyles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairstylesSpinner.setAdapter(adapterHairstyles);

        ArrayAdapter<String> adapterLocations = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Helper_TestData.locations );
        adapterLocations.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapterLocations);

        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Helper_HitListModel> filteredList = new ArrayList<>();
                String st = locationSpinner.getSelectedItem().toString();
                if (locationSpinner.getSelectedItemPosition() == 0) {
                    filteredList=hitListData;
                } else{
                    for (Helper_HitListModel hit : hitListData) {
                        if (hit.getSalonLocation().equals(st)) {
                            filteredList.add(hit);
                        }
                    }
                }

                AdapterRecylerview_Homepage adapter=new AdapterRecylerview_Homepage(getContext(),filteredList);
                hitlistRecylerview.setAdapter(adapter);
            }
        });

        return fragView;
    }
}
