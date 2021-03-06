package com.junbaole.kindergartern.presentation.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivityLoginBinding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;
import com.junbaole.kindergartern.presentation.base.TitleBuilder;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding loginBinding;
    private LoginClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        new TitleBuilder(loginBinding.titleBar).TitleBuilderLayout(true, true).TitleBuilderLeftItem(true, false).TitleBuilderRightItem(false, true).TitleBuilderImgReasours(R.mipmap.icon_fanhui, -1).TitleBuilderLable("", "", "忘记密码?").build();
        clickHandler = new LoginClickHandler(this);
        clickHandler.mActivity = this;
        loginBinding.setClickHandler(clickHandler);
        loginBinding.displayPsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                loginBinding.password.setTransformationMethod(isChecked ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
                buttonView.setText(isChecked ? "隐藏" : "显示");
            }
        });

    }
}


