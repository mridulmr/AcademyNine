package com.example.academynine;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button datepicker, timepicker;
    EditText date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datepicker = findViewById(R.id.btn_date);
        timepicker = findViewById(R.id.btn_time);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        datepicker.setOnClickListener(this);
        timepicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == datepicker)
        {
            final Calendar c = Calendar.getInstance();
            int Year = c.get(Calendar.YEAR);
            int Month = c.get(Calendar.MONTH);
            int Day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
            {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
                }, Year, Month, Day);
            datePickerDialog.show();
        }

        if (v == timepicker)
        {
            final Calendar c = Calendar.getInstance();
            int Hour = c.get(Calendar.HOUR_OF_DAY);
            int Minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener()
            {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                {
                    String am_pm;

                    if(hourOfDay > 12)
                    {
                        am_pm = "PM";
                        hourOfDay = hourOfDay - 12;
                    }
                    else
                    {
                        am_pm ="AM";
                    }
                    time.setText(hourOfDay + ":" + minute + ":" + am_pm);
                }
                }, Hour, Minute, true);
            timePickerDialog.show();
        }
    }
}