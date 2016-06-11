package com.hotbitmapgg.timer.adapters;

import android.content.Context;
import android.text.TextUtils;

/**
 * Numeric Wheel adapter.
 */
public class NumericWheelAdapter extends AbstractWheelTextAdapter
{

    /**
     * The default min value
     */
    public static final int DEFAULT_MAX_VALUE = 9;

    /**
     * The default max value
     */
    private static final int DEFAULT_MIN_VALUE = 0;

    // Values
    private int minValue;

    private int maxValue;

    // format
    private String format;

    //unit
    private String unit;


    /**
     * Constructor
     *
     * @param context the current context
     */
    public NumericWheelAdapter(Context context)
    {

        this(context, DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    /**
     * Constructor
     *
     * @param context  the current context
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     */
    public NumericWheelAdapter(Context context, int minValue, int maxValue)
    {

        this(context, minValue, maxValue, null);
    }

    /**
     * Constructor
     *
     * @param context  the current context
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     * @param format   the format string
     */
    public NumericWheelAdapter(Context context, int minValue, int maxValue, String format)
    {

        this(context, minValue, maxValue, format, null);
    }

    /**
     * Constructor
     *
     * @param context  the current context
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     * @param format   the format string
     * @param unit     the wheel unit value
     */
    public NumericWheelAdapter(Context context, int minValue, int maxValue, String format, String unit)
    {

        super(context);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.format = format;
        this.unit = unit;
    }

    @Override
    public CharSequence getItemText(int index)
    {

        if (index >= 0 && index < getItemsCount())
        {
            int value = minValue + index;
            String text = !TextUtils.isEmpty(format) ? String.format(format, value) : Integer.toString(value);
            text = TextUtils.isEmpty(unit) ? text : text + unit;

            return text;
        }
        return null;
    }

    @Override
    public int getItemsCount()
    {

        return maxValue - minValue + 1;
    }
}
