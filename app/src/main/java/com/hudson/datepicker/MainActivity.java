package com.hudson.datepicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.creator.DatePickerCreator;
import com.hudson.datepicker.creator.types.YearType;
import com.hudson.datepicker.entity.Date;
import com.hudson.wheelview.adapter.WheelViewConfig;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WheelViewConfig config = new WheelViewConfig();
        config.setFocusColor(Color.parseColor("#4DA2FD"));
        DatePickerCreator.setConfig(config);

        LinearLayout container = (LinearLayout) findViewById(R.id.ll_container);

        IDatePicker datePicker = DatePickerCreator.createYearDatePicker(YearType.TypeYearToMinute,
                container, 2000, 2100);
        datePicker.setDefaultDate(new Date(2019,1,1,0,0));

//        IDatePicker monthDatePicker = DatePickerCreator.createMonthDatePicker(MonthType.TypeMonthOnly, container, 2019);
//        monthDatePicker.setDefaultDate(new Date(2019,2,27,0,0));

//        IDatePicker hourDatePicker = DatePickerCreator.createHourDatePicker(HourType.TypeHourMinute, container);
//        hourDatePicker.setDefaultDate(new Date(2019,2,27,5,0));

    }
}
