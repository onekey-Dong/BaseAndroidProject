package com.onekey.baseandroidproject.tools;

import android.graphics.drawable.Drawable;

import com.onekey.baseandroidproject.app.ExampleApp;

/**
 * Created by onekey on 19-7-8.
 */

public class ResourceTool {

    private ResourceTool() {
    }

    public static int getColor(int res) {
        return ExampleApp.instance().getResources().getColor(res);
    }

    public static String getString(int res) {
        return ExampleApp.instance().getResources().getString(res);
    }

    public static String getString(int res, Object... strings) {
        return ExampleApp.instance().getResources().getString(res, strings);
    }

    public static Drawable getDrawable(int res) {
        return ExampleApp.instance().getResources().getDrawable(res);
    }
}
