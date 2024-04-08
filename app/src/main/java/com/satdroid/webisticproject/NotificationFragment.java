package com.satdroid.webisticproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {
    private ArrayList<NotificationDataModal> NotificatoinsList;
    private RecyclerView recyclerView;
    TextView sub_noti_tv,chat_noti_tv;


    public NotificationFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_notification, container,
                false);
    }
    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        sub_noti_tv=view.findViewById(R.id.Sub_notification_id);
        chat_noti_tv=view.findViewById(R.id.chat_notification_id);

        chat_noti_tv.setTextColor(Color.parseColor("#FF000000"));

        sub_noti_tv.setTextColor(Color.parseColor("#9B04FE"));
        Sub_notification sbNotification=new  Sub_notification();
        ArrayList<NotificationDataModal> notilist = sbNotification.getSubNotifications();

        // Assign list to ItemAdapter
        Myadapter itemAdapter = new Myadapter(notilist);

        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.rc_view);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);
        sub_noti_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat_noti_tv.setTextColor(Color.parseColor("#FF000000"));

                sub_noti_tv.setTextColor(Color.parseColor("#9B04FE"));
                Sub_notification sbNotification=new  Sub_notification();
                ArrayList<NotificationDataModal> notilist = sbNotification.getSubNotifications();

                // Assign list to ItemAdapter
                Myadapter itemAdapter = new Myadapter(notilist);

                // Set the LayoutManager that
                // this RecyclerView will use.
                RecyclerView recyclerView
                        = view.findViewById(R.id.rc_view);
                recyclerView.setLayoutManager(
                        new LinearLayoutManager(getContext()));

                // adapter instance is set to the
                // recyclerview to inflate the items.
                recyclerView.setAdapter(itemAdapter);
            }
        });
        chat_noti_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub_noti_tv.setTextColor(Color.parseColor("#FF000000"));

                chat_noti_tv.setTextColor(Color.parseColor("#9B04FE"));
                ChatNotification chatNotification=new ChatNotification();
                ArrayList<NotificationDataModal> notilist = chatNotification.getChatNotifications();
                // Assign list to ItemAdapter
                Myadapter itemAdapter = new Myadapter(notilist);
                // Set the LayoutManager that
                // this RecyclerView will use.
                RecyclerView recyclerView
                        = view.findViewById(R.id.rc_view);
                recyclerView.setLayoutManager(
                        new LinearLayoutManager(getContext()));
                // adapter instance is set to the
                // recyclerview to inflate the items.
                recyclerView.setAdapter(itemAdapter);
            }
        });

    }
}