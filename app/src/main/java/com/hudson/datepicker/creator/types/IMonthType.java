package com.hudson.datepicker.creator.types;

import android.widget.LinearLayout;

import com.hudson.datepicker.component.IDatePicker;

/**
 * Created by Hudson on 2019/9/8.
 */
public interface IMonthType {
    IDatePicker initDatePicker(LinearLayout parent, int targetYear);
}
