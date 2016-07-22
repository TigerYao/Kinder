package com.junbaole.kindergartern.data.utils;

import android.content.Context;

import com.junbaole.kindergartern.data.utils.event.ActionSheetEvent;
import com.junbaole.kindergartern.widget.ActionSheetDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by yaohu on 16/7/22.
 */
public abstract class ActionsheetHelper {

    private ActionSheetDialog actionSheetDialog;
    public Object mObj;

    public ActionsheetHelper(Context ctx, String title, String... items) {
        this.actionSheetDialog = new ActionSheetDialog(ctx).builder();
        if (!StringUtils.isBlank(title)) {
            actionSheetDialog.setTitle(title);
        }
        actionSheetDialog.setCancelable(true).setCanceledOnTouchOutside(true);
        for (final String string : items) {
            actionSheetDialog.addSheetItem(string, ActionSheetDialog.SheetItemColor.BLACK, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    ActionSheetEvent sheetEvent = new ActionSheetEvent(string);
                    EventBus.getDefault().post(sheetEvent);
                }
            });
        }

    }


    public abstract void showDialog(Object obje);


}
