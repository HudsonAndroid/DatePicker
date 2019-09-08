package com.hudson.datepicker.decorator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hudson.datepicker.ConcreteComponent.YearWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;
import com.hudson.wheelview.listener.OnSelectChangedListener;

/**
 * Created by Hudson on 2019/9/8.
 */
public class MonthWheelView extends AbsDecorator {
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private int mJanDays = -1;
    private YearWheelView mYearWheelView;

    public MonthWheelView(Context context,@Nullable IDatePicker concreteComponent) {
        super(context, concreteComponent);
        mYearWheelView = ((YearWheelView) concreteComponent);
    }

    @Override
    protected int getDefaultMinValue() {
        return MIN_MONTH;
    }

    @Override
    protected int getDefaultMaxValue() {
        return MAX_MONTH;
    }

    public void setJanDays(int janDays) {
        if(janDays == 28 || janDays == 29){
            mJanDays = janDays;
        }
    }

    @Override
    protected int getDateValue(Date date) {
        return date.getMonth();
    }

    @Override
    protected Date getMyselfDate(Date date) {
        date.setMonth(getCurrentSelect());
        return date;
    }

    @Override
    public void setRange(int minValue, int maxValue) {
        super.setRange(MIN_MONTH, MAX_MONTH);
    }
    
    int getMonthDays(){
        int currentSelect = getCurrentSelect();
        if(currentSelect < 1 || currentSelect > 12){
            Log.w("MonthWheelView","the month select is invalid");
            return 0;
        }
        switch (currentSelect){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(mYearWheelView != null){
                    mYearWheelView.setOnSelectChangedListener(null);
                }
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                if(mYearWheelView != null){
                    mYearWheelView.setOnSelectChangedListener(null);
                }
                return 30;
            case 2:
                if(mJanDays != -1){
                    return mJanDays;
                }else{
                    if(mYearWheelView != null){
                        mYearWheelView.setOnSelectChangedListener(new OnSelectChangedListener() {
                            @Override
                            public void onSelectChanged(int selection) {
                                if(mJanYearChangeListener != null){
                                    mJanYearChangeListener.onJanMonthYearChange(
                                            mYearWheelView.getCurrentSelect());
                                }
                            }
                        });
                        int year = mYearWheelView.getCurrentSelect();
                        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                            return 29;
                        }
                    }else{
                        Log.w("MonthWheelView","the target year is not specific," +
                                "days of February use 28 for default.");
                    }
                    return 28;
                }
            default:
                return 0;
        }
    }

    private OnJanMonthWithYearChangeListener mJanYearChangeListener;
    public interface OnJanMonthWithYearChangeListener{
        void onJanMonthYearChange(int year);
    }

    public void setOnJanYearChangeListener(OnJanMonthWithYearChangeListener janYearChangeListener) {
        mJanYearChangeListener = janYearChangeListener;
    }
}
