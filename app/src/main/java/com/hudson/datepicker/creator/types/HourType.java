package com.hudson.datepicker.creator.types;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.decorator.HourWheelView;
import com.hudson.datepicker.decorator.MinuteWheelView;

/**
 * Created by Hudson on 2019/9/8.
 */
public enum  HourType implements IHourType {
    TypeHourOnly{
        @Override
        public IDatePicker initDatePicker(LinearLayout container) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            Context context = container.getContext();
            AbsWheelView hour = new HourWheelView(context,null);
            hour.setLayoutParams(params);
            container.addView(hour);
            return hour;
        }
    },
    TypeHourMinute{
        @Override
        public IDatePicker initDatePicker(LinearLayout parent) {
            IDatePicker datePicker = TypeHourOnly.initDatePicker(parent);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView minute = new MinuteWheelView(parent.getContext(),datePicker);
            minute.setLayoutParams(params);
            parent.addView(minute);
            return minute;
        }
    }
}
