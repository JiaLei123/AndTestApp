package com.example.jiayu.helloworld.Chapter2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jiayu.helloworld.MainActivity;
import com.example.jiayu.helloworld.R;

import java.util.List;


public class Chapter2BaseAdapter extends AppCompatActivity {

    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_base_adapter);

        myList = (ListView) findViewById(R.id.mylist);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(Chapter2BaseAdapter.this);
                line.setOrientation(LinearLayout.VERTICAL);
                ImageView image = new ImageView(Chapter2BaseAdapter.this);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = new TextView(Chapter2BaseAdapter.this);
                text.setText("第" + (position +1) + "个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };

        myList.setAdapter(adapter);
    }
}
