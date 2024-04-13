package com.satdroid.webisticproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.satdroid.webisticproject.Adap.CategoryItem;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Context context;
    private ArrayList<CategoryItem> mData;

    public Adapter(Context context, ArrayList<CategoryItem> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryItem categoryItem = mData.get(position);

        // Set category name
        holder.textViewCategory.setText(categoryItem.getCategoryName());

        // Set number of videos (You need to provide this information in your data)
        holder.textNoOfVideos.setText("9 videos"); // Example text, replace with actual data

        // Load image using Glide
//        Glide.with(context)
//                .load(categoryItem.getImageUrl()) // Provide the appropriate image URL based on category
//                .centerCrop()
//                // .placeholder(R.drawable.placeholder_image) // Placeholder image while loading (optional)
//                // .error(R.drawable.error_image) // Image to display in case of error (optional)
//                .into(holder.imageViewExplore);
        Glide.with(context.getApplicationContext())

                .load(categoryItem.getImageUrl())

                .into(holder.imageViewExplore);

             //   .error(R.drawable.imagenotfound);

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
        return mData.size();
    }

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
