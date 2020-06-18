package com.creativediligence.saloonsearch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecylerview_Homepage extends RecyclerView.Adapter<AdapterRecylerview_Homepage.MyViewHolder> {

    Context mContext;
    ArrayList<Helper_HitListModel> hitListData;

    public AdapterRecylerview_Homepage(Context mContext, ArrayList<Helper_HitListModel> hitListData) {
        this.mContext = mContext;
        this.hitListData = hitListData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_hitlist_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.saloonName.setText("Name: " + hitListData.get(position).getSaloonName());
        holder.saloonLocation.setText("Location: " + hitListData.get(position).getSalonLocation());
        holder.saloonRating.setText("Rating: " + hitListData.get(position).getSaloonRating());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Activity_SaloonDetails.class);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return hitListData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView saloonImageView;
        TextView saloonName;
        TextView saloonLocation;
        TextView saloonRating;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            saloonImageView = itemView.findViewById(R.id.saloon_image);
            saloonName = itemView.findViewById(R.id.saloon_name);
            saloonLocation = itemView.findViewById(R.id.saloon_location);
            saloonRating = itemView.findViewById(R.id.saloon_rating);
            mainLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
