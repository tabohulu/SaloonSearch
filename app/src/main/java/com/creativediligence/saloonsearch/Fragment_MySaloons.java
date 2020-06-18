package com.creativediligence.saloonsearch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


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

    ImageView addAppointmentImage;
    TextView noAppointment;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_saloons, container, false);
        addAppointmentImage=view.findViewById(R.id.fragment_my_saloons_add_saloon);
        noAppointment=view.findViewById(R.id.fragment_my_saloons_no_saloons);

        addAppointmentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getContext() instanceof Activity_Homepage){
                    ((Activity_Homepage)getContext()).SwitchPage(0);
                }
            }
        });

        return view;
    }
}
