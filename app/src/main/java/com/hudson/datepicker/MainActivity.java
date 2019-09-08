package com.hudson.datepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.hudson.datepicker.component.IDatePicker;
import com.hudson.datepicker.creator.DatePickerCreator;
import com.hudson.datepicker.creator.types.DatePickerType;
import com.hudson.datepicker.entity.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = (LinearLayout) findViewById(R.id.ll_container);

        IDatePicker datePicker = DatePickerCreator.createDatePicker(DatePickerType.TypeYearToHour,
                container, 2000, 2100);
        datePicker.setDefaultDate(new Date(2019,9,8,16,0));
    }
}
