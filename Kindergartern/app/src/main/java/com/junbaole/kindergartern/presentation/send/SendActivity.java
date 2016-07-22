package com.junbaole.kindergartern.presentation.send;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivitySendBinding;

public class SendActivity extends AppCompatActivity {

    ActivitySendBinding mSendBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSendBinding = DataBindingUtil.setContentView(this,R.layout.activity_send);
    }
}
