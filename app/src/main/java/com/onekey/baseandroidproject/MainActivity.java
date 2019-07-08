package com.onekey.baseandroidproject;

import android.os.Bundle;
import android.view.View;

import com.onekey.baseandroidproject.base.BaseActivity;
import com.onekey.baseandroidproject.bean.DoubleAgeStudent;
import com.onekey.baseandroidproject.bean.Student;
import com.onekey.baseandroidproject.module.dialog.DialogActivity;
import com.onekey.baseandroidproject.tools.GsonTool;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle bundle) {
        Student one = new Student("one");
        one.setAge(3);
        one.setId("123");
        log(GsonTool.toJson(one));
        one.setId(null);
        log(GsonTool.toJson(one));
        String nullS = GsonTool.createIncludeNull().toJson(one);
        log(nullS);
        // id的null字符串转化为“”
        Student two = GsonTool.fromJson(nullS, Student.class);
        log("one-id: " + one.getId() + " | two-id: " + two.getId().length());

        DoubleAgeStudent ageStudent = new DoubleAgeStudent(null);
        nullS = GsonTool.createIncludeNull().toJson(ageStudent);
        log(nullS);
        two = GsonTool.fromJson(nullS, Student.class);//若没添加DOUBLE_INT,此处会抛异常。
        log("" + two.getId().length() + two.getName().length() + two.getAge());//000
    }

    public void onBaseClick(View view) {
        switch (view.getId()) {
            case R.id.tvBaseToDialog:
                toAct(DialogActivity.class);
                break;
        }
    }
}
