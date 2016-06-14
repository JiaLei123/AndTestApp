package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.example.jiayu.helloworld.R;
import com.example.jiayu.helloworld.Uiltity.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter2StackView extends AppCompatActivity {

    int[] imageIds = Constants.Bomb_Images;
    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_stack_view);

        stackView = (StackView) findViewById(R.id.mStackView);

        List<Map<String, Object>> listItems = new ArrayList<>();
        for(int i=0; i<imageIds.length;i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image1});

        stackView.setAdapter(simpleAdapter);
    }

    public void prev(View source) {
       stackView.showPrevious();
    }

    public void next(View source) {
        stackView.showNext();
    }
}
