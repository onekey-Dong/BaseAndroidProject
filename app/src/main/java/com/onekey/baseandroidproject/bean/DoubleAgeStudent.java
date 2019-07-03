package com.onekey.baseandroidproject.bean;

/**
 * Created by onekey on 19-7-3.
 */

public class DoubleAgeStudent {

    private String name;
    private String id;
    private double age;

    public DoubleAgeStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
