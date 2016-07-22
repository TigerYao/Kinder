package com.junbaole.kindergartern.presentation.send;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.data.model.SendMessageInfo;
import com.junbaole.kindergartern.databinding.ActivitySendBinding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;
import com.junbaole.kindergartern.presentation.base.TitleBuilder;

public class SendActivity extends BaseActivity {

    ActivitySendBinding mSendBinding;
    SendMessageInfo mSendMessageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSendBinding = DataBindingUtil.setContentView(this, R.layout.activity_send);
        new TitleBuilder(mSendBinding.actionBarTitle).TitleBuilderLayout(true, true).TitleBuilderLeftItem(false, true).TitleBuilderRightItem(false, true).TitleBuilderLable("", "取消", "发送").TitleBuilderLableColor(0, 0, R.color.light_green_500).build();
        mSendMessageInfo = new SendMessageInfo();
        mSendBinding.setSendMessage(mSendMessageInfo);
        mSendMessageInfo.imgsUrl = getIntent().getStringArrayListExtra("imgsPath");
    }
}
