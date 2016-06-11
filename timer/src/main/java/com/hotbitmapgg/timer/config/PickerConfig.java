package com.hotbitmapgg.timer.config;


/**
 * 根据用户设置的值来配置计时器
 */
public class PickerConfig
{

    public int mType = DefaultConfig.TYPE;

    public int mThemeColor = DefaultConfig.COLOR;

    public int mWheelTVNormalColor = DefaultConfig.TV_NORMAL_COLOR;

    public int mWheelTVSelectorColor = DefaultConfig.TV_SELECTOR_COLOR;

    public int mWheelTVSize = DefaultConfig.TV_SIZE;

    public boolean cyclic = DefaultConfig.CYCLIC;

    public String mHour = DefaultConfig.HOUR;

    public String mMinute = DefaultConfig.MINUTE;

    public String mSecond = DefaultConfig.SECOND;

    /**
     * The min timeMillseconds
     */
    public WheelCalendar mMinCalendar = new WheelCalendar(0);

    /**
     * The default selector timeMillseconds
     */
    public WheelCalendar mCurrentCalendar = new WheelCalendar(System.currentTimeMillis());
}
