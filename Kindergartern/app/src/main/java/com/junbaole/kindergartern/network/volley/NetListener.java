package com.junbaole.kindergartern.network.volley;

import com.android.volley.Response;

/**
 * Created by liangrenwang on 15/10/13.
 */
public interface NetListener<T> extends Response.ErrorListener, Response.Listener<T> {
}
