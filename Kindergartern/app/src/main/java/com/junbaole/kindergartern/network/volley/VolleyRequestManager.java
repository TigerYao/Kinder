package com.junbaole.kindergartern.network.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by liangrenwang on 15/10/13.
 */
public class VolleyRequestManager {

    private static RequestQueue mRequestQueue;

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }


    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }


    public static void cancel(Object tag) {
        getRequestQueue().cancelAll(tag);
    }


    public static void addAndStart(com.android.volley.Request request) {
        getRequestQueue().add(request);
    }

    public static void addAndStart(com.android.volley.Request request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }
}
