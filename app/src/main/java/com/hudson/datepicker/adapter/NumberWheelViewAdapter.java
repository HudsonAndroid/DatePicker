package com.hudson.datepicker.adapter;

import android.support.annotation.NonNull;

import com.hudson.wheelview.adapter.WheelViewAdapter;
import com.hudson.wheelview.adapter.WheelViewConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hudson on 2019/9/8.
 */
public class NumberWheelViewAdapter extends WheelViewAdapter<Integer> {

    public NumberWheelViewAdapter(@NonNull WheelViewConfig config) {
        super(config);
    }

    public void setRange(int min, int max){
        List<Integer> datas = new ArrayList<>();
        for(int i=min;i<=max;i++){
            datas.add(i);
        }
        refreshList(datas);
    }
}
