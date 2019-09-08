package com.hudson.datepicker.creator;

import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.creator.types.HourType;
import com.hudson.datepicker.creator.types.MonthType;
import com.hudson.datepicker.creator.types.YearType;
import com.hudson.wheelview.adapter.WheelViewConfig;

/**
 * Created by Hudson on 2019/9/8.
 */
public class DatePickerCreator {

    private volatile static WheelViewConfig sConfig = null;

    public static WheelViewConfig getConfig(){
        if(sConfig == null){
            sConfig = new WheelViewConfig();
        }
        return sConfig;
    }

    public static void setConfig(@NonNull WheelViewConfig config){
        sConfig = config;
    }

    public static IDatePicker createYearDatePicker(YearType type, LinearLayout parent,
                                                   int startYear, int endYear){
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setGravity(Gravity.CENTER_VERTICAL);
        return type.initDatePicker(parent,startYear,endYear);
    }

    public static IDatePicker createMonthDatePicker(MonthType type,LinearLayout parent,int targetYear){
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setGravity(Gravity.CENTER_VERTICAL);
        return type.initDatePicker(parent,targetYear);
    }

    public static IDatePicker createHourDatePicker(HourType type,LinearLayout parent){
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setGravity(Gravity.CENTER_VERTICAL);
        return type.initDatePicker(parent);
    }
}
