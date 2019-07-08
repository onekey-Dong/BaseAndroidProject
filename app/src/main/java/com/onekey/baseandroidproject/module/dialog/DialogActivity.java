package com.onekey.baseandroidproject.module.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.onekey.baseandroidproject.R;
import com.onekey.baseandroidproject.base.BaseActivity;
import com.onekey.baseandroidproject.tools.DialogTool;

public class DialogActivity extends BaseActivity {

    @Override
    protected int getContentID() {
        return R.layout.activity_dialog;
    }

    @Override
    protected void initView(Bundle bundle) {
        log(TAG + " is created.");
    }

    public void onDialogClick(View view) {
        switch (view.getId()) {
            case R.id.tvDialogBase:
                DialogTool.show(this, "这是一个基本对话框");
                break;
            case R.id.tvDialogBtn:
                DialogTool.show(this, "带有按钮", "这是内容", new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        showToast("tip");
                    }
                });
                break;
            case R.id.tvDialogList:
                final String[] arr = new String[3];
                arr[0] = "one";
                arr[1] = "two";
                arr[2] = "three";
                DialogTool.show(this, "列表", arr, new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(arr[position]);
                    }
                });
                break;
            case R.id.tvDialogCustom:
                final AppCompatEditText editText = new AppCompatEditText(this);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        100);
                editText.setLayoutParams(params);
                DialogTool.show(this, "输入框", "确定", new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        showToast(editText.getText().toString().trim());
                    }
                }, editText, true);
                break;
            case R.id.tvDialogResID:
                new ActivityDialog(this, R.layout.activity_main).show();
                break;
        }

    }
}
