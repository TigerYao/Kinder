package com.junbaole.kindergartern.presentation.send;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.data.utils.ActionsheetHelper;
import com.junbaole.kindergartern.data.utils.event.ActionSheetEvent;
import com.junbaole.kindergartern.databinding.ActivityDisplayImgsBinding;
import com.junbaole.kindergartern.databinding.DiaplayimgItemBinding;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

public class DisplayImgsActivity extends AppCompatActivity {

    private ActivityDisplayImgsBinding mDisplayImgsBinding;
    private ArrayList<String> imgs;
    private ActionsheetHelper sheetHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDisplayImgsBinding = DataBindingUtil.setContentView(this, R.layout.activity_display_imgs);
        mDisplayImgsBinding.convenientBanner.setPages(new CBViewHolderCreator<ImgViewHolder>() {
            @Override
            public ImgViewHolder createHolder() {
                return new ImgViewHolder();
            }
        }, imgs);
        sheetHelper = new ActionsheetHelper(DisplayImgsActivity.this, "", "转入日记", "下载原图") {
            @Override
            public void showDialog(Object obje) {
                this.mObj = obje;
            }
        };
    }

    class ImgViewHolder implements Holder<String> {
        DiaplayimgItemBinding diaplayimgItemBinding;

        @Override
        public View createView(Context context) {
            diaplayimgItemBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.diaplayimg_item, null, false);

            return diaplayimgItemBinding.imgview;
        }

        @Override
        public void UpdateUI(Context context, final int position, final String data) {
            diaplayimgItemBinding.imgview.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    sheetHelper.showDialog(data);
                    return false;
                }
            });
            diaplayimgItemBinding.imgview.setImageURI(data);
        }

    }

    @Subscribe
    public void operate(ActionSheetEvent sheetEvent) {
        switch (sheetEvent.style) {
            case "转入日记":
                break;
            case "下载原图":
                break;
        }
    }
}
