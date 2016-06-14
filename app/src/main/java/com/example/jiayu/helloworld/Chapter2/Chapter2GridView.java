package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.jiayu.helloworld.R;
import com.example.jiayu.helloworld.Uiltity.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter2GridView extends AppCompatActivity {

    GridView grid;
    ImageView imageView;

    int[] imageIds = Constants.Bomb_Images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_grid_view);

        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i =0; i < imageIds.length; i++){
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image1});

        imageView = (ImageView) findViewById(R.id.imageView);
        grid = (GridView) findViewById(R.id.grid01);
        grid.setAdapter(simpleAdapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }
        });

        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
