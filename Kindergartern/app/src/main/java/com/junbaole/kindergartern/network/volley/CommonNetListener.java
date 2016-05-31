package com.junbaole.kindergartern.network.volley;

import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.avos.avoscloud.LogUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import de.greenrobot.event.EventBus;


/**
 * Created by liangrenwang on 15/10/13.
 */
public class CommonNetListener<T> implements NetListener<T> {

    private final String TAG = this.getClass().getName();

    private String api;
    private Class<T> mClass;
    private NetListener netListener;

    //clasz 可以传null值，当clasz为null值时，直接返回json字符串
    public CommonNetListener(String api, Class<T> clasz, NetListener netListener) {
        this.api = api;
        this.mClass = clasz;
        this.netListener = netListener;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
        if (null != netListener) {
            if (null == error || TextUtils.isEmpty(error.getMessage())) {
                error = new VolleyError("网络不佳,请检查网络设置！");
            }
            netListener.onErrorResponse(error);
        }
    }

    @Override
    public void onResponse(Object response) {
        if (null == response) {
            onErrorResponse(new VolleyError("网络不佳,请检查网络设置！"));
            return;
        }
        LogUtil.t(TAG).json(response.toString());
        BaseEntity entity = null;
        try {
            entity = new BaseEntity();
            entity.data = response.toString();
            JSONObject jsonObject = new JSONObject(response.toString());
            entity.status = jsonObject.getInt("status");
            entity.msg = jsonObject.getString("msg");
            entity.data = jsonObject.getString("data");
            String cache = jsonObject.getString("cache");
            jsonObject = new JSONObject(cache);
            entity.cache = new CacheEntity();
            entity.cache.type = jsonObject.getString("type");
            entity.cache.expire = jsonObject.getLong("expire");
        } catch (Exception e) {
            e.printStackTrace();
            onErrorResponse(new VolleyError("服务器数据异常"));
            return;
        }

        if (null == entity) {
            onErrorResponse(new VolleyError("服务器数据异常"));
            return;
        }
        if (onOrignalData(entity)) {
            return;
        }
        switch (entity.status) {
            case NetStatus.NEED_LOGIN:
                EventBus.getDefault().post(new SkipLoginEvent());
                break;
            case NetStatus.SUCCESS:
                try {
                    onCacheResponse(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                    onErrorResponse(new VolleyError(e.getMessage()));
                }
                break;
            default:
                onErrorResponse(new VolleyError(entity.msg));
                break;
        }

    }

    public void onCacheResponse(BaseEntity entity)throws Exception {
        String data = "";
        if (entity.cache != null && NetStatus.CACHE_UNMODIFIED.equals(entity.cache.type)) {
            data = CacheUtils.getInstances().getValue(api).data;
        } else {
            data = entity.data;
        }
        if (null != netListener) {
            if (mClass == null) netListener.onResponse(data);
            else netListener.onResponse(new Gson().fromJson(data, mClass));
        }
        if (entity.cache != null) {
            AsyncDbManager asyncDbManager = new AsyncDbManager();
            asyncDbManager.execute(this.api, entity);
        }
    }

    public boolean onOrignalData(BaseEntity response) {

        return false;
    }
}
