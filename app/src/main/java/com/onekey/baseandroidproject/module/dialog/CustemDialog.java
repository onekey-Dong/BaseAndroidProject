package com.onekey.baseandroidproject.module.dialog;

import android.content.Context;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * 用于自定义对话框。
 *
 * Created by onekey on 19-7-8.
 */

public abstract class CustemDialog extends MaterialDialog implements View.OnClickListener {

    private View mCustomView;

    public CustemDialog(Context context, int resID) {
        super(new Builder(context)
                .customView(resID, true));
        mCustomView = getCustomView();
        initView(context, mCustomView);
    }

    abstract void initView(Context context,  View customView);
}
