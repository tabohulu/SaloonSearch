package com.creativediligence.saloonsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerview_CalendarChild extends RecyclerView.Adapter<AdapterRecyclerview_CalendarChild.MyViewHolder> {

    Context mContext;
    ArrayList<String> mTimes;
    ArrayList<Boolean> mAvailability;

    public AdapterRecyclerview_CalendarChild(Context context, ArrayList<String> times,ArrayList<Boolean> availability ){
        mContext=context;
        mTimes=times;
        mAvailability=availability;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_calendarchild_recyclerview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timeTextView.setText(mTimes.get(position));
        if(mAvailability.get(position)){
            holder.availabilityTextView.setBackgroundColor(mContext.getResources().getColor(R.color.color_gray));

        }else{
            holder.availabilityTextView.setBackgroundColor(mContext.getResources().getColor(R.color.color_green));
        }

    }

    @Override
    public int getItemCount() {
        return mTimes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView;
        TextView availabilityTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            timeTextView=itemView.findViewById(R.id.custom_calendarchild_rv_time);
            availabilityTextView=itemView.findViewById(R.id.custom_calendarchild_rv_availability);
        }
    }
}
