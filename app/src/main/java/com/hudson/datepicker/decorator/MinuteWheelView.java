package com.hudson.datepicker.decorator;

import android.content.Context;
import android.support.annotation.Nullable;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;

/**
 * Created by Hudson on 2019/9/8.
 */
public class MinuteWheelView extends AbsDecorator {
    private static final int MAX_MINUTE = 59;
    private static final int MIN_MINUTE = 0;

    public MinuteWheelView(Context context,@Nullable IDatePicker concreteComponent) {
        super(context, concreteComponent);
    }

    @Override
    protected int getDateValue(Date date) {
        return date.getMinute();
    }

    @Override
    protected Date getMyselfDate(Date date) {
        date.setMinute(getCurrentSelect());
        return date;
    }

    @Override
    protected int getDefaultMaxValue() {
        return MAX_MINUTE;
    }

    @Override
    protected int getDefaultMinValue() {
        return MIN_MINUTE;
    }

    @Override
    public void setRange(int minValue, int maxValue) {
        super.setRange(MIN_MINUTE, MAX_MINUTE);
    }
}
