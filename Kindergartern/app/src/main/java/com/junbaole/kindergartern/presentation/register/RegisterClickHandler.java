package com.junbaole.kindergartern.presentation.register;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.junbaole.kindergartern.data.utils.activity.SkipActivityUtils;
import com.junbaole.kindergartern.presentation.base.BaseTitleClickHandler;

/**
 * Created by liangrenwang on 16/6/2.
 */
public class RegisterClickHandler extends BaseTitleClickHandler {

    public RegisterClickHandler(Activity mActivity) {
        super(mActivity);
    }

    public void onClickNextStep(View view) {
        SkipActivityUtils.startActivity(mActivity, view, "", new Intent(mActivity, Register2Activity.class));
    }

    public void onClickNextStep2(View view) {
        SkipActivityUtils.startActivity(mActivity, view, "", new Intent(mActivity, Register3Activity.class));
    }

    public void onClickFinish(View view) {

    }
}
