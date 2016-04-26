package com.junbaole.kindergartern.presentation.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by liangrenwang on 16/4/25.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"Ljxrg40UQRdwgrqtNd1VLdJg-gzGzoHsz","oCfNRhTX0E8Uyl1CRHb24wuC");

    }
}
