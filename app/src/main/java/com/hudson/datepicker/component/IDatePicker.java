package com.hudson.datepicker.component;

import com.hudson.datepicker.entity.Date;

/**
 * Created by Hudson on 2019/9/8.
 */
public interface IDatePicker {
    Date getDate();
    void setDefaultDate(Date date);
}
