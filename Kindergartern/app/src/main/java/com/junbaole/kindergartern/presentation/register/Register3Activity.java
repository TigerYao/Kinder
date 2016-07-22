package com.junbaole.kindergartern.presentation.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivityRegisterStep3Binding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;
import com.junbaole.kindergartern.presentation.base.TitleBuilder;

public class Register3Activity extends BaseActivity {

    private ActivityRegisterStep3Binding registerBinding;
    private RegisterClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_step3);
        new TitleBuilder(registerBinding.titleBar).TitleBuilderLayout(true, false).TitleBuilderLeftItem(true, false).TitleBuilderImgReasours(R.mipmap.icon_fanhui, -1).build();
        clickHandler = new RegisterClickHandler(this);
        registerBinding.setClickHandler(clickHandler);
        registerBinding.setIsRight(false);
    }
}
