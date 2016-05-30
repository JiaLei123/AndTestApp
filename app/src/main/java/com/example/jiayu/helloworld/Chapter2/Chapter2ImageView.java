package com.example.jiayu.helloworld.Chapter2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jiayu.helloworld.R;

public class Chapter2ImageView extends AppCompatActivity {

    int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi,
    };

    int currentImg = 2;
    private int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_image_view);

        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);
        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImg % images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (v == plus) {
                    alpha += 20;
                }

                if (v == minus) {
                    alpha -= 20;
                }
                if (alpha >= 255) {
                    alpha = 255;
                }
                if (alpha <= 0) {
                    alpha = 0;
                }

                image1.setAlpha(alpha);
            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        image1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                if (x + 60 > bitmap.getWidth()) {
                    x = bitmap.getWidth() - 60;
                }
                if (y + 60 > bitmap.getHeight()) {
                    y = bitmap.getHeight() - 60;
                }

                image2.setImageBitmap(Bitmap.createBitmap(bitmap, x - 120, y, 120, 120));
                image2.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
