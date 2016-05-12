package com.junbaole.kindergartern.presentation.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivityLoginBinding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity  {
    private ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}


