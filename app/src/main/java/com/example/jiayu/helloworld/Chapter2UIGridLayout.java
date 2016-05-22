package com.example.jiayu.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;

public class Chapter2UIGridLayout extends AppCompatActivity {

    GridLayout gridLayout;

    String[] chars = new String[]
            {
              "7", "8", "9", "/",
              "4", "5", "6", "*",

              "1", "0", "=", "+"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_uigrid_layout);

    }
}
