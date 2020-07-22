package com.creativediligence.saloonsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView_Reviews extends RecyclerView.Adapter<AdapterRecyclerView_Reviews.MyViewHolder> {
    ArrayList<String> mUserNames;
    ArrayList<String> mUserReviews;

    public AdapterRecyclerView_Reviews(ArrayList<String> userNames,ArrayList<String> userReviews){
        mUserNames=userNames;
        mUserReviews=userReviews;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_reviews_layout,parent,false);

        MyViewHolder viewHolder= new MyViewHolder(layoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.reviewerName.setText(mUserNames.get(position));

        holder.reviewerReview.setText(mUserReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView reviewerImage;
        TextView reviewerName;
        TextView reviewerReview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            reviewerImage=itemView.findViewById(R.id.custom_reviews_reviewer_image);
            reviewerName=itemView.findViewById(R.id.custom_reviews_reviewer_name);
            reviewerReview=itemView.findViewById(R.id.custom_reviews_review_text);
        }
    }
}
