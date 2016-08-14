package com.junbaole.kindergartern.presentation.send;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.data.model.ImageInfo;
import com.junbaole.kindergartern.data.model.SendMessageInfo;
import com.junbaole.kindergartern.data.utils.activity.SkipActivityUtils;
import com.junbaole.kindergartern.data.utils.qiniu.QiNiuManager;
import com.junbaole.kindergartern.databinding.ActivitySendBinding;
import com.junbaole.kindergartern.presentation.base.BaseActivity;
import com.junbaole.kindergartern.presentation.base.TitleBuilder;
import com.junbaole.kindergartern.widget.ImageSelectorView.ImageSelectorActivity;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SendActivity extends BaseActivity {

    ActivitySendBinding mSendBinding;
    SendMessageInfo mSendMessageInfo;
    SendImgsAdapter mAdapter;
    SendClickHandler sendClickHandler;
    ArrayList<ImageInfo> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getIntExtra("type",0) == 1){
            Intent intent = new Intent(this, ImageSelectorActivity.class);
            SkipActivityUtils.startActivity(this, null, "", intent);
        }
        mSendBinding = DataBindingUtil.setContentView(this, R.layout.activity_send);
        sendClickHandler = new SendClickHandler(this);
        mSendBinding.setClickHandler(sendClickHandler);
        new TitleBuilder(mSendBinding.actionBarTitle).TitleBuilderLayout(true, true).TitleBuilderLeftItem(false, true).TitleBuilderRightItem(false, true).TitleBuilderLable("", "取消", "发送").TitleBuilderLableColor(0, 0, R.color.white).build();
        mSendMessageInfo = new SendMessageInfo();
        mSendBinding.setSendMessage(mSendMessageInfo);
        mAdapter = new SendImgsAdapter(this, datas);
        mSendBinding.imgList.setAdapter(mAdapter);
    }

    @Subscribe
    public void onGetImgs(ArrayList<ImageInfo> imgs) {
        mAdapter.setDatas(imgs);
    }

    public SendMessageInfo getMessageInfo(){
        mSendMessageInfo.content = mSendBinding.messageContent.getText().toString();
        mSendMessageInfo.images = mAdapter.getDatas();
        return mSendMessageInfo;
    }

    @Subscribe
    public void onGetMessageInfo(SendMessageInfo messageInfo) {
        Log.i("tag",messageInfo.toString());
//        Observable.from(messageInfo.imageList).flatMap(new Func1<ImageInfo, Observable<String>>() {
//            @Override
//            public Observable<String> call(ImageInfo imageInfo) {
//                QiNiuManager.getInstance().uploadSingleImg(imageInfo.client_id,imageInfo.auth);
//                return Observable.from();
//            }
//
//
//        }).subscribeOn(Schedulers.io());
    }
}
