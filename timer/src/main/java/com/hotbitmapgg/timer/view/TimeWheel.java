package com.hotbitmapgg.timer.view;

import android.content.Context;
import android.view.View;

import com.hotbitmapgg.timer.R;
import com.hotbitmapgg.timer.adapters.NumericWheelAdapter;
import com.hotbitmapgg.timer.config.PickerConfig;
import com.hotbitmapgg.timer.controller.IController;
import com.hotbitmapgg.timer.utils.PickerContants;
import com.hotbitmapgg.timer.utils.Utils;
import com.hotbitmapgg.timer.wheel.WheelView;

/**
 * 计时器
 */
public class TimeWheel
{

    Context mContext;

    WheelView hour, minute, second;

    NumericWheelAdapter mHourAdapter, mMinuteAdapter, mSecondAdapter;

    IController mIController;

    PickerConfig mPickerConfig;


    public TimeWheel(IController iController, View view, PickerConfig pickerConfig)
    {

        mIController = iController;
        mPickerConfig = pickerConfig;
        mContext = view.getContext();
        initialize(view);
    }


    public void initialize(View view)
    {

        initView(view);
        initHour();
        initMinute();
        initSecond();
    }


    void initView(View view)
    {
        hour = (WheelView) view.findViewById(R.id.hour);
        minute = (WheelView) view.findViewById(R.id.minute);
        second = (WheelView) view.findViewById(R.id.second);

        switch (mPickerConfig.mType)
        {

            case 1:
                Utils.hideViews(second);
                break;
            case 2:
                Utils.hideViews(hour);
                break;
            case 3:

                break;

        }
    }


    void initHour()
    {
        int minHour = mIController.getMinHour();
        int maxHour = mIController.getMaxHour();

        mHourAdapter = new NumericWheelAdapter(mContext, minHour, maxHour, PickerContants.FORMAT, mPickerConfig.mHour);
        mHourAdapter.setConfig(mPickerConfig);
        hour.setViewAdapter(mHourAdapter);
    }

    void initMinute()
    {

        int minMinute = mIController.getMinMinute();
        int maxMinute = mIController.getMaxMinute();
        mMinuteAdapter = new NumericWheelAdapter(mContext, minMinute, maxMinute, PickerContants.FORMAT, mPickerConfig.mMinute);
        mMinuteAdapter.setConfig(mPickerConfig);
        minute.setCyclic(mPickerConfig.cyclic);
        minute.setViewAdapter(mMinuteAdapter);
    }

    void initSecond()
    {

        int minSecond = mIController.getMinSecond();
        int maxSecond = mIController.getMaxSecond();
        mSecondAdapter = new NumericWheelAdapter(mContext, minSecond, maxSecond, PickerContants.FORMAT, mPickerConfig.mSecond);
        mSecondAdapter.setConfig(mPickerConfig);
        second.setCyclic(mPickerConfig.cyclic);
        second.setViewAdapter(mSecondAdapter);
    }


    public int getCurrentHour()
    {
        return hour.getCurrentItem() + mIController.getMinHour();
    }

    public int getCurrentMinute()
    {

        return minute.getCurrentItem() + mIController.getMinMinute();
    }

    public int getCurrentSecond()
    {

        return second.getCurrentItem() + mIController.getMinSecond();
    }
}
