package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.example.jiayu.helloworld.R;

public class Chapter2ViewFlipper extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_view_flipper);

        viewFlipper = (ViewFlipper) findViewById(R.id.details);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void prev(View source) {
//        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
//        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void next(View view) {
//        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
//        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }

    public void auto(View source) {
//        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
//        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.startFlipping();
    }

}
