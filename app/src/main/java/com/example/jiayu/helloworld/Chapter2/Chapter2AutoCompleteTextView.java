package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.jiayu.helloworld.R;

public class Chapter2AutoCompleteTextView extends AppCompatActivity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;

    String[] books = new String[]{
            "Crazy Java",
            "Crazy Ajax",
            "Crazy XML",
            "Crazy WorkFlow"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_auto_complete_text_view);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, books);
        actv = (AutoCompleteTextView) findViewById(R.id.auto);
        actv.setAdapter(aa);

        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
