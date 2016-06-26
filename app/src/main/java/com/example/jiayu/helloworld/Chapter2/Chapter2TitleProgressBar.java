package com.example.jiayu.helloworld.Chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.jiayu.helloworld.R;

public class Chapter2TitleProgressBar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(R.layout.activity_chapter2_title_progress_bar);

        Button bn1 = (Button) findViewById(R.id.bn1);
        Button bn2 = (Button) findViewById(R.id.bn2);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);

                setProgress(4500);
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarVisibility(false);
                setProgressBarIndeterminateVisibility(false);
            }
        });





    }
}
