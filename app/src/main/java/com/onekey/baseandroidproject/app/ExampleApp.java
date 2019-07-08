package com.onekey.baseandroidproject.app;

import android.app.Application;

/**
 * Created by onekey on 19-7-8.
 */

public class ExampleApp extends Application {

    private static ExampleApp mExampleApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mExampleApp = this;
    }

    public static Application instance() {
        return mExampleApp;
    }
}
