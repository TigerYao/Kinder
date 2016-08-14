package com.junbaole.kindergartern.data.utils.qiniu;

import android.util.Log;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by liangrenwang on 16/6/1.
 */
public class QiNiuManager {

    public static final class LazyManagerHolder {
        public static final QiNiuManager instance = new QiNiuManager();
    }

    UploadManager uploadManager;

    private QiNiuManager() {
        Configuration configuration = new Configuration.Builder().connectTimeout(10).responseTimeout(60).build();
        uploadManager = new UploadManager(configuration);
    }

    public static QiNiuManager getInstance() {
        return LazyManagerHolder.instance;
    }



    public void uploadSingleImg(String imgPath,String token) {
        uploadManager.put(imgPath, null, token, new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo info, JSONObject response) {
                if(info.isOK()){
                    Log.i("tag==",response.toString());
                }
            }
        },null);
    }

    private void uploadImg() {
    }

    private String getToken() {

        return "yaohu";
    }
}
