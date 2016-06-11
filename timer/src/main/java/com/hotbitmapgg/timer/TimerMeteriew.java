package com.hotbitmapgg.timer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.hotbitmapgg.timer.config.DefaultConfig;
import com.hotbitmapgg.timer.config.PickerConfig;
import com.hotbitmapgg.timer.config.WheelCalendar;
import com.hotbitmapgg.timer.controller.ControllerImpl;
import com.hotbitmapgg.timer.view.TimeWheel;

import java.util.Calendar;


public class TimerMeteriew extends FrameLayout
{

    private PickerConfig mPickerConfig;

    private ControllerImpl mIController;

    private TimeWheel mTimeWheel;


    public TimerMeteriew(Context context)
    {

        this(context, null);
    }

    public TimerMeteriew(Context context, AttributeSet attrs)
    {

        this(context, attrs, 0);
    }

    public TimerMeteriew(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimerMeterView);
        int lineColor = typedArray.getColor(R.styleable.TimerMeterView_line_bg, DefaultConfig.COLOR);
        int normalTextColor = typedArray.getColor(R.styleable.TimerMeterView_normal_text_color, DefaultConfig.TV_NORMAL_COLOR);
        int selectTextColor = typedArray.getColor(R.styleable.TimerMeterView_select_text_color, DefaultConfig.TV_SELECTOR_COLOR);
        int textSize = typedArray.getInteger(R.styleable.TimerMeterView_text_size, DefaultConfig.TV_SIZE);
        boolean isCyclic = typedArray.getBoolean(R.styleable.TimerMeterView_cyclic, DefaultConfig.CYCLIC);
        int timerType = typedArray.getInteger(R.styleable.TimerMeterView_timer_type, DefaultConfig.TYPE);

        typedArray.recycle();


        mPickerConfig = new PickerConfig();
        mPickerConfig.cyclic = isCyclic;
        mPickerConfig.mThemeColor = lineColor;
        mPickerConfig.mWheelTVNormalColor = normalTextColor;
        mPickerConfig.mWheelTVSelectorColor = selectTextColor;
        mPickerConfig.mWheelTVSize = textSize;
        mPickerConfig.mType = timerType;
        mIController = new ControllerImpl(mPickerConfig);
        View view = inflate(context, R.layout.timer_layout, null);
        mTimeWheel = new TimeWheel(mIController, view, mPickerConfig);
        addView(view);
    }

    public long getCurrentMillSeconds()
    {

        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        calendar.set(Calendar.HOUR_OF_DAY, mTimeWheel.getCurrentHour());
        calendar.set(Calendar.MINUTE, mTimeWheel.getCurrentMinute());
        calendar.set(Calendar.SECOND, mTimeWheel.getCurrentSecond());

        return calendar.getTimeInMillis();
    }


    public void setMinMillseconds(long millseconds)
    {

        mPickerConfig.mMinCalendar = new WheelCalendar(millseconds);
    }

    public void setCurrentMillseconds(long millseconds)
    {

        mPickerConfig.mCurrentCalendar = new WheelCalendar(millseconds);
    }
}
