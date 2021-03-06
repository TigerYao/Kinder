package com.junbaole.kindergartern.presentation.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivityRegisterBinding;
import com.junbaole.kindergartern.databinding.ActivityRegisterStep2Binding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;

public class Register2Activity extends BaseActivity {

    private ActivityRegisterStep2Binding registerBinding;
    private RegisterClickHandler clickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register_step2);
        clickHandler = new RegisterClickHandler(this);
        registerBinding.setClickHandler(clickHandler);
        registerBinding.setIsRight(false);
    }
}
