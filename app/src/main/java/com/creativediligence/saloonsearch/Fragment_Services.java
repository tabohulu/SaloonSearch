package com.creativediligence.saloonsearch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Services#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Services extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rv;

    public Fragment_Services() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Services.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Services newInstance(String param1, String param2) {
        Fragment_Services fragment = new Fragment_Services();
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
        View view= inflater.inflate(R.layout.fragment__services, container, false);
        rv=view.findViewById(R.id.fragment_service_rv);
        rv.hasFixedSize();
        LinearLayoutManager ll = new LinearLayoutManager(getContext());
        rv.setLayoutManager(ll);
        rv.setItemAnimator(new DefaultItemAnimator());

        AdapterRecyclerview_Services adapter=new AdapterRecyclerview_Services(getContext(),Helper_TestData.saloonServices);
        rv.setAdapter(adapter);
        return view;
    }
}
