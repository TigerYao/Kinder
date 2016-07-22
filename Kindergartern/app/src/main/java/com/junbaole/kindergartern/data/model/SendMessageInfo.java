package com.junbaole.kindergartern.data.model;

import android.databinding.ObservableField;

import java.util.ArrayList;

/**
 * Created by yaohu on 16/7/22.
 */
public class SendMessageInfo {

    public final ObservableField<String> message = new ObservableField<>();
    public ArrayList<String> imgsUrl;
    public String location;
    public boolean isOpen;
}
