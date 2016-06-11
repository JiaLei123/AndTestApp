package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.jiayu.helloworld.R;

public class Chapter2RatingBar extends AppCompatActivity {

    RatingBar rating;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_rating_bar);

        rating = (RatingBar) findViewById(R.id.rating);
        imageView = (ImageView) findViewById(R.id.image);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                imageView.setImageAlpha((int)( rating * 255 / 5));
            }
        });
    }
}
