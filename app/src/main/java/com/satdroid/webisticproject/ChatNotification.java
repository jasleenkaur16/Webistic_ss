package com.satdroid.webisticproject;

import java.util.ArrayList;

public class ChatNotification {
    ArrayList<NotificationDataModal> chatnotificaitons;
    public ArrayList<NotificationDataModal> getChatNotifications()
    {
        chatnotificaitons=new ArrayList<>();
        chatnotificaitons.add(new NotificationDataModal("Chat 1"));
        chatnotificaitons.add(new NotificationDataModal("Chat 2"));
        chatnotificaitons.add(new NotificationDataModal("Chat 3"));
        chatnotificaitons.add(new NotificationDataModal("Chat 4"));
        chatnotificaitons.add(new NotificationDataModal("Chat 5"));
        chatnotificaitons.add(new NotificationDataModal("Chat 6"));
        chatnotificaitons.add(new NotificationDataModal("Chat 7"));
        chatnotificaitons.add(new NotificationDataModal("Chat 8"));
        chatnotificaitons.add(new NotificationDataModal("Chat 9"));
        chatnotificaitons.add(new NotificationDataModal("Chat 10"));
        return chatnotificaitons;

    }
}
