package com.junbaole.kindergartern.network.request;


import android.content.Context;

import com.android.volley.Request;
import com.junbaole.kindergartern.network.volley.CommonNetListener;

import java.util.Map;

public class GetRequest extends BaseRequest {
    public GetRequest(Context context, String api, Map<String, Object> params, CommonNetListener listener) {
        super(context, Request.Method.GET, api, params, listener);
    }


    @Override
    public int compareTo(Object another) {
        return 0;
    }
}
