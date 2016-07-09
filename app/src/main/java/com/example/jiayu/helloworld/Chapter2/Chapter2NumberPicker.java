package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.jiayu.helloworld.R;

public class Chapter2NumberPicker extends AppCompatActivity {

    NumberPicker np1, np2;
    int minPrice = 25;
    int maxPrice = 75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_number_picker);

        np1 = (NumberPicker) findViewById(R.id.np1);
        np1.setMinValue(10);
        np1.setMaxValue(50);
        np1.setValue(minPrice);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice = newVal;
                showSelectedPrice();
            }
        });

        np2 = (NumberPicker) findViewById(R.id.np2);
        np2.setMaxValue(100);
        np2.setMinValue(60);
        np2.setValue(maxPrice);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice = newVal;
                showSelectedPrice();
            }
        });
    }

    private void showSelectedPrice() {
        Toast.makeText(this, "你选择最低价格为：" + minPrice + "，最高价格为：" + maxPrice, Toast.LENGTH_SHORT).show();
    }
}
