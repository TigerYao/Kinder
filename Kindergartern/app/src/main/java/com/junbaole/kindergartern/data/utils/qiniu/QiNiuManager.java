package com.junbaole.kindergartern.data.utils.qiniu;

import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;

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

    public void upLoadImgs(ArrayList<String> imgsPath) {
        for (String imgPath : imgsPath) {
            uploadSingleImg(imgPath);
        }
    }

    public void uploadSingleImg(String imgPath) {

    }

    private void uploadImg() {
    }

    private String getToken() {

        return null;
    }
}
