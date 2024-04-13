package com.satdroid.webisticproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.satdroid.webisticproject.Adap.CategoryItem;

import java.util.ArrayList;

public class AdapterExplore extends RecyclerView.Adapter<AdapterExplore.ViewHolder> {
    private ArrayList<CategoryItem> mData;
    private Context context;

    public AdapterExplore(ArrayList<CategoryItem> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public AdapterExplore.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_item, parent, false);
        return new ViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExplore.ViewHolder holder, int position) {
        CategoryItem categoryItem = mData.get(position);
        // Set category name
        holder.textViewCategory.setText(categoryItem.getCategoryName());

        // Set number of videos (You need to provide this information in your data)
        holder.textNoOfVideos.setText("9 videos"); // Example text, replace with actual data  ī
        // Load image using Glide

//        Glide.with()
//                .load(categoryItem.getImageUrl()) // Provide the appropriate image URL based on category
//                .centerCrop()
////                 .placeholder(R.drawable.placeholder_image) // Placeholder image while loading (optional)
////                 .error(R.drawable.error_image) // Image to display in case of error (optional)
//                .into(holder.imageViewExplore);

        // Set click listener for view all button
        holder.btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event here
            }
        });

        // Set click listener for card view
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event here
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategory, textNoOfVideos, btnViewAll;
        ImageView imageViewExplore;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           textViewCategory = itemView.findViewById(R.id.textView_category_explore_page);
            textNoOfVideos = itemView.findViewById(R.id.text_no_ofvideo);
            imageViewExplore = itemView.findViewById(R.id.imageView_explore);
            btnViewAll = itemView.findViewById(R.id.Btn_viewAll_explore);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
