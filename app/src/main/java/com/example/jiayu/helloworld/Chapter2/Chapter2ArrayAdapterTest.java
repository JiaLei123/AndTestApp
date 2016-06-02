package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jiayu.helloworld.R;


public class Chapter2ArrayAdapterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_array_adapter_test);
        ListView list1 = (ListView) findViewById(R.id.list1);
        String[] arr1 = {"孙悟空", "猪八戒", "牛魔王"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.array_item, arr1);

        list1.setAdapter(adapter1);

        ListView list2 = (ListView) findViewById(R.id.list2);
        String[] arr2 = {"Java", "Hibernate", "Spring", "Android"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.checked_item, arr2);
        list2.setAdapter(adapter2);
    }
}
