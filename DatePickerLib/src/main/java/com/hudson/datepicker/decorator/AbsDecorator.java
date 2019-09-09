package com.hudson.datepicker.decorator;

import android.content.Context;
import android.support.annotation.Nullable;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;

/**
 * The base class for decorating other {@link IDatePicker}.
 *
 * However,this decorator can also be decorated by other {@link IDatePicker}
 * Created by Hudson on 2019/9/8.
 */
public abstract class AbsDecorator extends AbsWheelView {
    protected IDatePicker mConcreteComponent;

    /**
     * abstract decorator constructor
     * @param context context for create view
     * @param concreteComponent the component who will be decorated. If it's null,
     *                          this component just is the lowest level component.
     */
    public AbsDecorator(Context context,@Nullable IDatePicker concreteComponent) {
        super(context);
        mConcreteComponent = concreteComponent;
    }

    @Override
    public void setDefaultDate(Date date) {
        if(mConcreteComponent != null){
            mConcreteComponent.setDefaultDate(date);
        }
        super.setDefaultDate(date);
    }

    @Override
    public final Date getDate() {
        Date date;
        if(mConcreteComponent != null){
            date = mConcreteComponent.getDate();
        }else{
            date = new Date();//if this component is the lowest level,use new object
        }
        return getMyselfDate(date);
    }

    protected abstract Date getMyselfDate(Date date);
}
