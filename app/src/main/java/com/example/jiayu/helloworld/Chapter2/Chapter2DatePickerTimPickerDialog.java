package com.example.jiayu.helloworld.Chapter2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.jiayu.helloworld.R;

import java.util.Calendar;

public class Chapter2DatePickerTimPickerDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_date_picker_tim_picker_dialog);

        Button datebn = (Button) findViewById(R.id.dateBn);
        Button timebn = (Button) findViewById(R.id.timeBn);


        datebn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);



                new DatePickerDialog(Chapter2DatePickerTimPickerDialog.this,
                        new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet (DatePicker view,int year, int monthOfYear, int dayOfMonth){
                    EditText show = (EditText) findViewById(R.id.show);
                    show.setText("你选择了： " + year + "年 " + monthOfYear + "月 " + dayOfMonth + "日");
                }

                            year,
                            month,
                            day
                        });
            }




    }
}
