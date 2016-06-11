package com.hotbitmapgg.timer.controller;


import com.hotbitmapgg.timer.config.WheelCalendar;


public interface IController
{


    int getMinHour();

    int getMaxHour();

    int getMinMinute();

    int getMaxMinute();

    int getMaxSecond();

    int getMinSecond();

    boolean isNoRange();

    WheelCalendar getDefaultCalendar();
}
