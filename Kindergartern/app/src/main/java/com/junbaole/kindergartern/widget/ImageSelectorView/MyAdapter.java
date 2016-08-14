package com.junbaole.kindergartern.widget.ImageSelectorView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;
import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.data.model.ImageInfo;
import com.junbaole.kindergartern.data.model.SendMessageInfo;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends CommonAdapter<ImageInfo> {

    private Context ctx;
    /**
     * 用户选择的图片，存储为图片的完整路径
     */
    public static ArrayList<ImageInfo> mSelectedImage = new ArrayList<>();

    public MyAdapter(Context context, List<ImageInfo> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
        this.ctx = context;
    }

    @Override
    public void convert(final ViewHolder helper, final ImageInfo item) {
        final SimpleDraweeView mImageView = helper.getView(R.id.id_item_image);
        mImageView.setImageURI(item.getImgUri());
        final CheckBox mSelect = helper.getView(R.id.id_item_check);
        mImageView.setColorFilter(null);
        mSelect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedImage.contains(item)) {
                    mSelectedImage.remove(item);
                    mImageView.setColorFilter(null);
                } else {
                    mSelectedImage.add(item);
                    mImageView.setColorFilter(Color.parseColor("#77000000"));
                }
            }
        });

        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageSelectorActivity)ctx).scranPics(helper.getPosition());
            }
        });

        /**
         * 已经选择过的图片，显示出选择过的效果
         */
        if (mSelectedImage.contains(item)) {
            mSelect.setChecked(true);
            mImageView.setColorFilter(Color.parseColor("#77000000"));
        } else {
            mSelect.setChecked(false);
            mImageView.setColorFilter(null);
        }

    }
}