package com.hudson.datepicker.ConcreteComponent;

import android.content.Context;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.entity.Date;


/**
 * Who will be decorated by other {@link IDatePicker}.
 *
 * It is different with other components,it cannot decorate others.
 *
 * 它不同于其他的，它已经是最底层的了，没法在包装别的了。
 * Created by Hudson on 2019/9/8.
 */
public class YearWheelView extends AbsWheelView implements IDatePicker {

    public YearWheelView(Context context) {
        super(context);
    }

    @Override
    public Date getDate() {
        Date date = new Date();
        date.setYear(getCurrentSelect());
        return date;
    }

    @Override
    protected int getDateValue(Date date) {
        return date.getYear();
    }
}
