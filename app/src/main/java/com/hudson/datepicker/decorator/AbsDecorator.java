package com.hudson.datepicker.decorator;

import android.content.Context;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;

/**
 * Created by Hudson on 2019/9/8.
 */
public abstract class AbsDecorator extends AbsWheelView {
    protected IDatePicker mConcreteComponent;

    public AbsDecorator(Context context,IDatePicker concreteComponent) {
        super(context);
        mConcreteComponent = concreteComponent;
    }

    @Override
    public void setDefaultDate(Date date) {
        mConcreteComponent.setDefaultDate(date);
        super.setDefaultDate(date);
    }
}
