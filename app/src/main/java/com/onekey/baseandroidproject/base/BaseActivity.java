package com.onekey.baseandroidproject.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by onekey on 19-6-27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentID());
        initView(savedInstanceState);
    }

    protected abstract int getContentID();

    protected abstract void initView(Bundle bundle);

    public void toAct(Class<? extends Activity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void log(String msg) {
        Log.e(TAG, msg);
    }

    public void showToast(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }
}
