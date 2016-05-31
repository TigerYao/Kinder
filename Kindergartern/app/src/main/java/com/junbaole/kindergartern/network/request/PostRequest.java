package com.junbaole.kindergartern.network.request;


import android.content.Context;

import com.android.volley.Request;
import com.junbaole.kindergartern.network.volley.CommonNetListener;

import java.util.Map;

public class PostRequest extends BaseRequest {

    public PostRequest(Context context, String api, Map<String, Object> params, CommonNetListener listener) {
        super(context, Request.Method.POST, api, params, listener);
    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }
}
