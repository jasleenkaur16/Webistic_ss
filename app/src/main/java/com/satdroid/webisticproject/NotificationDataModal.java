package com.satdroid.webisticproject;

import java.io.Serializable;

public class NotificationDataModal implements Serializable {

    private String Notifications;

    public NotificationDataModal(String notifications) {
        this.Notifications = notifications;
    }

    public String getNotifications() {
        return Notifications;
    }

    public void setNotifications(String notifications) {
        Notifications = notifications;
    }
}
