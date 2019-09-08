package com.hudson.datepicker.creator.types;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.decorator.DayWheelView;
import com.hudson.datepicker.decorator.MonthWheelView;

/**
 * Created by Hudson on 2019/9/8.
 */
public enum MonthType implements IMonthType {
    TypeMonthOnly{
        @Override
        public IDatePicker initDatePicker(LinearLayout container, int targetYear) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            Context context = container.getContext();
            MonthWheelView month = new MonthWheelView(context,null);
            month.setLayoutParams(params);
            month.setTargetYear(targetYear);
            container.addView(month);
            return month;
        }
    },
    TypeMonthDay{
        @Override
        public IDatePicker initDatePicker(LinearLayout parent, int targetYear) {
            IDatePicker datePicker = TypeMonthOnly.initDatePicker(parent, targetYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView day = new DayWheelView(parent.getContext(),datePicker);
            day.setLayoutParams(params);
            parent.addView(day);
            return day;
        }
    }
}
