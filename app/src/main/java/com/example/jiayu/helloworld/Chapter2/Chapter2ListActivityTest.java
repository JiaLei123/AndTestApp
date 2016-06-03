package com.example.jiayu.helloworld.Chapter2;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Chapter2ListActivityTest extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arr = {"孙悟空", "猪八戒", "牛魔王"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout, arr);
        setListAdapter(adapter);

    }
}
