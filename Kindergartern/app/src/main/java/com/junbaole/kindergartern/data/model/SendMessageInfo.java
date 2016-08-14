package com.junbaole.kindergartern.data.model;

import android.databinding.ObservableField;
import android.net.Uri;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by yaohu on 16/7/22.
 */
public class SendMessageInfo {
    public String access_token;
    public String content;
    public ArrayList<ImageInfo> images;
    public ArrayList<ImageInfo> imageList;
    public Location location;
    public String location_name;
    public String shared_id;
    public String shared_type;
    public String user_id = "2";
    public String uuid = UUID.randomUUID().toString();
    public class Location{
        public long latitude;
        public long longitude;
    }

    @Override
    public String toString() {
        return "SendMessageInfo{" +
                "access_token='" + access_token + '\'' +
                ", content='" + content + '\'' +
                ", images=" + images +
                ", location=" + location +
                ", location_name='" + location_name + '\'' +
                ", shared_id='" + shared_id + '\'' +
                ", shared_type='" + shared_type + '\'' +
                ", user_id='" + user_id + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

}
