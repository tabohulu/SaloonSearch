package com.creativediligence.saloonsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterRecyclerview_Services extends RecyclerView.Adapter<AdapterRecyclerview_Services.MyViewHolder> {
private Context mContext;
private ArrayList<String> mServiceList;

    public AdapterRecyclerview_Services(Context context, ArrayList<String> serviceList) {
    mContext=context;
    mServiceList=serviceList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_services_list,parent,false);
        MyViewHolder vh= new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.serviceName.setText(mServiceList.get(position));

    }

    @Override
    public int getItemCount() {
        return mServiceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView serviceImage;
    TextView serviceName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceImage=itemView.findViewById(R.id.custom_service_list_service_image);
            serviceName=itemView.findViewById(R.id.custom_service_list_service_name);

        }
    }
}
