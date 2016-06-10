package com.example.jiayu.helloworld.Chapter2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.jiayu.helloworld.R;

public class Chapter2ProcessBar extends AppCompatActivity {

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;

    ProgressBar bar, bar2;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x111) {
                bar.setProgress(status);
                bar2.setProgress(status);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_process_bar);

        bar = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);

        new Thread()
        {
            public void run() {
                while (status < 100) {
                    status = doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    public int doWork() {
        data[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
