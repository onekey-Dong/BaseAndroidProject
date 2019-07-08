package com.onekey.baseandroidproject.tools;

import android.view.View;

/**
 * Created by onekey on 19-7-8.
 */

public class ViewTool {

    private ViewTool() {
    }

    public static void hideView(View view) {
        if (view == null || View.GONE == view.getVisibility()) return;
        view.setVisibility(View.GONE);
    }

    public static void showView(View view) {
        if (view == null || View.VISIBLE == view.getVisibility()) return;
        view.setVisibility(View.VISIBLE);
    }
}
