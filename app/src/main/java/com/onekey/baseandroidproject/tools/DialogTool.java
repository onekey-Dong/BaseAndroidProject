package com.onekey.baseandroidproject.tools;

import android.content.Context;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.onekey.baseandroidproject.R;

/**
 * Created by onekey on 19-7-8.
 */

public class DialogTool {

    private DialogTool() {}

    public static void show(Context context, String content) {
        new MaterialDialog.Builder(context)
                .content(content)
                .positiveText(R.string.str_sure)
                .show();
    }

    public static void show(Context context, String title, String content) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText(R.string.str_sure)
                .show();
    }

    public static void show(Context context, String title, String content, MaterialDialog.SingleButtonCallback callback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText(R.string.str_sure)
                .onPositive(callback)
                .show();
    }

    public static void show(Context context, String title, String content, String positiveText,
                            String negativeText, MaterialDialog.SingleButtonCallback positiveCallback,
                            MaterialDialog.SingleButtonCallback negativeCallback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText(positiveText)
                .negativeText(negativeText)
                .onPositive(positiveCallback)
                .onNegative(negativeCallback)
                .show();
    }

    public static void show(Context context, String title, String[] contentArr, MaterialDialog.ListCallback callback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .items(contentArr)
                .itemsCallback(callback)
                .positiveText(R.string.str_cancel)
                .show();
    }

    public static MaterialDialog.Builder show(Context context, View contentView, boolean isWrap) {
        return new MaterialDialog.Builder(context)
                .customView(contentView, isWrap);
    }

    public static void show(Context context, String title, String positiveText,
                                              MaterialDialog.SingleButtonCallback callback, View contentView, boolean isWrap) {
        new MaterialDialog.Builder(context)
                .title(title)
                .positiveText(positiveText)
                .negativeText(R.string.str_cancel)
                .onPositive(callback)
                .customView(contentView, isWrap)
                .show();
    }
}
