package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.jiayu.helloworld.R;

public class Chapter2ToggleButton extends AppCompatActivity {

    ToggleButton toggle;
    Switch switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_toggle_button);

        toggle = (ToggleButton) findViewById(R.id.toggle);
        switcher = (Switch) findViewById(R.id.switcher);
        final LinearLayout test = (LinearLayout) findViewById(R.id.toggle_test);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    test.setOrientation(1);
                    toggle.setChecked(true);
                    switcher.setChecked(true);
                }
                else
                {
                    test.setOrientation(0);
                    toggle.setChecked(false);
                    switcher.setChecked(false);
                }
            }
        };
        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);

    }
}
