package com.junbaole.kindergartern.network.request;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.junbaole.kindergartern.data.utils.ConstantUtils;
import com.junbaole.kindergartern.network.volley.CommonNetListener;
import com.junbaole.kindergartern.network.volley.VolleyRequestManager;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by liangrenwang on 15/10/13.
 */
public class BaseRequest<T> extends Request<T> {
    private static final int SOCKET_TIME = 30 * 1000;
    protected Map<String, String> mParams;
    protected CommonNetListener mListener;

    public BaseRequest(Context context, int method, String api, Map<String, Object> params, CommonNetListener listener) {
        super(method, ConstantUtils.BASEURL, listener);
        setRetryPolicy(new DefaultRetryPolicy(SOCKET_TIME, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        setShouldCache(false);
        mListener = listener;
//        BaseEntity cacheData = RequestCacheUtils.getUseCacheData(context, api);
//        if (cacheData != null) {
//            try {
//                mListener.onCacheResponse(cacheData);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return;
//        }

        if (null == mParams) {
            mParams = new ArrayMap<>();
        }
//        mParams = new RequestParamBuilder().
//                setCallParams(api, ConstantUtils.API_VERSION).
//                addDataJson(new Gson().
//                        toJson(params)).
//                completeFinalParams();
//        LogUtil.basic_d("request", mParams.toString());
        VolleyRequestManager.addAndStart(this, api);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();
        headers.put("Charset", "UTF-8");
        return headers;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return mParams;
    }

    @Override
    protected void deliverResponse(T response) {
        if (mListener != null)
            mListener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String json = null;
        try {
            json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (Response<T>) Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        if (null != volleyError) {
            volleyError.printStackTrace();
            if (volleyError instanceof NoConnectionError) {
                return new VolleyError("网络不佳,请检查网络设置！");
            } else if (volleyError instanceof TimeoutError) {
                return new VolleyError("连接超时，点击重试");
            }
        }
        return super.parseNetworkError(volleyError);
    }


}
