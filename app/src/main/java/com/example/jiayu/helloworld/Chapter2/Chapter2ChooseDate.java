package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.jiayu.helloworld.R;

import java.util.Calendar;

public class Chapter2ChooseDate extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int mintue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_choose_date);

        DatePicker datePicker = (DatePicker) findViewById(R.id.dataPicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        mintue = c.get(Calendar.MINUTE);

        assert datePicker != null;
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Chapter2ChooseDate.this.year = year;
                Chapter2ChooseDate.this.month = monthOfYear;
                Chapter2ChooseDate.this.day = dayOfMonth;
                showDate(year, month, day, hour, mintue);
            }
        });

        assert timePicker != null;
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Chapter2ChooseDate.this.hour = hourOfDay;
                Chapter2ChooseDate.this.mintue = minute;

                showDate(year, month, day, hour, mintue);
            }
        });

    }

    private void showDate(int year, int month, int day, int hour, int mintue) {
        EditText show = (EditText) findViewById(R.id.show);
        show.setText("你购买的日期为：" + year + "年" + month + "月" + day + "日" + hour + "时" + mintue + "分");
    }
}
