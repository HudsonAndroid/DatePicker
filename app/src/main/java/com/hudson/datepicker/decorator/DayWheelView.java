package com.hudson.datepicker.decorator;

import android.content.Context;
import android.support.annotation.Nullable;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;
import com.hudson.wheelview.listener.OnSelectChangedListener;

/**
 * Created by Hudson on 2019/9/8.
 */
public class DayWheelView extends AbsDecorator {
    private static final int DEFAULT_MAX_DAY = 31;
    private static final int MIN_DAY = 1;
    private MonthWheelView mMonthWheelView;

    public DayWheelView(Context context,@Nullable IDatePicker concreteComponent) {
        super(context, concreteComponent);
        if(concreteComponent instanceof MonthWheelView){
            mMonthWheelView = (MonthWheelView) concreteComponent;
            mMonthWheelView.setOnJanYearChangeListener(new MonthWheelView.OnJanMonthWithYearChangeListener() {
                @Override
                public void onJanMonthYearChange(int year) {
                    //When it's February,we should watch the year change
                    setRange(MIN_DAY,mMonthWheelView.getMonthDays());
                }
            });
            mMonthWheelView.setOnSelectChangedListener(new OnSelectChangedListener() {
                @Override
                public void onSelectChanged(int selection) {
                    setRange(MIN_DAY,mMonthWheelView.getMonthDays());
                }
            });
        }
    }

    @Override
    protected int getDateValue(Date date) {
        return date.getDay();
    }

    @Override
    protected Date getMyselfDate(Date date) {
        date.setDay(getCurrentSelect());
        return date;
    }

    @Override
    protected int getDefaultMinValue() {
        return MIN_DAY;
    }

    @Override
    protected int getDefaultMaxValue() {
        return DEFAULT_MAX_DAY;
    }

    @Override
    public void setRange(int minValue, int maxValue) {
        super.setRange(MIN_DAY, maxValue);
    }
}
