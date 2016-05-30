package com.example.jiayu.helloworld.Chapter2;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.jiayu.helloworld.R;

public class Chapter2Chronometer extends AppCompatActivity {

    Chronometer ch;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_chronometer);

        ch = (Chronometer) findViewById(R.id.chronometer_test);
        start = (Button) findViewById(R.id.chronometer_start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                start.setEnabled(false);
            }
        });

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime() - ch.getBase() > 20*1000)
                {
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });

    }
}
