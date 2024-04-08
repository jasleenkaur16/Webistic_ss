package com.satdroid.webisticproject;

import java.util.ArrayList;

public class Sub_notification {

    ArrayList<NotificationDataModal> subnotificaitons;
public ArrayList<NotificationDataModal> getSubNotifications()
{
    subnotificaitons=new ArrayList<>();
    subnotificaitons.add(new NotificationDataModal("Notification 1"));
    subnotificaitons.add(new NotificationDataModal("Notification 2"));
    subnotificaitons.add(new NotificationDataModal("Notification 3"));
    subnotificaitons.add(new NotificationDataModal("Notification 4"));
    subnotificaitons.add(new NotificationDataModal("Notification 5"));
    subnotificaitons.add(new NotificationDataModal("Notification 6"));
    subnotificaitons.add(new NotificationDataModal("Notification 7"));
    subnotificaitons.add(new NotificationDataModal("Notification 8"));
    subnotificaitons.add(new NotificationDataModal("Notification 9"));
    subnotificaitons.add(new NotificationDataModal("Notification 10"));
    return subnotificaitons;

}
}
