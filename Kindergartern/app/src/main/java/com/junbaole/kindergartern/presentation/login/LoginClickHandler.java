package com.junbaole.kindergartern.presentation.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.junbaole.kindergartern.data.utils.activity.SkipActivityUtils;
import com.junbaole.kindergartern.presentation.base.BaseTitleClickHandler;
import com.junbaole.kindergartern.presentation.main.MainActivity;

/**
 * Created by liangrenwang on 16/5/9.
 */
public class LoginClickHandler extends BaseTitleClickHandler{

    LoginActivity mActivity;

    public LoginClickHandler(Activity mActivity) {
        super(mActivity);
    }

    public void login(View view) {
        Intent intent = new Intent(mActivity, MainActivity.class);
        SkipActivityUtils.startActivity(mActivity, view, "main_activity", intent);
    }

    public void onClickReturn(View view) {
        SkipActivityUtils.specialFinish(mActivity);
    }

    public void onClickForgetPsw(View view) {

    }


}
