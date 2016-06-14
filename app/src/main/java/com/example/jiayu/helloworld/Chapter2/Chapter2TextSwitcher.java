package com.example.jiayu.helloworld.Chapter2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.jiayu.helloworld.R;
import com.example.jiayu.helloworld.Uiltity.Constants;

public class Chapter2TextSwitcher extends AppCompatActivity {

    String[] strs = Constants.books;
    int curStr;
    TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_text_switcher);

        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(Chapter2TextSwitcher.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });

        next(null);
    }

    public void next(View view) {
        textSwitcher.setText(strs[curStr++ % strs.length]);

    }
}
