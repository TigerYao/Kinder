package com.junbaole.kindergartern.presentation.login;

import android.content.Intent;
import android.view.View;

import com.junbaole.kindergartern.data.utils.activity.SkipActivityUtils;
import com.junbaole.kindergartern.presentation.main.MainActivity;

/**
 * Created by liangrenwang on 16/5/9.
 */
public class LoginClickHandler {

    LoginActivity mActivity;
    public void login(View view){
        Intent intent = new Intent(mActivity, MainActivity.class);
        SkipActivityUtils.startActivity(mActivity,view,"main_activity",intent);
    }
}
