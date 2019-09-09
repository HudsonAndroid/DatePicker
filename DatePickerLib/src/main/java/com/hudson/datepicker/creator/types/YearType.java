package com.hudson.datepicker.creator.types;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hudson.datepicker.AbsWheelView;
import com.hudson.datepicker.ConcreteComponent.YearWheelView;
import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.decorator.DayWheelView;
import com.hudson.datepicker.decorator.HourWheelView;
import com.hudson.datepicker.decorator.MinuteWheelView;
import com.hudson.datepicker.decorator.MonthWheelView;

/**
 * Created by Hudson on 2019/9/8.
 */
public enum YearType implements IYearType {
    TypeYearOnly{
        @Override
        public IDatePicker initDatePicker(LinearLayout container,int startYear,int endYear) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            Context context = container.getContext();
            AbsWheelView year = new YearWheelView(context);
            year.setRange(startYear,endYear);
            year.setLayoutParams(params);
            container.addView(year);
            return year;
        }
    },

    TypeYearMonth{
        @Override
        public IDatePicker initDatePicker(LinearLayout parent, int startYear, int endYear) {
            IDatePicker datePicker = TypeYearOnly.initDatePicker(parent, startYear, endYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView month = new MonthWheelView(parent.getContext(),datePicker);
            month.setLayoutParams(params);
            parent.addView(month);
            return month;
        }
    },
    TypeYearToDay{
        @Override
        public IDatePicker initDatePicker(LinearLayout parent, int startYear, int endYear) {
            IDatePicker datePicker = TypeYearMonth.initDatePicker(parent, startYear, endYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView day = new DayWheelView(parent.getContext(),datePicker);
            day.setLayoutParams(params);
            parent.addView(day);
            return day;
        }
    },
    TypeYearToHour{
        @Override
        public IDatePicker initDatePicker(LinearLayout container,int startYear,int endYear) {
            IDatePicker datePicker = TypeYearToDay.initDatePicker(container, startYear, endYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView hour = new HourWheelView(container.getContext(),datePicker);
            hour.setLayoutParams(params);
            container.addView(hour);
            return hour;
        }
    },
    TypeYearToMinute{
        @Override
        public IDatePicker initDatePicker(LinearLayout container,int startYear,int endYear) {
            IDatePicker datePicker = TypeYearToHour.initDatePicker(container, startYear, endYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView minute = new MinuteWheelView(container.getContext(),datePicker);
            minute.setLayoutParams(params);
            container.addView(minute);
            return minute;
        }
    }
}
