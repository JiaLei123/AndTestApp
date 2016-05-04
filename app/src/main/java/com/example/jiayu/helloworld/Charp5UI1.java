package com.example.jiayu.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Charp5UI1 extends AppCompatActivity {


    int[] images = new int[]{
            R.drawable.car,
            R.drawable.car1,
            R.drawable.road,
            R.drawable.road1
    };

    int currentImg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charp5_ui1);

        LinearLayout main = (LinearLayout) findViewById(R.id.Charp5Root);

        final ImageView image = new ImageView(this);

        main.addView(image);

        image.setImageResource(images[0]);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(images[++currentImg % images.length]);
            }
        });




    }
}
