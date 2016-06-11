package com.hotbitmapgg.timermeterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hotbitmapgg.timer.TimerMeteriew;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private TimerMeteriew mTimerMeteriew;

    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTimerMeteriew = (TimerMeteriew) findViewById(R.id.time_view);
        mStart = (Button) findViewById(R.id.btn_start);
        mStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btn_start:

                String time = formatTime(mTimerMeteriew.getCurrentMillSeconds());
                Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private String formatTime(long time)
    {

        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        String str = formatter.format(new Date(time));
        return str;
    }
}
