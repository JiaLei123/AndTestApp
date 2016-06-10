package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.jiayu.helloworld.R;

public class Chapter2AdapterViewFlipper extends AppCompatActivity {


    int[] imageIds = new int[]
            {
                    R.drawable.shuangzi, R.drawable.shuangyu, R.drawable.tianxie,
                    R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
                    R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
                    R.drawable.mojie
            };

    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_adapter_view_filpper);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(Chapter2AdapterViewFlipper.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        };

        flipper.setAdapter(adapter);
    }

    public void prey(View source) {
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View source) {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source) {
        flipper.startFlipping();
    }

}
