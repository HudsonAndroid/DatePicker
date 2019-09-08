package com.hudson.datepicker.decorator;

import android.content.Context;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;

/**
 * Created by Hudson on 2019/9/8.
 */
public class HourWheelView extends AbsDecorator {
    private static final int MAX_HOUR = 23;
    private static final int MIN_HOUR = 0;

    public HourWheelView(Context context, IDatePicker concreteComponent) {
        super(context, concreteComponent);
    }

    @Override
    protected int getDateValue(Date date) {
        return date.getHour();
    }

    @Override
    public Date getDate() {
        Date date = mConcreteComponent.getDate();
        date.setHour(getCurrentSelect());
        return date;
    }

    @Override
    protected int getDefaultMinValue() {
        return MIN_HOUR;
    }

    @Override
    protected int getDefaultMaxValue() {
        return MAX_HOUR;
    }

    @Override
    public void setRange(int minValue, int maxValue) {
        super.setRange(MIN_HOUR, MAX_HOUR);
    }
}
