package com.satdroid.webisticproject;

import android.net.Uri;

public class VideoModel {
    private Uri videoUri;

    public VideoModel(Uri videoUri) {
        this.videoUri = videoUri;
    }

    public Uri getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }
}
