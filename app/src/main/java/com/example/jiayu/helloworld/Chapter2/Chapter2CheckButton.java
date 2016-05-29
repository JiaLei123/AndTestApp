package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jiayu.helloworld.R;

public class Chapter2CheckButton extends AppCompatActivity {

    RadioGroup rg;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_check_button);

        rg = (RadioGroup) findViewById(R.id.rg);
        show = (TextView) findViewById(R.id.show);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tip = checkedId == R.id.male ? "You choice Male": "You Choice Female";
                show.setText(tip);
            }
        });


    }
}
