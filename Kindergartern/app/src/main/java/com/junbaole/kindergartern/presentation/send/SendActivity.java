package com.junbaole.kindergartern.presentation.send;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.data.model.SendMessageInfo;
import com.junbaole.kindergartern.databinding.ActivitySendBinding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;

public class SendActivity extends BaseActivity {

    ActivitySendBinding mSendBinding;
    SendMessageInfo mSendMessageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSendBinding = DataBindingUtil.setContentView(this, R.layout.activity_send);
        mSendMessageInfo = new SendMessageInfo();
        mSendBinding.setSendMessage(mSendMessageInfo);
        mSendMessageInfo.imgsUrl = getIntent().getStringArrayListExtra("imgsPath");
    }
}
