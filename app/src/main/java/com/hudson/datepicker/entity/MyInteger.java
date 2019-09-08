package com.hudson.datepicker.entity;

import android.support.annotation.NonNull;

/**
 * Created by Hudson on 2019/9/8.
 */
public class MyInteger {
    private int mValue;

    public MyInteger(int value) {
        mValue = value;
    }

    // wheel view item entity must implement this method
    @NonNull
    @Override
    public String toString() {
        if(mValue < 10 && mValue >= 0){
            return "0"+mValue;
        }
        return String.valueOf(mValue);
    }
}
