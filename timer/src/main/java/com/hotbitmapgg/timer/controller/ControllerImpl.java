package com.hotbitmapgg.timer.controller;


import com.hotbitmapgg.timer.config.PickerConfig;
import com.hotbitmapgg.timer.config.WheelCalendar;
import com.hotbitmapgg.timer.utils.PickerContants;


public class ControllerImpl implements IController
{

    PickerConfig mPickerConfig;

    WheelCalendar mCalendarMin;

    public ControllerImpl(PickerConfig pickerConfig)
    {

        mPickerConfig = pickerConfig;
        mCalendarMin = pickerConfig.mMinCalendar;
    }

    @Override
    public int getMinHour()
    {

        return PickerContants.MIN_HOUR;
    }

    @Override
    public int getMaxHour()
    {

        return PickerContants.MAX_HOUR;
    }

    @Override
    public int getMinMinute()
    {

        return PickerContants.MIN_MINUTE;
    }

    @Override
    public int getMaxMinute()
    {

        return PickerContants.MAX_MINUTE;
    }

    @Override
    public int getMaxSecond()
    {

        return PickerContants.MAX_SECOND;
    }

    @Override
    public int getMinSecond()
    {

        return PickerContants.MIN_SECOND;
    }


    @Override
    public boolean isNoRange()
    {

        return mCalendarMin.isNoRange();
    }

    @Override
    public WheelCalendar getDefaultCalendar()
    {

        return mPickerConfig.mCurrentCalendar;
    }
}
