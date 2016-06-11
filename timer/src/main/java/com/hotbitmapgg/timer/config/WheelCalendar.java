package com.hotbitmapgg.timer.config;

import java.util.Calendar;


public class WheelCalendar
{

    public int year, month, day, hour, minute, second;

    private boolean noRange;

    public WheelCalendar(long millseconds)
    {

        initData(millseconds);
    }

    private void initData(long millseconds)
    {

        if (millseconds == 0)
        {
            noRange = true;
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millseconds);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }

    public boolean isNoRange()
    {

        return noRange;
    }
}
