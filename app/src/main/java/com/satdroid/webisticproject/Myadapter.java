package com.satdroid.webisticproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private ArrayList<NotificationDataModal> notiList;

    public Myadapter(ArrayList<NotificationDataModal> notiList) {
        this.notiList = notiList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nofitfication_designs, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NotificationDataModal currentNoti = notiList.get(position);
        holder.noti_tv.setText(currentNoti.getNotifications());
    }
    @Override
    public int getItemCount() {
        return  notiList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView noti_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            noti_tv = itemView.findViewById(R.id.noti_des_tv);
        }
    }
}
