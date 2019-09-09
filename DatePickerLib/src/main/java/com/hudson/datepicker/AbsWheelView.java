package com.hudson.datepicker;

import android.content.Context;
import android.util.Log;

import com.hudson.datepicker.adapter.NumberWheelViewAdapter;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.creator.DatePickerCreator;
import com.hudson.datepicker.entity.Date;
import com.hudson.wheelview.WheelView;



/**
 * Created by Hudson on 2019/9/8.
 */
public abstract class AbsWheelView extends WheelView implements IDatePicker {
    private int mMaxValue;
    private int mMinValue;
    private NumberWheelViewAdapter mAdapter;

    public AbsWheelView(Context context) {
        super(context);
        mAdapter = new NumberWheelViewAdapter(DatePickerCreator.getConfig());
        setWheelViewAdapter(mAdapter);
        if(getDefaultMinValue() != -1 && getDefaultMaxValue() != -1){
            setRange(getDefaultMinValue(),getDefaultMaxValue());
        }
    }

    /**
     * set the range from minValue to maxValue
     * @param minValue min value,maybe it's no effects to some picker,such as month,day,etc.
     * @param maxValue max value
     */
    public void setRange(int minValue,int maxValue){
        mAdapter.setRange(minValue,maxValue);
        mMinValue = minValue;
        mMaxValue = maxValue;
    }

    //the get target number from date entity
    protected abstract int getDateValue(Date date);

    @Override
    public void setDefaultDate(Date date){
        int select = getDateValue(date);
        if(select < mMinValue){
            Log.w(getClass().getSimpleName(),"your input is invalid,the minimum value is "+mMinValue);
            select = mMinValue;
        }else if(select > mMaxValue){
            Log.w(getClass().getSimpleName(),"your input is invalid,the maximum value is "+mMaxValue);
            select = mMaxValue;
        }
        setSelection(select - mMinValue);
    }

    protected int getDefaultMinValue(){
        return -1;
    }

    protected int getDefaultMaxValue(){
        return -1;
    }

    /**
     * get current select
     * @return select number
     */
    public int getCurrentSelect(){
        return getSelection() + mMinValue;
    }
}
