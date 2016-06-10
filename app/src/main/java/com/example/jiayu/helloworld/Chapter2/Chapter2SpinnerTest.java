package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jiayu.helloworld.R;

public class Chapter2SpinnerTest extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_spinner_test);

        spinner = (Spinner) findViewById(R.id.spinner);
        String[] arr = {"孙悟空", "猪八戒", "唐僧"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
        spinner.setAdapter(adapter);
    }
}
